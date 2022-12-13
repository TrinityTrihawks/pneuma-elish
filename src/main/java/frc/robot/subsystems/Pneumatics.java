// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalGlitchFilter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  /** Creates a new Pneumatics. */
  private final DoubleSolenoid bumpStop = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
  private final DigitalInput limitSwitch = new DigitalInput(0);

  public Pneumatics() {
  }

  public void in() {
    bumpStop.set(Value.kReverse);
  }

  public void out() {
    bumpStop.set(Value.kForward);
  }

  public void off() {
    bumpStop.set(Value.kOff);
  }

  public boolean getLimitSwitchValue() {
    return limitSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
