package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.utilities.OuttakeKT;
import org.firstinspires.ftc.teamcode.utilities.SubsystemManager;

@TeleOp(name = "Out")
public class Out extends OpMode {
    private OuttakeKT outtake;

    @Override
    public void init() {
        outtake = new OuttakeKT(hardwareMap, telemetry);
    }

    @Override
    public void loop() {

        if (gamepad1.right_trigger > 0.5) {
            outtake.outtakeRun();
        } else {
            if (gamepad1.right_bumper) {
                outtake.outtakeKYS();
            } else {
                outtake.outtakeStop();
            }
        }
    }
}
