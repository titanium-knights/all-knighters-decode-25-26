package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "pushBot_startTop_BLUEalliance", group = "Linear OpMode")
public class pushBot_startTop_BLUEalliance extends AutonMethods {

    @Override
    public void runOpMode() {
        moveForward(2);
        rotateCcw(45);
        moveRight(1.07);
        moveBackward(1.25);
        moveLeft(0.9);
        rotateCcw(45);
        moveLeft(0.25);
        //end of first pick up and drop, we are at basket

        moveRight(2.38);
        rotateCw(45);
        moveRight(2.4); //0.4 gap or something
        moveBackward(1.25);
        moveLeft(4);
        rotateCcw(45);
        moveLeft(0.25);
        //end of second pick up and drop, we are at basket


        moveRight(2.38);
        rotateCw(45);
        moveRight(3.8);
        moveBackward(1.25);
        moveLeft(5.3);
        rotateCcw(45);
        moveLeft(0.25);
        //end of third pick up and drop, we are at basket

        moveRight(2.38);
        rotateCw(45);
        //park
        moveRight(4);
        moveForward(3.35);
    }
}

