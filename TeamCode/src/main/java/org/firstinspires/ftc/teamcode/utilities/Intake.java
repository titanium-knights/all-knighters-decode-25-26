package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//config why not work
@Configurable
public class Intake {

    public static Telemetry telemetry;
    public static final double intakePower = 0.9;
    public final DcMotor inTake;

    public Intake(HardwareMap hmap, Telemetry telemetry) {
        this.inTake = hmap.dcMotor.get(CONFIG.INTAKE);
        this.inTake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.inTake.setDirection(CONFIG.IN_DIRECTION);
        Intake.telemetry = telemetry;
    }

    public void intakeRun(){
        inTake.setPower(intakePower);
        telemetry.addLine(" intake is running");
    }

    public void intakeStop(){
        inTake.setPower(0.0);
        telemetry.addLine(" intake is stopped");
    }

    public void intakeReversed() {
        inTake.setPower(-0.7);
        telemetry.addLine(" intake is reversing");
    }


}
