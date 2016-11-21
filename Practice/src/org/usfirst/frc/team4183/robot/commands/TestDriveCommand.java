
package org.usfirst.frc.team4183.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4183.robot.Robot;
import org.usfirst.frc.team4183.robot.RobotMap;

/**
 *
 */
public class TestDriveCommand extends Command
{
    public TestDriveCommand()
    {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        // When this command starts we want the brake mode enabled on
        // the drive system to ensure that stops are as quick as possible
        Robot.driveSubsystem.configureBrakeMode(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        // Just drive slowly in a circle until we are told otherwise
        Robot.driveSubsystem.autoDrive(RobotMap.FORWARD * 0.2, 
                                       RobotMap.LEFT * 1.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
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
        end();
    }
}
