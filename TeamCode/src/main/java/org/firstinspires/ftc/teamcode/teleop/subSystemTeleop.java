package org.firstinspires.ftc.teamcode.teleop;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.utilities.CameraAngle;
import org.firstinspires.ftc.teamcode.utilities.Intake;
import org.firstinspires.ftc.teamcode.utilities.Launch;
import org.firstinspires.ftc.teamcode.utilities.Release;
import org.firstinspires.ftc.teamcode.utilities.SimpleMecanumDrive;
import org.firstinspires.ftc.teamcode.utilities.Sorting;

@TeleOp(name="subSystem Only Teleop")
public class subSystemTeleop {
    //extend opmode??
    Launch launch;
    Release release;
    Intake intake;
    CameraAngle cameraAngle;
    Sorting sorting;
    SimpleMecanumDrive drive;

    ElapsedTime runtime = new ElapsedTime();

    public void init() {
        this.drive = new SimpleMecanumDrive(hardwareMap);
        this.launch = new Launch(hardwareMap, telemetry);
        this.release = new Release(hardwareMap, telemetry);
        this.intake = new Intake(hardwareMap, telemetry);
        this.cameraAngle = new CameraAngle(hardwareMap, telemetry);
        this.sorting = new Sorting(hardwareMap, telemetry);
    }

    public void loop(){

        if (gamepad1.left_trigger) {
            intake.intakeRun();
        } else {
            intake.intakeStop();
        }//add code here to make sure it automaticly sorts the colors after this

        if (gamepad1.right_trigger) {
            launch.launchRun();
        } else {
            launch.launchStop();
        }

        if (gamepad1.right_bumper) {
            release.releaseGreen();
        } else {
            release.releaseNeutral();
        }

        if (gamepad1.left_bumper) {
            release.releasePurple();
        } else {
            release.releaseNeutral();
        }
        // this button will be temporary, instead will be replaced with releasing whatever the order

        if(gamepad1.a && cameraAngle.getPosition()==CameraAngle.cameraAprilTagPos){
            cameraAngle.cameraColor();
        }
        if(gamepad1.a && cameraAngle.getPosition()==CameraAngle.cameraColorPos){
            cameraAngle.cameraAprilTag();
        }


    }

}
