package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//config why not work
@Configurable
public class Middletake {

    public static Telemetry telemetry;
    public static double middletakePower = 0.5;
    public DcMotor middleTake;


    public Middletake(HardwareMap hmap, Telemetry telemetry) {
        this.middleTake = hmap.dcMotor.get(CONFIG.MIDDLETAKE);
        this.middleTake.setDirection(DcMotor.Direction.FORWARD);
        this.telemetry = telemetry;
    }

    public void middletakeRun(){
        middleTake.setPower(middletakePower);
        telemetry.addLine(" middletake is running");
    }

    public void middletakeStop(){
        middleTake.setPower(0.0);
        telemetry.addLine(" middletake is stopped");
    }


}
