package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class LiftCargo extends CommandBase {

    public LiftCargo() {
    }

    public void initialize() {
        System.out.println("[Command] Lifting Cargo");
    }

    public void execute() {
        Robot.m_piston.liftCargo();
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        System.out.println("[Command] Finished Lifting Cargo");
    }

    public boolean isFinished() {
        return true;
    }
}
