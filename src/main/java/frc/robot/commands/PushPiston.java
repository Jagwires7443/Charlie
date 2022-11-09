package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class PushPiston extends CommandBase {

    public PushPiston() {
    }

    public void initialize() {
        System.out.println("[Command] Pushing Hatch");
    }

    public void execute() {
        Robot.m_piston.pushHatch();
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        System.out.println("[Command] Finished pushing Hatch");
    }

    public boolean isFinished() {
        return true;
    }
}
