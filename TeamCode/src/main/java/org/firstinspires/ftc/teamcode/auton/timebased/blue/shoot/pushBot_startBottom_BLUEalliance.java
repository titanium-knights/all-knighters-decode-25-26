package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "pushBot_startBottom_BLUEalliance", group = "Linear OpMode")
public class pushBot_startBottom_BLUEalliance extends AutonMethods {

    @Override
    public void runOpMode() {
        moveLeft(1);
        moveForward(4);
        rotateCcw(45);
        moveForward(1);
        moveBackward(1);
        rotateCw(45);
        moveBackward(3);
        moveLeft(1);
        //park
    }
}

