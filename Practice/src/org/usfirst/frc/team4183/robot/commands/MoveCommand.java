package org.usfirst.frc.team4183.robot.commands;

import org.usfirst.frc.team4183.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class MoveCommand extends Command 
{
    private static double METERS;
    public MoveCommand(double meters) 
    {
        METERS = meters;    // The simple way to remember between cycles
        
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        // Initialization and execution of the position maintenance
        // is the same function call. The first call will change
        // the subsystem mode internally, but position maintenance
        // must be called repeatedly (execute) to hold the position
        // with force
        Robot.driveSubsystem.maintainPosition(METERS);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        Robot.driveSubsystem.maintainPosition(METERS);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        // Return true when motors reached the desired distance
        return Robot.driveSubsystem.areWeThereYet(METERS);
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
