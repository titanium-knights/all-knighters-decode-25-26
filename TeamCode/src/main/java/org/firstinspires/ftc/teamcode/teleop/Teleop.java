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
    private final ElapsedTime sortingTimer = new ElapsedTime(); //this may or may not work
    public boolean sortingActive = false;


    @Override
    public void init() {
        subsystemManager = new SubsystemManager(hardwareMap, telemetry);
        subsystemManager.sorting.toNeutral();
    }

    @Override
    public void loop() {

        if (gamepad1.left_trigger > 0.5) {
            subsystemManager.intake.intakeRun();

            if(!sortingActive){  // only reset when starting
                sortingTimer.reset();
                sortingActive = true;
            }

            if(color.equals("green") && sortingTimer.seconds() < 4.5){
                subsystemManager.sorting.toGreen();
            }
            else if(color.equals("purple") && sortingTimer.seconds() < 4.5){
                subsystemManager.sorting.toPurple();
            }
            else {
                subsystemManager.sorting.toNeutral();
            }

        } else {
            subsystemManager.intake.intakeStop();
            sortingActive = false;
        }

        if(gamepad1.dpad_left) {
            subsystemManager.angleThing.toCloseRange();
        } else if(gamepad1.dpad_up) {
            subsystemManager.angleThing.toMidRange();
        } else if(gamepad1.dpad_right) {
            subsystemManager.angleThing.toFarRange();
        }


        if (gamepad1.right_trigger > 0.5) {
            subsystemManager.launch.launchRun();
        } else {
            subsystemManager.launch.launchStop();
        }

        if (gamepad1.right_bumper) {
            subsystemManager.release.releaseGreen();
        } else {
            subsystemManager.release.releaseNeutral();
        }

        if (gamepad1.left_bumper) {
            subsystemManager.release.releasePurple();
        } else {
            subsystemManager.release.releaseNeutral();
        }
        // this button will be temporary, instead will be replaced with releasing whatever the order

        if(gamepad1.a && subsystemManager.cameraAngle.getPosition()== CameraAngle.cameraAprilTagPos){
            subsystemManager.cameraAngle.cameraColor();
        }
        if(gamepad1.a && subsystemManager.cameraAngle.getPosition()==CameraAngle.cameraColorPos){
            subsystemManager.cameraAngle.cameraAprilTag();
        }
    }
}
