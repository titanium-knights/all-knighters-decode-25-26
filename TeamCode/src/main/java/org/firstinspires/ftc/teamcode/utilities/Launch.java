package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//config why not work
@Configurable
public class Launch {

    public DcMotor launchMotor;
    public static Telemetry telemetry;
    public static double launchPower = 0.9;

    // TODO: VALUES RANDOM + CONFIG BROKE !!

    public Launch(HardwareMap hmap, Telemetry telemetry) {
        this.launchMotor = hmap.dcMotor.get(CONFIG.launchMotor);
        this.launchMotor.setDirection(DcMotor.Direction.FORWARD);
        this.telemetry = telemetry;
    }



    public void launchRun(){
        launchMotor.setPower(launchPower);
        telemetry.addLine(" launch running");
        telemetry.update();
    }

    public void launchStop(){
        launchMotor.setPower(0.0);
        telemetry.addLine(" launch stoped");
        telemetry.update();
    }

    public double getPower() {
        return (launchMotor.getPower());
    }


}
