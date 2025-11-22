package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;
@Autonomous(name = "PreLoad_Bottom_Test", group = "Linear OpMode")
public class PreLoad_Bottom_Test extends AutonMethods {
    @Override
    public void runOpMode() {
        super.runOpMode();
        waitForStart();
        someSortOfShootFunction();
    }
}
