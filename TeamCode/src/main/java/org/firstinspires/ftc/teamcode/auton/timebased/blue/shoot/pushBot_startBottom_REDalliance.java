package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "pushBot_startBottom_REDalliance", group = "Linear OpMode")
public class pushBot_startBottom_REDalliance extends AutonMethods {

    @Override
    public void runOpMode() {
        moveRight(1);
        moveForward(4);
        rotateCw(45);
        moveForward(1);
        moveBackward(1);
        rotateCcw(45);
        moveBackward(3);
        moveRight(1);
        //park
    }
}

