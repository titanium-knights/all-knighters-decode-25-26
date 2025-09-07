package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//config why not work
@Configurable
public class CameraAngle {

    Servo cameraServo;

    // TODO: VALUES RANDOM + CONFIG BROKE !!

    public CameraAngle(HardwareMap hmap, Telemetry telemetry) {
        this.cameraServo = hmap.servo.get(CONFIG.cameraServo);
        this.cameraServo.setDirection(Servo.Direction.FORWARD);
        this.telemetry = telemetry;
    }

    public static Telemetry telemetry;
    public static final double cameraAprilTagPos = 1.0;
    public static final double cameraColorPos = 0.0;


    public void cameraAprilTag(){
        cameraServo.setPosition(cameraAprilTagPos);
        telemetry.addLine(" camera facing April Tag");
        telemetry.update();
    }

    public void cameraColor(){
        cameraServo.setPosition(cameraColorPos);
        telemetry.addLine(" camera facing balls (detecting color");
        telemetry.update();
    }



    public double getPosition() {
        return (cameraServo.getPosition());
    }


}

