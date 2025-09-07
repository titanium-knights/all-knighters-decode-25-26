package org.firstinspires.ftc.teamcode.teleop;

import static java.lang.Math.abs;

import android.widget.Button;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.teamcode.utilities.SubsystemManager;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import org.firstinspires.ftc.teamcode.utilities.Intake;
import org.firstinspires.ftc.teamcode.utilities.Launch;
import org.firstinspires.ftc.teamcode.utilities.Release;
import org.firstinspires.ftc.teamcode.utilities.SimpleMecanumDrive;
import org.firstinspires.ftc.teamcode.utilities.Sorting;

@TeleOp(name="Teleop")
public class Teleop extends OpMode {
    private SubsystemManager subsystemManager;

    @Override
    public void init() {
        subsystemManager = new SubsystemManager(hardwareMap, telemetry);
        subsystemManager.sorting.toNeutral();
    }

    @Override
    public void loop() {
        //sorting is manual for now
        if (gamepad1.dpad_left) {
            subsystemManager.sorting.toGreen();
        } else {
            subsystemManager.sorting.toNeutral();
        }

        if (gamepad1.dpad_right) {
            subsystemManager.sorting.toPurple();
        } else {
            subsystemManager.sorting.toNeutral();
        }
    }
}
