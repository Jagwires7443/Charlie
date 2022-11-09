package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ReturnPiston extends CommandBase {

    public ReturnPiston() {
    }

    public void initialize() {
        System.out.println("[Command] Returning Piston...");
    }

    public void execute() {
        Robot.m_piston.returnPiston();
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        System.out.println("[Command] Finished returning Piston");
    }

    public boolean isFinished() {
        return true;
    }
}
