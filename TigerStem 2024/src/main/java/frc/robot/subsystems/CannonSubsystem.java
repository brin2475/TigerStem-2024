// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.SoftLimitDirection;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants;

public class CannonSubsystem extends SubsystemBase {
  /** Creates a new Cannon. */

  

  
  private CANSparkMax cannonL, cannonR, Pivot;
  private Encoder encoder;
  
  public CannonSubsystem() {
    cannonL = new CANSparkMax(constants.cannonConstants.cannonL, MotorType.kBrushless);
    cannonR = new CANSparkMax(constants.cannonConstants.cannonR, MotorType.kBrushless);
    Pivot = new CANSparkMax(constants.cannonConstants.Cpivot, MotorType.kBrushless);
    encoder = new Encoder(0,1);
    
    

    cannonL.restoreFactoryDefaults();
    cannonR.restoreFactoryDefaults();
    Pivot.restoreFactoryDefaults();
    

    cannonL.follow(cannonR);

    Pivot.enableSoftLimit(SoftLimitDirection.kReverse, true);
    Pivot.setSoftLimit(SoftLimitDirection.kForward, constants.cannonConstants.Cpivot);

    //Pivot.setSoftLimit(SoftLimitDirection.kForward, constants.cannon.CannonSL);
  }

  public void setPivotSpeed(double speed){
    Pivot.set(speed);
  }

  public void TeleopPivot(double speed){
    Pivot.set(speed);
  }

  public double getEncoderDegrees(){
    return encoder.get() * constants.cannonConstants.encoderTick2Degrees;

  }

  
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Angle of Cannon", getEncoderDegrees());


   }

}

