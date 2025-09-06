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
    public static double cameraServoPower = 0.9;

    public void releaseRun(){
        cameraServo.setPosition(cameraServoPower);
        telemetry.addLine(" camera running");
        telemetry.update();
    }

    public double getPosition() {
        return (cameraServo.getPosition());
    }


}

