// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class constants {

  //controller ids
  public static class OperatorConstants
    {
     
    public static final int Driver = 0;
    public static final int coDriver = 1;
   
  
  }

  //CANbus ids
  public static class driveTrainConstants
  {
    public static final int Left1 = 1;
    public static final int Left2 = 2;

    public static final int Right1 = 3;
    public static final int Right2 = 4;

    public static final double RATE_LIMIT = 3;
  }


  public static class cannonConstants
  {
    public static final int cannonR = 5;
    public static final int cannonL = 6;
    public static final int Cpivot = 7;
    

        public static final int kEncoderChannelA = 0;
        public static final int kEncoderChannelB = 1;
        public static final double encoderTick2Degrees =  360.0 / 8192.0;
        public static final float CannonSL = 0;
        public static final double kP = 3;
        public static final double kI = 0;
        public static final double kD = 0.8;

        public static final double StartPos  = 0.5;
        public static final double shootingPos  = 1.2;
        public static final double PassPos = 0;
  }

  public static class intakeConstants
  {
    public static final int PivotL = 8;
    public static final int PivotR = 9;
    
    public static final int intakeMotor = 10;
    public static final int feedLeft = 11;
    public static final int feedRight = 12;

      public static final int kEncoderChannelA = 2;
        public static final int kEncoderChannelB = 3;
        public static final double encoderTick2Degrees =  360.0 / 8192.0;
        public static final float  intakeSL = 0;
        public static final double kP = 3;
        public static final double kI = 0;
        public static final double kD = 0.8;

        public static final double StartPos  = 0.5;
        public static final double loadingPos  = 1.2;
        public static final double PassPos = 0;
        public static final int RollerButton = 1;
        public static final int FeedButton = 2;
       public static final int  rollersAndFeed = 3;
        

  }

  
  
}