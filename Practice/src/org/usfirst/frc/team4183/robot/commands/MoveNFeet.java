package org.usfirst.frc.team4183.robot.commands;

import org.usfirst.frc.team4183.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class MoveNFeet extends Command 
{
    private static double FEET_TO_MOVE;
    public MoveNFeet(double feet) 
    {
        FEET_TO_MOVE = feet;
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        // Slave motors and set position control
        // When this command starts we want the brake mode enabled on
        // the drive system to ensure that stops are as quick as possible
        Robot.driveSubsystem.enablePositionMode();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        
        // Return true when motors reached the desired distance
        
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.driveSubsystem.disablePositionMode();
        Robot.driveSubsystem.autoDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        
        end();      
    }
}
