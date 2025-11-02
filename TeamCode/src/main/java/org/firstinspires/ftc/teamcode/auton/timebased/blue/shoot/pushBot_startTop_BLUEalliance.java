package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "pushBot_startTop_BLUEalliance", group = "Linear OpMode")
public class pushBot_startTop_BLUEalliance extends AutonMethods {

    @Override
    public void runOpMode() {
        moveForward(2);
        rotateCcw(45);
        moveRight(1);
        moveBackward(1);
        moveLeft(1);
        rotateCcw(45);
        //end of first pick up and drop, we are at basket

        moveRight(2);
        rotateCw(45);
        moveRight(2);
        moveBackward(1);
        moveLeft(2);
        rotateCcw(45);
        //end of second pick up and drop, we are at basket


        moveRight(2);
        rotateCw(45);
        moveRight(3);
        moveBackward(1);
        moveLeft(3);
        rotateCcw(45);
        //end of third pick up and drop, we are at basket


        moveRight(2);
        rotateCw(45);
        //park
        moveRight(3);
    }
}

