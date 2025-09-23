package org.firstinspires.ftc.teamcode.utilities;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Holes {
    public static Telemetry telemetry;
    Servo holeOneServo;
    Servo holeTwoServo;

    public static final double open = 1.0;
    public static final double close = 0.0;

    public Holes(HardwareMap hmap, Telemetry telemetry) {
        this.holeTwoServo = hmap.servo.get(CONFIG.holeTwoServo);
        this.holeTwoServo.setDirection(Servo.Direction.FORWARD);
        this.holeOneServo = hmap.servo.get(CONFIG.holeOneServo);
        this.holeOneServo.setDirection(Servo.Direction.FORWARD);
        Holes.telemetry = telemetry;
    }

    public void toOpenPos(String holeNumber) {
        if(holeNumber.equals("hole one")) {
            holeOneServo.setPosition(open);
            telemetry.addLine(Double.toString(holeOneServo.getPosition()));
            telemetry.addLine("hole one open");
        }

        if(holeNumber.equals("hole two")) {
            holeTwoServo.setPosition(open);
            telemetry.addLine(Double.toString(holeTwoServo.getPosition()));
            telemetry.addLine("hole two open");
        }

    }

    public void toClosePos(String holeNumber) {
        if(holeNumber.equals("hole one")) {
            holeOneServo.setPosition(close);
            telemetry.addLine(Double.toString(holeOneServo.getPosition()));
            telemetry.addLine("hole one closed");
        }

        if(holeNumber.equals("hole two")) {
            holeTwoServo.setPosition(close);
            telemetry.addLine(Double.toString(holeTwoServo.getPosition()));
            telemetry.addLine("hole two closed");
        }

    }

    public double getPositionHoleTwo() {
        return (holeTwoServo.getPosition());
    }
    public double getPositionHoleOne() {
        return (holeOneServo.getPosition());
    }

}
