package org.firstinspires.ftc.teamcode.utilities;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.HashMap;
import java.util.Objects;

public class SimpleMecanumDrive {

    public static final HashMap<DcMotor, double[]> directions = new HashMap<>();
    public static DcMotor fl, fr, bl, br;

    public SimpleMecanumDrive(HardwareMap hmap) {
        fl = hmap.get(DcMotor.class, CONFIG.FRONT_LEFT);
        fr = hmap.get(DcMotor.class, CONFIG.FRONT_RIGHT);
        bl = hmap.get(DcMotor.class, CONFIG.BACK_LEFT);
        br = hmap.get(DcMotor.class, CONFIG.BACK_RIGHT);

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        fl.setDirection(CONFIG.FL_DIRECTION);
        fr.setDirection(CONFIG.FR_DIRECTION);
        bl.setDirection(CONFIG.BL_DIRECTION);
        br.setDirection(CONFIG.BR_DIRECTION);

        directions.put(fl, new double[]{1, 1});
        directions.put(fr, new double[]{-1, 1});
        directions.put(bl, new double[]{-1, 1});
        directions.put(br, new double[]{1, 1});
    }

    public void move(double x, double y, double turn) {
        // dot of fl and br

        // explanation of dots so you don't go through hell trying to understand it, perchance
        // turn is positive when left stick is right, so to turn left, you want to put a negative offset for the left wheels and a positive offset for the right one.
        //     ^          ^
        // |---| -> left, |---| -> right
        // v                  v
        // these are just offset from the already calculated rotation speed derived from the x and y components of the direction you want to go for each individual wheel.
        // if you want to strafe left, x will be -1, y will be 0. -1 * 1 + 0 * 1 => -1, so the wheel has to go backwards for fl
        // if you want to strafe left while going forward, x will be -1, y will be 1. -1 * 1 + 1 * 1 => 0, so the wheel doesn't move

        double dot_fl = dot(Objects.requireNonNull(directions.get(fl)), new double[]{x, y}) + turn;
        double dot_fr = dot(Objects.requireNonNull(directions.get(fr)), new double[]{x, y}) - turn;
        double dot_bl = dot(Objects.requireNonNull(directions.get(bl)), new double[]{x, y}) + turn;
        double dot_br = dot(Objects.requireNonNull(directions.get(br)), new double[]{x, y}) - turn;

        double max = Math.max(1, Math.max(Math.max(Math.abs(dot_fl), Math.abs(dot_fr)), Math.max(Math.abs(dot_bl), Math.abs(dot_br))));
        fl.setPower(dot_fl / max);
        br.setPower(dot_br / max);
        fr.setPower(dot_fr / max);
        bl.setPower(dot_bl / max);
    }

    // Each double[] will be a direction vector of length two
    public double dot(double[] a, double[] b) {
        return a[0] * b[0] + a[1] * b[1];
    }

    public void moveFL(double power) {
        fl.setPower(power);
    }

    public void stopFL() {
        fl.setPower(0);
    }

    public void moveFR(double power) {
        fr.setPower(power);
    }

    public void stopFR() {
        fr.setPower(0);
    }

    public void moveBL(double power) {
        bl.setPower(power);
    }

    public void stopBL() {
        bl.setPower(0);
    }

    public void moveBR(double power) {
        br.setPower(power);
    }

    public void stopBR() {
        br.setPower(0);
    }
}