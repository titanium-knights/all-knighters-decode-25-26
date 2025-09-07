package org.firstinspires.ftc.teamcode.teleop;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.utilities.CameraAngle;
import org.firstinspires.ftc.teamcode.utilities.Intake;
import org.firstinspires.ftc.teamcode.utilities.Launch;
import org.firstinspires.ftc.teamcode.utilities.Release;
import org.firstinspires.ftc.teamcode.utilities.SimpleMecanumDrive;
import org.firstinspires.ftc.teamcode.utilities.Sorting;
import org.firstinspires.ftc.teamcode.utilities.SubsystemManager;

@TeleOp(name="subSystem Only Teleop")
public class SubSystemTeleop {
    //extend opmode??
    Launch launch;
    Release release;
    Intake intake;
    CameraAngle cameraAngle;
    Sorting sorting;
    SimpleMecanumDrive drive;

    ElapsedTime runtime = new ElapsedTime();
    public SubsystemManager subsystemManager;

    public void init() {

    }

    public void loop(){

        if (gamepad1.left_trigger > 0.5) {
            intake.intakeRun();
            //add code here to make sure it automaticly sorts the colors after this
            if(color="green"){//this part is with the camera
                sorting.toGreen();
            }
            if(color="purple"){
                sorting.toPurple();
            }
            else(color="neutral"){
                sorting.toNeutral();
            }
        } else {
            intake.intakeStop();
        }


        if (gamepad1.right_trigger > 0.5) {
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
