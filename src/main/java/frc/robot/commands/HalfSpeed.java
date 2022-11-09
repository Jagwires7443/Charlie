package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotMap;

public class HalfSpeed extends CommandBase {

    public HalfSpeed() {
    }

    public void initialize() {
        System.out.println("[Command] Switching to half speed");
    }

    public void execute() {
        OI.setSpeed(RobotMap.ROBOT_SPEED * .75);
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
