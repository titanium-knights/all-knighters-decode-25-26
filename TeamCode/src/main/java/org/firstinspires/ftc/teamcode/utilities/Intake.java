package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//config why not work
@Configurable
public class Intake {

    Servo intakeServo;

    // TODO: VALUES RANDOM + CONFIG BROKE !!

    public Intake(HardwareMap hmap, Telemetry telemetry) {
        this.intakeServo = hmap.servo.get(CONFIG.intakeServo);
        this.intakeServo.setDirection(Servo.Direction.FORWARD);
        this.telemetry = telemetry;
    }

    public static Telemetry telemetry;
    public static double intakePower = 0.9;

    public void intakeRun(){
        intakeServo.setPosition(intakePower);
        telemetry.addLine(" intake running");
        telemetry.update();
    }

    public void intakeStop(){
        intakeServo.setPosition(0.0);
        telemetry.addLine(" intake stoped");
        telemetry.update();
    }

    public double getPosition() {
        return (intakeServo.getPosition());
    }


}
