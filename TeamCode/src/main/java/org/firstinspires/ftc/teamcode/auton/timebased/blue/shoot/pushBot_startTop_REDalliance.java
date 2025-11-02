package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "pushBot_startTop_REDalliance", group = "Linear OpMode")
public class pushBot_startTop_REDalliance extends AutonMethods {

    @Override
    public void runOpMode() {
        super.runOpMode();
        waitForStart();
        moveForward(2);
        rotateCw(45);
        moveLeft(1);
        moveBackward(1);
        moveRight(1);
        rotateCw(45);
        //end of first pick up and drop, we are at basket

        moveLeft(2);
        rotateCcw(45);
        moveLeft(2);
        moveBackward(1);
        moveRight(2);
        rotateCw(45);
        //end of second pick up and drop, we are at basket


        moveLeft(2);
        rotateCcw(45);
        moveLeft(3);
        moveBackward(1);
        moveRight(3);
        rotateCw(45);
        //end of third pick up and drop, we are at basket


        moveLeft(2);
        rotateCcw(45);
        //park
        moveLeft(3);
    }

//Start
    //Move 2 square to the right (don't go forward yet, still in triangle) (in parallel with squares)
    //Turn to face the rows (45 degrees) - because we start at an angle (face towards blue triangle)
    //Move right (1 square)
    //Move backward to align with the first ball (be in parallel)
    //Move left (2 squares) (push the ball back to the triangle)
    //Turn 90 degrees to push the balls into the wall
    //Move left (should be pushed fully now)
    // Move forward 2 squares
    // Move right (2 squares)
    // Move backward towards the balls again and align the robot
    // Move left( all the way to the red triangle)
    // Turn 90 degrees
    // Move left (should be pushed fully now)

}

