package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class LowerFront extends CommandBase {

    public LowerFront() {
    }

    public void initialize() {
        System.out.println("[Command] Returning Cargo...");
    }

    public void execute() {
        Robot.m_piston.lowerFront();
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        System.out.println("[Command] Finished returning Cargo");
    }

    public boolean isFinished() {
        return true;
    }
}
