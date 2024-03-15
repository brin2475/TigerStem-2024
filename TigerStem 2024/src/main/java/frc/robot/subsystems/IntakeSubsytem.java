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
import frc.robot.constants.intakeConstants;


public class IntakeSubsytem extends SubsystemBase {
  /** Creates a new Intake. */
  
  private CANSparkMax PivotR, PivotL, intakeMotor, feedLeft, feedRight;
  private Encoder pivotEncoder;

  
  public IntakeSubsytem() {
    PivotR = new CANSparkMax(intakeConstants.PivotR, MotorType.kBrushless);
    PivotL = new CANSparkMax(intakeConstants.PivotL, MotorType.kBrushless);
     
    intakeMotor = new CANSparkMax(intakeConstants.intakeMotor, MotorType.kBrushless);
    feedLeft = new CANSparkMax(intakeConstants.feedLeft,MotorType.kBrushed );
    feedRight = new CANSparkMax(intakeConstants.feedRight, MotorType.kBrushed);
    pivotEncoder = new Encoder(0, 1);
  
    feedLeft.restoreFactoryDefaults();
    feedRight.restoreFactoryDefaults();
    PivotR.restoreFactoryDefaults();
    PivotL.restoreFactoryDefaults();
    intakeMotor.restoreFactoryDefaults();
    

    feedRight.follow(feedLeft, true);
    PivotR.follow(PivotL, true );


    PivotR.enableSoftLimit(SoftLimitDirection.kReverse, true);
    //PivotR.setSoftLimit(SoftLimitDirection.kForward, constants.cannon.Cpivot);

    //PivotR.setSoftLimit(SoftLimitDirection.kForward, );
    
  }
   public void setPivotSpeed(double pivotSpeed){
    PivotR.set(pivotSpeed);
    
  }

  public double  setRollerSpeed(double intakeSpeed){
    intakeMotor.set(intakeSpeed);
    return intakeSpeed;
  }

  

  public double setFeedSpeed(double feedspeed){
    feedLeft.set(feedspeed);
    return feedspeed;
  }
  public double getEncoderDegrees(){
    return pivotEncoder.get() * intakeConstants.encoderTick2Degrees;

  }

  
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Angle of intake", getEncoderDegrees());
   }




}