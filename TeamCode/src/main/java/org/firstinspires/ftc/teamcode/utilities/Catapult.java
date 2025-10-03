package org.firstinspires.ftc.teamcode.utilities;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Catapult {
    public DcMotor catapultMotor;
    public static Telemetry telemetry;
    public static double catapultLaunchPower = 0.9;
    public static double catapultNotLaunchPower = 0.0;


    public Catapult(HardwareMap hmap, Telemetry telemetry) {
        this.catapultMotor = hmap.dcMotor.get(CONFIG.catapultMotor);
        this.catapultMotor.setDirection(DcMotor.Direction.FORWARD);
        this.telemetry = telemetry;
    }

    public void catapultLaunch() {
        catapultMotor.setPower(catapultLaunchPower);
        telemetry.addLine(" catapult launched");
        telemetry.update();

    }

    public void catacapultLaunch() {
        catapultMotor.setPower(catapultLaunchPower);
        telemetry.addLine(" catapult launched");
        telemetry.update();

    }

}
