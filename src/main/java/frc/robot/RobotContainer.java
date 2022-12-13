// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.simulation.XboxControllerSim;
import frc.robot.commands.ExtendUntilLimitSwitch;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Pneumatics pneumaElish = new Pneumatics();
  private final ExtendUntilLimitSwitch limitSwitchCommand = new ExtendUntilLimitSwitch(pneumaElish);

  private final XboxController xbox = new XboxController(2);
  private final JoystickButton y = new JoystickButton(xbox, 4);
  private final JoystickButton b = new JoystickButton(xbox, 2);
  private final JoystickButton a = new JoystickButton(xbox, 1);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    y.whileHeld(new StartEndCommand(
        () -> {
          pneumaElish.in();
        },
        () -> {
          pneumaElish.off();
        }));
    b.whileHeld(new StartEndCommand(
        () -> {
          pneumaElish.out();
        },
        () -> {
          pneumaElish.off();
        }));
    a.whileHeld(limitSwitchCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
