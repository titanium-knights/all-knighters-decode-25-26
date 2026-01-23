package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.utilities.SubsystemManager;

@TeleOp(name = "Teleop")
public class Teleop extends OpMode {
    private SubsystemManager subsystemManager;
    private Double modifier;

    @Override
    public void init() {
        subsystemManager = new SubsystemManager(hardwareMap, telemetry);
        modifier = 1.0;
        //        subsystemManager.sorting.toNeutral();
    }

    @Override
    public void loop() {
        modifier = (gamepad1.b) ? -0.8 : 1.0;

        subsystemManager.drive.move(
                gamepad1.left_stick_x * modifier,
                -gamepad1.left_stick_y * modifier, // negated bc y value is opposite on the stick
                gamepad1.right_stick_x);
        if (gamepad1.right_trigger > 0.5) {
            subsystemManager.outtake.outtakeRun();
        } else {
            if (gamepad1.right_bumper) {
                subsystemManager.outtake.outtakeKYS();
            } else {
                subsystemManager.outtake.outtakeStop();
            }
        }

        if (gamepad1.left_trigger > 0.5) {
            subsystemManager.intake.intakeRun();
        } else {
            subsystemManager.intake.intakeStop();
        }
        if (gamepad1.right_bumper) {
            subsystemManager.agitator.agitate();
        } else {
            subsystemManager.agitator.stopAgitatingMyBallsItsReallyAnnoying();
        }
    }
}
