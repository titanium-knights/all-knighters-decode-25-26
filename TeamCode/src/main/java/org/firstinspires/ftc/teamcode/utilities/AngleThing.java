package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//ts is theoretical
public class AngleThing {
    public static Telemetry telemetry;
    Servo angleThingServo;

    public static final double closeRange = 0.0;
    public static final double farRange = 1.0;
    public static final double midRange = 0.5;

    public AngleThing(HardwareMap hmap, Telemetry telemetry) {
        this.angleThingServo = hmap.servo.get(CONFIG.angleThingServo);
        this.angleThingServo.setDirection(Servo.Direction.FORWARD);
        AngleThing.telemetry = telemetry;
    }

    public void toCloseRange() {
        angleThingServo.setPosition(closeRange);
        telemetry.addLine(Double.toString(angleThingServo.getPosition()));
        telemetry.addLine("close range");
    }

    public void toFarRange() {
        angleThingServo.setPosition(farRange);
        telemetry.addLine(Double.toString(angleThingServo.getPosition()));
        telemetry.addLine("far range");

    }

    public void toMidRange() {
        angleThingServo.setPosition(midRange);
        telemetry.addLine(Double.toString(angleThingServo.getPosition()));
        telemetry.addLine("mid range");
    }

    public double getPosition() {
        return (angleThingServo.getPosition());
    }

}
