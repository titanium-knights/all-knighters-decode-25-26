package org.firstinspires.ftc.teamcode.utilities;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Configurable
public class Agitator {
    private final CRServo agitator;
    private static Telemetry telemetry;

    public Agitator(HardwareMap hmap, Telemetry telemetry) {
        this.agitator = hmap.crservo.get(CONFIG.AGITATOR);
        this.agitator.setDirection(CRServo.Direction.REVERSE);
        Agitator.telemetry = telemetry;
    }

    public void agitate() {
        agitator.setPower(0.9);
    }

    public void unAgitate() {
        agitator.setPower(-0.9);
    }

    public void stopAgitatingMyBallsItsReallyAnnoying() {
        agitator.setPower(0.0);
    }

}
