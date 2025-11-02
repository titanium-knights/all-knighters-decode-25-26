package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "parkOnly_startTop_BLUEalliance", group = "Linear OpMode")
public class parkOnly_startTop_BLUEalliance extends AutonMethods {

    @Override
    public void runOpMode() {
        super.runOpMode();
        waitForStart();
        moveForward(2);
        rotateCw(45);
        moveForward(3);
    }
}
