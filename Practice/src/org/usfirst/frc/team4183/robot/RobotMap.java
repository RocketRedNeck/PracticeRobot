package org.usfirst.frc.team4183.robot;

import com.ctre.CANTalon;


/**
 * The RobotMap contains all robot specific constants and mapping from the ports sensors and actuators 
 * are wired into to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    // **********************************************************************
    // Physical constants
    // **********************************************************************
    public static final double WHEEL_DIAMETER_m = 0.2286;  // 9 inch tire
    public static final double WHEEL_RADIUS_m = WHEEL_DIAMETER_m / 2.0;
    
    public static final double WHEEL_TRACK_m = 0.4572;     // 18 inches center to center... []<--track-->[]
                                                           //                                      ^
                                                           //                                      |
                                                           //                                      |
                                                           //                                      |
                                                           //                                      |
                                                           //                               []<--track-->[]
    
    public static final double TRACK_TO_DIAMETER = WHEEL_DIAMETER_m / WHEEL_TRACK_m;  // Multiply by this to
                                                                                      // convert wheel angle to
                                                                                      // body angle for rotation
    public static final double DIAMETER_TO_TRACK = 1.0 / TRACK_TO_DIAMETER;
    
    public static final double WHEEL_TO_ENCODER = 3.0;  // 1 rotation of wheel = 3 rotations of encoder
                                                        // This ratio was determined experimentally but
                                                        // should also be derivable by checking gear
                                                        // and sprocket ratios
    
    // NOTE: In some cases the concept of forward and backward can get confusing
    // due to wiring and gearing; once established it is nice to not need to remember
    // whether the command needs to be + or -
    // To make this easier we simply define constants to be used as a command multiplier
    public static final double FORWARD  = -1.0;
    public static final double BACKWARD =  1.0;
    public static final double RIGHT    = -1.0;
    public static final double LEFT     =  1.0;
    
    // **********************************************************************
    // Encoder type and scalings
    // NOTE: There are a couple of options for using wheelToEncoder and drivePulsesPerRev
    // since what we really want to control is wheel rotations. It is probably safer to
    // build an interface that takes body distance or angle, converts to wheel angle, then
    // converts to encoder rotations, then commands the controller.
    // **********************************************************************
    
    // When setting up motor controller object, the encoder scaling is used
    // to communicate position and velocity information in units of rotations
    // rather than code pulses.
    public static final CANTalon.FeedbackDevice DRIVE_ENCODER_TYPE = CANTalon.FeedbackDevice.QuadEncoder;
    public static final int DRIVE_PULSES_PER_REV = 1024;     // AMT103 can do up to 2048 but this is 
                                                             // current DIP switch settings
    
    
    // **********************************************************************
    // PID Constants
    // **********************************************************************
    
    public static final double DRIVE_POSITION_P = 0.2;  // To be tuned as needed
    public static final double DRIVE_POSITION_I = 0.0;
    public static final double DRIVE_POSITION_D = 0.0;
    public static final double DRIVE_POSITION_F = 0.0;   
    
    public static final double DRIVE_SPEED_P = 0.2;  // To be tuned as needed
    public static final double DRIVE_SPEED_I = 0.0;
    public static final double DRIVE_SPEED_D = 0.0;
    public static final double DRIVE_SPEED_F = 0.0;   
    
    // **********************************************************************
    // Port Assignment
    // **********************************************************************
    // These are the current CAN port assignments for the practice robot.
    public static int leftMotor0 = 2;
    public static int leftMotor1 = 1;

    public static int rightMotor0 = 9;
    public static int rightMotor1 = 10;

    public static int unusedMotor0 = 6;
    public static int unusedMotor1 = 7;
    public static int unusedMotor2 = 8;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
