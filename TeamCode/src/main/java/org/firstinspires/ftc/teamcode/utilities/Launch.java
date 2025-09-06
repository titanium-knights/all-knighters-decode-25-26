package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//config why not work
@Configurable
public class Launch {

    Servo launchServo;

    // TODO: VALUES RANDOM + CONFIG BROKE !!

    public Launch(HardwareMap hmap, Telemetry telemetry) {
        this.launchServo = hmap.servo.get(CONFIG.launchServo);
        this.launchServo.setDirection(Servo.Direction.FORWARD);
        this.telemetry = telemetry;
    }

    public static Telemetry telemetry;
    public static double launchPower = 0.9;

    public void launchRun(){
        launchServo.setPosition(launchPower);
        telemetry.addLine(" launch running");
        telemetry.update();
    }

    public double getPosition() {
        return (launchServo.getPosition());
    }


}
