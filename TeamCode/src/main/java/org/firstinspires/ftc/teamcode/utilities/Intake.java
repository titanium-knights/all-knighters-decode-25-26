package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//config why not work
@Configurable
public class Intake {

    public static Telemetry telemetry;
    public static double intakePower = 0.9;
    public DcMotor inTake;
    public DcMotor middleTake;


    public Intake(HardwareMap hmap, Telemetry telemetry) {
        this.inTake = hmap.dcMotor.get(CONFIG.INTAKE);
        this.middleTake = hmap.dcMotor.get(CONFIG.MIDDLETAKE);
        this.inTake.setDirection(DcMotor.Direction.FORWARD);
        this.middleTake.setDirection(DcMotor.Direction.REVERSE);
        this.telemetry = telemetry;
    }

    public void intakeRun(){
        inTake.setPower(intakePower);
        middleTake.setPower(intakePower);
        telemetry.addLine(" intake is running");
        telemetry.update();
    }

    public void intakeStop(){
        inTake.setPower(0.0);
        middleTake.setPower(0.0);
        telemetry.addLine(" intake is stopped");
        telemetry.update();
    }


}
