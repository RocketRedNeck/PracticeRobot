package org.usfirst.frc.team4183.robot;


/**
 * The RobotMap contains all robot specific constants and mapping from the ports sensors and actuators 
 * are wired into to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    public static double wheelTrack_m = 0.4572;  // 18 inches
    
    // These are the current assignments for the practice robot.
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
