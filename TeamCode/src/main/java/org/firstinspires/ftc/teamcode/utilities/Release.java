package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//config why not work
@Configurable
public class Release {

    Servo releaseServo;

    // TODO: VALUES RANDOM + CONFIG BROKE !!

    public Release(HardwareMap hmap, Telemetry telemetry) {
        this.releaseServo = hmap.servo.get(CONFIG.releaseServo);
        this.releaseServo.setDirection(Servo.Direction.FORWARD);
        this.telemetry = telemetry;
    }

    public static Telemetry telemetry;
    public static double releaseNeutralPos = 0.5;
    public static double releaseGreenPos = 1.0;
    public static double releasePurplePos = 0.0;

    public void releaseNeutral(){
        releaseServo.setPosition(releaseNeutralPos);
        telemetry.addLine(" release at Neutral Position");
        telemetry.update();
    }

    public void releaseGreen(){
        releaseServo.setPosition(releaseGreenPos);
        telemetry.addLine(" release at Green Position");
        telemetry.update();
    }

    public void releasePurple(){
        releaseServo.setPosition(releasePurplePos);
        telemetry.addLine(" release at Purple Position");
        telemetry.update();
    }


    public double getPosition() {
        return (releaseServo.getPosition());
    }


}
