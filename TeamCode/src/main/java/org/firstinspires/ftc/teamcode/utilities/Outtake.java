package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//config why not work
@Deprecated
@Configurable
public class Outtake {

    public static Telemetry telemetry;
    public static double outtakePower = 0.7;
    public DcMotor outTakeL;
    public DcMotor outTakeR;


    public Outtake(HardwareMap hmap, Telemetry telemetry) {
        this.outTakeL = hmap.dcMotor.get(CONFIG.OUTTAKE_L);
        this.outTakeR = hmap.dcMotor.get(CONFIG.OUTTAKE_R);
        this.outTakeL.setDirection(DcMotor.Direction.FORWARD);
        this.outTakeR.setDirection(DcMotor.Direction.REVERSE);
        this.telemetry = telemetry;
    }

    public void outtakeRun(){
        outTakeL.setPower(outtakePower);
        outTakeR.setPower(outtakePower);
        telemetry.addLine(" outtake is running");
        telemetry.update();
    }

    public void outtakeStop(){
        outTakeL.setPower(0.0);
        outTakeR.setPower(0.0);
        telemetry.addLine(" outtake is stopped");
        telemetry.update();
    }


}
