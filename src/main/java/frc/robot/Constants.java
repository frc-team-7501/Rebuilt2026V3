// Copyright (c) 2021-2026 Littleton Robotics
// http://github.com/Mechanical-Advantage
//
// Use of this source code is governed by a BSD
// license that can be found in the LICENSE file
// at the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * This class defines the runtime mode used by AdvantageKit. The mode is always
 * "real" when running
 * on a roboRIO. Change the value of "simMode" to switch between "sim" (physics
 * sim) and "replay"
 * (log replay from a file).
 */
public final class Constants {
  public static final Mode simMode = Mode.SIM;
  public static final Mode currentMode = RobotBase.isReal() ? Mode.REAL : simMode;

  public static final class CANMapping {
    public static final int INTAKE_DRIVE = 25;
    public static final int SPINDEXER_DRIVE = 15;
    public static final int HANDOFF_DRIVE = 16;
    public static final int LAUNCHER_DRIVE_L = 18;
    public static final int LAUNCHER_DRIVE_R = 17;
 
  }

  public static final class ControllerMapping {
    public static final int XBOX = 0;
    public static final int BBOARD = 1;
  }

  public static final class ButtonBoardMapping {
    // Button board is labeled -1 from these values, 0=1, 1=2, etc.
    public static final int PLACEHOLDERWPI0 = 0;
    public static final int INTAKESTOP = 1;
    public static final int INTAKERUN = 2;
    public static final int SPINDEXERSTOP = 3;
    public static final int SPINDEXERRUN = 4;  
    public static final int HANDOFFSTOP = 5;
    public static final int HANDOFFRUN = 6;
    public static final int LAUNCHERSTOP = 9;
    public static final int LAUNCHERRUN = 10;
    
  }

  public static enum Mode {
    /** Running on a real robot. */
    REAL,

    /** Running a physics simulator. */
    SIM,

    /** Replaying from a log file. */
    REPLAY
  }
}
