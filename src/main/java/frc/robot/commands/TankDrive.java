package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDrive extends CommandBase {

    public TankDrive() {
        addRequirements(Robot.m_driveTrain);
    }

    public boolean isFinished() {
        return false;
    }

    public void execute() {
        Robot.m_driveTrain.tankDrive(Robot.oi.getLeftYAxis(), Robot.oi.getRightYAxis());
    }

    public void stop() {
        Robot.m_driveTrain.tankDrive(0, 0);
    }
}
