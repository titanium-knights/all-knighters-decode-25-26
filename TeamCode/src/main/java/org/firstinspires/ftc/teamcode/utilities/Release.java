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
    public static double releasePower = 0.9;

    public void releaseRun(){
        releaseServo.setPosition(releasePower);
        telemetry.addLine(" release running");
        telemetry.update();
    }

    public double getPosition() {
        return (releaseServo.getPosition());
    }


}
