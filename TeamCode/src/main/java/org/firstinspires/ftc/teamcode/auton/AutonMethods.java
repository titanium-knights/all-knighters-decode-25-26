package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.utilities.SubsystemManager;

public abstract class AutonMethods extends LinearOpMode {
    public SubsystemManager subsystemManager;

    @Override
    public void runOpMode() {
        subsystemManager = new SubsystemManager(hardwareMap, telemetry);
    }

    public final double POWER = 1;

    // DRIVING TINGS
    public void stopDrive() {
        subsystemManager.drive.move(0, 0, 0);
    }

    public void move(double x, double y, double turn) {
        subsystemManager.drive.move(x, y, turn);
    }
}