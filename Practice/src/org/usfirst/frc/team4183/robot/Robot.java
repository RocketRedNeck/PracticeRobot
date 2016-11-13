
package org.usfirst.frc.team4183.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// These imports are specific to our robot, rather than the
// above items that were added by the Command-based project wizard
import java.lang.Math;
import org.usfirst.frc.team4183.robot.OI;
import org.usfirst.frc.team4183.robot.commands.DoNothingCommand;
import org.usfirst.frc.team4183.robot.commands.TestDriveCommand;
import org.usfirst.frc.team4183.robot.subsystems.DriveSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot 
{

	// The project wizard created most of these declarative lines
	// In our case we changed the ExampleSubsystem to the DriveSbsystem
    
    // We only ever need exactly one drive subsystem
	public static final DriveSubsystem driveSubsystem = new DriveSubsystem(RobotMap.wheelBase_m);
	
	// The operator interface (OI) instance was added by the Command-based
	// project wizard. It is just the place "they" expect us to add our
	// operator interfaces (Controllers with joysticks and buttons)
	//
	// In our modification the OI is a static interface (because there
	// is only one and there are no members that need to be unique
	// for multiple OIs)... as a result there is no need to instantiate it

	// This Command object and "chooser" was also added by the wizard
	// We can use this command object to initialize an autonomous
	// mode with a user-selectable choice. The FRC driver station
	// has a "dashboard" available under the "Setup" menu. The
	// "java dashboard" will display a "radio button" list of items
	// we transmit from our SendableChooser. When the operator
	// selects a setting we can initialize our autonomousCommand
	// to the selection
    Command autonomousCommand;
    SendableChooser chooser = new SendableChooser();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
    	// Add items to the dashboard menu for the user to select
        chooser.addDefault("Default Auto", new DoNothingCommand());
        chooser.addObject( "Auto Test Drive", new TestDriveCommand());
        
        // Send the choose data to the dashboard so the user
        // will see the available choices
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit()
    {

    }
	
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() 
    {
    	// The following selects the user's choice from the Java SmartDashboard
        autonomousCommand = (Command) chooser.getSelected();
        
        // The following commented out example is how to use the LabVIEW Dashboard
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit() 
    {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        
        // This is where we need to put code to read the controllers (joysticks)
        // and pass a controlled value to the driveSubsystem
        // 
        // A single joystick solution that provides a balance between
        // turning and moving; when forward/backward speed is low, more
        // power is passed into turning (i.e., variable speed power steering)
        // In this example the variable steering will be a simple linear function
        // starting at 50% power when maximum forward/backward is commanded.
        //
        // NOTE: The API documentation is NOT clear about the range of the values
        // when getting the axes. However, digging deep into the DriverStation
        // class where the raw port is read we find that the byte-oriented interface
        // is scaled to -1 to +1 (as a double). This makes the math simple
        //
        // NOTE: We use named mappings to improve maintenance and readability
        // NOTE: We grab a copy of the value "now" so all subsequent computations
        // represent this moment in time (or as near a moment as we can get)
        double speedCoefficient = OI.getDriveSpeedCoefficient();
        double turnCoefficient  = OI.getTurnSpeedCoefficient();
        
        // Create a linear decay of turning power where 100% power into the turn when no speed
        // but never more than 50% power into the turn when commanding max speed.
      	double maxTurnFactor = 1.0 - Math.abs(speedCoefficient) / 2.0;
      	double modifiedTurnCoefficient = (maxTurnFactor * turnCoefficient);
      	
      	// Pass our desired speed/turn values to the drive subsystem
      	driveSubsystem.arcadeDrive(speedCoefficient, modifiedTurnCoefficient);
      	
      	// To allow us to monitor what is going on each time
      	// the function runs, we will output something to the SmartDashboard
      	//
      	// NOTE: Ideally we don't to slow down control functions for telemetry, but we will
      	// use the framework as designed and will examine how SmartDashboard
      	// works, later.
      	SmartDashboard.putNumber("speedCoefficient",speedCoefficient);
      	SmartDashboard.putNumber("turnCoefficient",turnCoefficient);
      	SmartDashboard.putNumber("modifiedTurnCoefficient",modifiedTurnCoefficient);
      	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
