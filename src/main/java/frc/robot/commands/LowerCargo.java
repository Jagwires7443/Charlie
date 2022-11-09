package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class LowerCargo extends CommandBase {

    public LowerCargo() {
    }

    public void initialize() {
        System.out.println("[Command] Lower Cargo");
    }

    public void execute() {
        Robot.m_piston.lowerCargo();
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        System.out.println("[Command] Finished Lower Cargo");
    }

    public boolean isFinished() {
        return true;
    }
}
