package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Configurable

public class Sorting {
    public static Telemetry telemetry;
    public static final double toPurplePos = 0.5;
    public static final double toGreenPos = 1.0;
    public static final double toNeutralPos = 0.0;

    static Servo sortingServo;
    public Sorting(HardwareMap hmap, Telemetry telemetry) {
        sortingServo = hmap.servo.get(CONFIG.sortingServo);
    }

    public void toPurple() {
        sortingServo.setPosition(toPurplePos);
        telemetry.addLine(Double.toString(sortingServo.getPosition()));
    }

    public void toGreen() {
        sortingServo.setPosition(toGreenPos);
        telemetry.addLine(Double.toString(sortingServo.getPosition()));
    }

    public void toNeutral() {
        sortingServo.setPosition(toNeutralPos);
        telemetry.addLine(Double.toString(sortingServo.getPosition()));
    }

    public double getPosition() {
        return (sortingServo.getPosition());
    }

}
