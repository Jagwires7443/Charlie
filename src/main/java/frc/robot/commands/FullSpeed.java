package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotMap;

public class FullSpeed extends CommandBase {

    public FullSpeed() {
    }

    public void initialize() {
        System.out.println("[Command] Switching to full speed");
    }

    public void execute() {
        OI.setSpeed(RobotMap.ROBOT_SPEED);
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        System.out.println("[Command] Switching gears");
    }

    public boolean isFinished() {
        return true;
    }
}
