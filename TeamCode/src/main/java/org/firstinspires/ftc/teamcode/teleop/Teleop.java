package org.firstinspires.ftc.teamcode.teleop;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static java.lang.Math.abs;
import com.qualcomm.robotcore.util.ElapsedTime;


import android.widget.Button;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.teamcode.utilities.CameraAngle;
import org.firstinspires.ftc.teamcode.utilities.SubsystemManager;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name="Teleop")
public class Teleop extends OpMode {
    private SubsystemManager subsystemManager;
    public static String color = "p";

    //time stuff
    private final ElapsedTime sortingTimer = new ElapsedTime();
    private final ElapsedTime holesTimer = new ElapsedTime();

    public boolean holesActive = false;
    public boolean sortingActive = false;

    double[] stepTimes = {2.0, 3.5, 5.0};

    public int holeInt = 0;


    @Override
    public void init() {
        subsystemManager = new SubsystemManager(hardwareMap, telemetry);
        subsystemManager.sorting.toNeutral();
    }

    @Override
    public void loop() {

        if (gamepad1.left_trigger > 0.5) {
            subsystemManager.intake.intakeRun();
            //susbsystemManager.intake2.intakeRun();

            if (!sortingActive) {  // only reset when starting
                sortingTimer.reset();
                sortingActive = true;
            }


//            if(gamepad1.right_trigger > 0.5){
//                susbsystemManager.outake.outakeRun();
//                //subsystemManager.outake2.outakeRun();
//
//                if (!sortingActive){
//                    sortingTimer.reset();
//                    sortingActive = true;
//                }
//            }
            if (color.equals("green") && sortingTimer.seconds() < 4.5) {
                subsystemManager.sorting.toGreen();
            } else if (color.equals("purple") && sortingTimer.seconds() < 4.5) {
                subsystemManager.sorting.toPurple();
            } else {
                subsystemManager.sorting.toNeutral();
            }

        } else {
            subsystemManager.intake.intakeStop();
            sortingActive = false;
        }

        if (gamepad1.dpad_left) {
            if (!holesActive) {
                holesTimer.reset();
                holesActive = true;
                holeInt = 0;
            }

            for (int i = holeInt; i < stepTimes.length; i++) {
                if (holesTimer.seconds() < stepTimes[i]) {
                    if (i == 0) {
                        subsystemManager.holeOne.toOpenPos("hole one");
                    } else if (i == 1) {
                        subsystemManager.holeOne.toClosePos("hole one");
                        subsystemManager.holeTwo.toOpenPos("hole two");
                    } else if (i == 2) {
                        subsystemManager.holeTwo.toClosePos("hole two");
                    }
                    holeInt = i + 1;
                    break;
                }
            }

        }

    }
}

