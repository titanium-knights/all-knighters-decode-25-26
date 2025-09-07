package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//config why not work
@Configurable
public class Intake {

    public DcMotor intakeMotor;
    public static Telemetry telemetry;
    public static double intakePower = 0.9;

    // TODO: VALUES RANDOM + CONFIG BROKE !!

    public Intake(HardwareMap hmap, Telemetry telemetry) {
        this.intakeMotor = hmap.dcMotor.get(CONFIG.intakeMotor);
        this.intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        this.telemetry = telemetry;
    }

    public void intakeRun(){
        intakeMotor.setPower(intakePower);
        telemetry.addLine(" intake running");
        telemetry.update();
    }

    public void intakeStop(){
        intakeMotor.setPower(0.0);
        telemetry.addLine(" intake stoped");
        telemetry.update();
    }

    public double getPower() {
        return (intakeMotor.getPower());
    }


}
