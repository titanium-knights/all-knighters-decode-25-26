package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.robotcore.external.Telemetry;

//config why not work
@Configurable
public class Outake {

    public DcMotor outakeMotor;
    public DcMotor outakeMotor2;
    public static Telemetry telemetry;
    public static double outakePower = 0.9;

    // TODO: VALUES RANDOM + CONFIG BROKE !!

    public Outake(HardwareMap hmap, Telemetry telemetry) {
        this.outakeMotor = hmap.dcMotor.get(CONFIG.outakeMotor);
        this.outakeMotor.setDirection(DcMotor.Direction.FORWARD);
        this.telemetry = telemetry;
    }

//    public Outake(HardwareMap hmap, Telemetry telemetry) {
//        this.outakeMotor = hmap.dcMotor.get(CONFIG.intakeMotor2);
//        this.outakeMotor.setDirection(DcMotor.Direction.FORWARD);
//        this.telemetry = telemetry;
//    }
//


    public void outakeRun(){
        outakeMotor.setPower(outakePower);
//        outakeMotor.setPower(intakePower2);
        telemetry.addLine(" outake running");
        telemetry.update();
    }

    public void outakeStop(){
        outakeMotor.setPower(0.0);
//        outakeMotor2.setPower(0.0);
        telemetry.addLine(" outake stoped");
        telemetry.update();
    }

    public double getPower() {
        return (outakeMotor.getPower());
    }


}
