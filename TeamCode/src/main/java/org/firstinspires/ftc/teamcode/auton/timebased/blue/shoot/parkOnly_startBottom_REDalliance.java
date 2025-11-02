package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "parkOnly_startBottom_REDalliance", group = "Linear OpMode")
public class parkOnly_startBottom_REDalliance extends AutonMethods {

    @Override
    public void runOpMode() {
        super.runOpMode();
        waitForStart();
        moveForward(1);
        moveLeft(2.5);
    }
}
