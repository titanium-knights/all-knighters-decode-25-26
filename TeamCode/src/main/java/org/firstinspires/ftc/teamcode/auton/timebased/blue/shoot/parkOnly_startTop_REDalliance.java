package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "parkOnly_startTop_REDalliance", group = "Linear OpMode")
public class parkOnly_startTop_REDalliance extends AutonMethods {

    @Override
    public void runOpMode() {
        moveForward(2);
        rotateCcw(45);
        moveForward(3);
    }
}
