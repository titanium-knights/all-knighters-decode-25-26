package org.firstinspires.ftc.teamcode.teleop;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.utilities.SubsystemManager;

@TeleOp(name = "Teleop")
public class Teleop extends OpMode {
    public static String color = "p";
    // time stuff
    private final ElapsedTime sortingTimer = new ElapsedTime();
    private final ElapsedTime holesTimer = new ElapsedTime();
    public boolean holesActive = false;
    public boolean sortingActive = false;
    public int holeInt = 0;
    double[] stepTimes = {2.0, 3.5, 5.0};
    private SubsystemManager subsystemManager;

    @Override
    public void init() {
        subsystemManager = new SubsystemManager(hardwareMap, telemetry);
        //        subsystemManager.sorting.toNeutral();
    }

    @Override
    public void loop() {

        subsystemManager.drive.move(
                gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);

        if (gamepad1.right_trigger > 0.5) {
            subsystemManager.outtake.outtakeRun();
        } else {
            subsystemManager.outtake.outtakeStop();
        }

        if (gamepad1.left_trigger > 0.5) {
            subsystemManager.intake.intakeRun();
        } else {
            subsystemManager.intake.intakeStop();
        }
        if (gamepad1.left_bumper) {
            subsystemManager.middletake.middletakeRun();
        } else {
            subsystemManager.middletake.middletakeStop();
        }
    }
}
