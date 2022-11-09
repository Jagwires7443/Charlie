// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// import edu.wpi.cscore.UsbCamera;
// import edu.wpi.cscore.VideoSource;
// import edu.wpi.first.cameraserver.CameraServer;
// import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.subsystem.DriveTrain;
import frc.robot.subsystem.Piston;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  public static OI oi;
  public static DriveTrain m_driveTrain;
  public static Piston m_piston;
  AHRS m_ahrs;
  Compressor m_compressor;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    oi = new OI();
    m_driveTrain = new DriveTrain();
    m_piston = new Piston();
    try {
      m_ahrs = new AHRS(SPI.Port.kMXP);
    } catch (RuntimeException ex) {
      DriverStation.reportError("Error with navX: " + ex.getMessage(), true);
    }

    SmartDashboard.putBoolean("NavX Connection: ", m_ahrs.isConnected());
    SmartDashboard.putBoolean("NavX Calibrating: ", m_ahrs.isCalibrating());
    SmartDashboard.putNumber("Heading: ", m_ahrs.getCompassHeading());
    SmartDashboard.putNumber("Pitch: ", m_ahrs.getPitch());
    SmartDashboard.putNumber("Roll: ", m_ahrs.getRoll());
    SmartDashboard.putNumber("Yaw: ", m_ahrs.getYaw());
    SmartDashboard.putNumber("Angle: ", m_ahrs.getAngle());

    m_compressor = new Compressor(RobotMap.PCM_PORT, PneumaticsModuleType.CTREPCM);
    m_compressor.enableDigital();

    // camera1 = CameraServer.getInstance().startAutomaticCapture(0);
    // camera1.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    // camera1.setFPS(25);
    // camera1.setBrightness(25);
    // camera1.setExposureManual(10);
    // camera1.setWhiteBalanceManual(10);

    // camera2 = CameraServer.getInstance().startAutomaticCapture(1);
    // camera2.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    // camera2.setFPS(25);
    // camera2.setBrightness(25);
    // camera2.setExposureManual(10);
    // camera2.setWhiteBalanceManual(10);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items
   * like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different
   * autonomous modes using the dashboard. The sendable chooser code works with
   * the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the
   * chooser code and
   * uncomment the getString line to get the auto name from the text box below the
   * Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure
   * below with additional strings. If using the SendableChooser make sure to add
   * them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {
  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {
  }
}
