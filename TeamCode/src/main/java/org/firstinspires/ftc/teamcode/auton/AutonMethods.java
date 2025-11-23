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
        sleep(100);
    }
    public void moveForward(double x) {
        double duration = 1080 * x;
        subsystemManager.drive.move(0, -POWER, 0);
        sleep((int) duration);
        stopDrive();
    }
    public void moveBackward(double x) {
        double duration = 1080 * x;
        subsystemManager.drive.move(0, POWER, 0);
        sleep((int) duration);
        stopDrive();
    }
    public void moveRight(double x) {
        double duration = 1500 * x;
        subsystemManager.drive.move(POWER, 0, 0);
        sleep((int) duration);
        stopDrive();
    }
    public void moveLeft(double x) {
        double duration = 1500 * x;
        subsystemManager.drive.move(-POWER, 0, 0);
        sleep((int) duration);
        stopDrive();
    }
    public void rotateCw(double x) {
        double duration = 8000 * x;
        subsystemManager.drive.move(0, 0, -POWER);
        sleep((int) duration);
        stopDrive();
    }
    public void rotateCcw(double x) {
        double duration = 8000 * x;
        subsystemManager.drive.move(0, 0, POWER);
        sleep((int) duration);
        stopDrive();
    }


    // INTAKE TINGS
//    public void intakeRun() {
//        subsystemManager.intake.intakeRun();
//    }
//    public void intakeStop() {
//        subsystemManager.intake.intakeStop();
//    }


    // OUTTAKE TINGS
    public void outtakeRun() {
        subsystemManager.outtake.outtakeRun();
    }
    public void outtakeStop() {
        subsystemManager.outtake.outtakeRun();
    }


    // Shoot
    public void someSortOfShootFunction() {
//        subsystemManager.middletake.middletakeRun();
//        sleep(500);
//        subsystemManager.middletake.middletakeStop();
//        sleep(250);
//        subsystemManager.middletake.middletakeRun();
//        sleep(250);
//        subsystemManager.middletake.middletakeStop();
//        sleep(750);
        subsystemManager.outtake.outtakeRun();
        sleep(3000);
        subsystemManager.middletake.middletakeRun();
        sleep(750);
        subsystemManager.middletake.middletakeStop();
        subsystemManager.outtake.outtakeKYS();
        sleep(250);
        subsystemManager.outtake.outtakeStop();
    }
}