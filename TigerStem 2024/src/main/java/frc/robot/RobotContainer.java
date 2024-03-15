// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.LeaveHabitat;
import frc.robot.constants.intakeConstants;
import frc.robot.subsystems.CannonSubsystem;
//import frc.robot.subsystems.CannonSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsytem;
//import frc.robot.subsystems.IntakeSubsytem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually Pbe handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {


  private final DriveSubsystem driveTrain = new DriveSubsystem();
  private final CannonSubsystem cannon = new CannonSubsystem();
 private final IntakeSubsytem intake = new IntakeSubsytem(); 
 
 
  

  private static final Joystick driver = new Joystick(constants.OperatorConstants.Driver);
  private static final Joystick coDriver = new Joystick(constants.OperatorConstants.coDriver);

  // creates my Automode chooser obj for autonomous selection before matches
  private static SendableChooser<SequentialCommandGroup> AutoModeChooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    driveTrain.setDefaultCommand(
        new RunCommand(
            () -> driveTrain.teleop(driver.getZ(), -driver.getY()/2), driveTrain)
          );


     intake.setDefaultCommand(
         new RunCommand(
             () -> intake.setPivotSpeed(coDriver.getY()/5), intake )
           );

    // Configure the trigger bindings

    configureBindings();

    AutoModeChooser();

    defaultShuffleboardTab();
  }

  private void configureBindings() {
    JoystickButton Rollers = new JoystickButton(coDriver, intakeConstants.RollerButton);
    JoystickButton Feed = new JoystickButton(coDriver, intakeConstants.FeedButton);
    JoystickButton rollersAndFeed = new JoystickButton(coDriver, intakeConstants.rollersAndFeed);
  
    

      

      Rollers.toggleOnTrue(Commands.startEnd(() ->  intake.setRollerSpeed( .35),
       () ->  intake.setRollerSpeed(0)
       ,
        intake));


        Feed.toggleOnTrue(Commands.startEnd(() ->  intake.setFeedSpeed( -1.00
        ),
       () ->  intake.setFeedSpeed(0)
       ,
        intake));


        rollersAndFeed.onTrue(new ParallelCommandGroup(
        
        new RunCommand(() -> intake.setRollerSpeed(0.50), intake
      ),
         new RunCommand(() -> intake.setFeedSpeed(1.00), intake
    )
  ));

}
    

  private void AutoModeChooser() {
    AutoModeChooser.setDefaultOption("Leave habitat", new LeaveHabitat(driveTrain ));
    
  
 
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return AutoModeChooser.getSelected();
  }

  public void defaultShuffleboardTab() {
    Shuffleboard.selectTab("SmartDashboard");
    SmartDashboard.putData("Auto Mode", AutoModeChooser);
  }
}