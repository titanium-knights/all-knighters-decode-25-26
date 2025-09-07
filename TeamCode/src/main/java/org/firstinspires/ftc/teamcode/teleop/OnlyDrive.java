package org.firstinspires.ftc.teamcode.teleop;

import static java.lang.Math.abs;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.utilities.SubsystemManager;

public class OnlyDrive extends OpMode {
    private SubsystemManager subsystemManager;

    public void init() {
        // Now hardwareMap is valid because we're extending OpMode
        subsystemManager = new SubsystemManager(hardwareMap, telemetry);
    }

    public void loop() {
        if (abs(gamepad1.left_stick_x) > 0.1f ||
                abs(gamepad1.left_stick_y) > 0.1f ||
                abs(gamepad1.right_stick_x) > 0.1f) {

            subsystemManager.drive.move(
                    gamepad1.left_stick_x,
                    gamepad1.left_stick_y,
                    gamepad1.right_stick_x
            );
        } else {
            if (gamepad1.left_stick_x > 0.3) {
                telemetry.addData("gamepad: ", gamepad1.left_stick_x);
            }
            subsystemManager.drive.move(
                    gamepad1.left_stick_x,
                    gamepad1.left_stick_y,
                    gamepad1.right_stick_x
            );
        }

        telemetry.update();
        telemetry.addData("left stick x: ", gamepad2.left_stick_x);
        telemetry.addData("left stick y: ", gamepad2.left_stick_y);
        telemetry.addData("right stick x: ", gamepad2.right_stick_x);
    }
}
