package org.usfirst.frc.team4183.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4183.robot.RobotMap;
import org.usfirst.frc.team4183.robot.commands.MoveCommand;
import org.usfirst.frc.team4183.robot.commands.TurnCommand;

/**
 *
 */
public class SquareCommand extends CommandGroup {
    
    public  SquareCommand() 
    {
        for (int i = 0; i < 4; ++i)
        {
            addSequential(new MoveCommand(RobotMap.FORWARD * 2.0, 0.05));
            addSequential(new TurnCommand(RobotMap.RIGHT * 90.0, 1.0));
        }
    }
}
