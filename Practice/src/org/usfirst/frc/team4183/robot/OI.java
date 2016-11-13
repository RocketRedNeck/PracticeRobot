package org.usfirst.frc.team4183.robot;

/**
 * The following packages are needed by our operator interface
 */
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;

// LATER when we need buttons we will want to bind buttons to commands
//import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import org.usfirst.frc.team4183.robot.commands.SomeCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * This class was created by the default Command-based project and is
 * instantiated in our Robot class (also already there in the project)
 * 
 * We modify it to a static interface since there really can only be one
 * and there is no point to managing unique instances (This is similar
 * to how the SmartDashboard class is defined.
 */
public class OI
{
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    /**
     * Using the examples, above, we simply want a single controller for the
     * moment. NOTE: that a Joystick is really a modern controller on the USB 
     * port of a driver station. It is this "Joystick" object that has access 
     * to all of the two-axis joysticks and buttons on the controller.
     * 
     * In our case we want to be clear and will define the "Joystick" to be part
     * of our drive control chain and will use naming conventions, internally,
     * to indicate that we are addressing the drive control and assigned
     * functions.
     * 
     * FURTHER, we desired a decoupled solution to the operator interface
     * so will consider keeping the internal details hidden... e.g., the
     * caller does not really need direct access to the Joystick object
     * we create here... the only thing that the Robot will require is
     * this OI class and the static interfaces we provide to represent
     * the functions we intend
     */

    private static final Joystick driveControl = new Joystick(0);

    // Provide better names for each joystick axis
    
    // RIGHT THUMB DRIVE CONTROL ON SINGLE JOYSTICK
    private static final AxisType speedCommandAxis = AxisType.kTwist; // forward/backward
                                                                      // on RIGHT joystick
                                                                      // of DualShock 4
    private static final AxisType turnCommandAxis = AxisType.kZ;      // left/right
                                                                      // on RIGHT joystick of
                                                                      // DualShock 4

    /**
     * getDriveSpeedCoefficient returns a value between -1 and +1 from
     * the operator interface defined to provide drive speed control
     */
    public static double getDriveSpeedCoefficient()
    {
        return driveControl.getAxis(speedCommandAxis);
    }
    
    /**
     * getTurnSpeedCoefficient returns a value between -1 and +1 from
     * the operator interface defined to provide turn control
     */
    public static double getTurnSpeedCoefficient()
    {
        return driveControl.getAxis(turnCommandAxis);
    }    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
