// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.constants.driveTrainConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private TalonFX Left1, Left2, Right1, Right2;
  private DifferentialDrive drive;
  
  

  public DriveSubsystem() {
    Left1 = new TalonFX(driveTrainConstants.Left1);
    Left2 = new TalonFX(driveTrainConstants.Left2);
    Right1 = new TalonFX(driveTrainConstants.Right1);
    Right2 = new TalonFX(driveTrainConstants.Right2);    
    
    
  Left1.setControl(new Follower(Left2.getDeviceID(), false));
  Right1.setControl(new Follower(Right2.getDeviceID(), false));


  


    
    
<<<<<<< HEAD
=======

    
>>>>>>> 11f0e2b07626a59c75b58f947597990bfca42dd7
    drive = new DifferentialDrive(Left2, Right2);
    
    //disables motor saftey so we can have full motor performance 
    drive.setSafetyEnabled(false);
  }


  public void teleop(double speed, double Rotation) {
    drive.arcadeDrive(speed, Rotation);
  }

  public void autoDrive(double speed, double Rotation) {

    teleop(Rotation, speed);
 
  }

  public void stop() {
    drive.stopMotor();
 
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}