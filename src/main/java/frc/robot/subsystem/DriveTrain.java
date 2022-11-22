package frc.robot.subsystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
// import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {

    // Motors
    private CANSparkMax m_FrontLeftMotor;
    private CANSparkMax m_FrontRightMotor;
    private CANSparkMax m_BackLeftMotor;
    private CANSparkMax m_BackRightMotor;

    // Encoders
    // private RelativeEncoder m_FrontLeftMotor_Encoder;
    // private RelativeEncoder m_FrontRightMotor_Encoder;
    // private RelativeEncoder m_BackLeftMotor_Encoder;
    // private RelativeEncoder m_BackRightMotor_Encoder;

    private DifferentialDrive m_RobotDrive;

    public DriveTrain() {

        // Initialize Motors
        m_FrontLeftMotor = new CANSparkMax(RobotMap.LEFT_FRONT_MOTOR_ID, MotorType.kBrushless);
        // m_FrontLeftMotor.restoreFactoryDefaults();
        m_FrontLeftMotor.setOpenLoopRampRate(.75);
        // m_FrontLeftMotor_Encoder = m_FrontLeftMotor.getEncoder();

        m_FrontRightMotor = new CANSparkMax(RobotMap.RIGHT_FRONT_MOTOR_ID, MotorType.kBrushless);
        // m_FrontRightMotor.restoreFactoryDefaults();
        m_FrontRightMotor.setOpenLoopRampRate(.75);
        // m_FrontRightMotor_Encoder = m_FrontRightMotor.getEncoder();

        m_BackLeftMotor = new CANSparkMax(RobotMap.LEFT_BACK_MOTOR_ID, MotorType.kBrushless);
        // m_BackLeftMotor.restoreFactoryDefaults();
        m_BackLeftMotor.setOpenLoopRampRate(.75);
        // m_BackLeftMotor_Encoder = m_BackLeftMotor.getEncoder();

        m_BackRightMotor = new CANSparkMax(RobotMap.RIGHT_BACK_MOTOR_ID, MotorType.kBrushless);
        // m_BackRightMotor.restoreFactoryDefaults();
        m_BackRightMotor.setOpenLoopRampRate(.75);
        // m_BackRightMotor_Encoder = m_BackRightMotor.getEncoder();

        MotorControllerGroup leftMotors = new MotorControllerGroup(m_FrontLeftMotor, m_BackLeftMotor);
        MotorControllerGroup rightMotors = new MotorControllerGroup(m_FrontRightMotor, m_BackRightMotor);

        m_RobotDrive = new DifferentialDrive(leftMotors, rightMotors);

        SmartDashboard.putNumber("Ramp Rate", m_FrontRightMotor.getOpenLoopRampRate());
    }

    public void tankDrive(double leftPower, double rightPower) {
        m_RobotDrive.tankDrive(leftPower, rightPower);
        // System.out.println("Power: " + leftPower + " " + rightPower);
        SmartDashboard.putNumber("Front Left Output ", m_FrontLeftMotor.getAppliedOutput());
        SmartDashboard.putNumber("Front Right Output ", m_FrontRightMotor.getAppliedOutput());
        SmartDashboard.putNumber("Back Left Output ", m_BackLeftMotor.getAppliedOutput());
        SmartDashboard.putNumber("Back Right Output ", m_BackRightMotor.getAppliedOutput());
    }
}
