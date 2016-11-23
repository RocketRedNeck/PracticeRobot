package org.usfirst.frc.team4183.robot.commands;

import org.usfirst.frc.team4183.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnCommand extends Command {

    private double orientation_deg;
    private double tolerance_deg;
    
    public TurnCommand(double anOrientation_deg, double aTolerance_deg) 
    {
        orientation_deg = anOrientation_deg;
        tolerance_deg = aTolerance_deg;
        
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        // Initialization and execution of the orientation maintenance
        // is the same function call. The first call will change
        // the subsystem mode internally, but orientation maintenance
        // must be called repeatedly (execute) to hold the orientation
        // with force
        Robot.driveSubsystem.maintainOrientation(orientation_deg);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        Robot.driveSubsystem.maintainOrientation(orientation_deg);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return Robot.driveSubsystem.atOrientation(orientation_deg, tolerance_deg);
    }

    // Called once after isFinished returns true
    protected void end() 
    {
        Robot.driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
        end();  // Just call end unless there is some special case at an interrupt boundary
    }
}
