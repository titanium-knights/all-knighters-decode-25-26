package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "pushBot_startTop_REDalliance", group = "Linear OpMode")
public class pushBot_startTop_REDalliance extends AutonMethods {

    @Override
    public void runOpMode() {
        moveForward(2);
        rotateCw(45);
        moveLeft(1.07);
        moveBackward(1.25);
        moveRight(0.9);
        rotateCw(45);
        moveRight(0.25);
        //end of first pick up and drop, we are at basket

        moveLeft(2.38);
        rotateCcw(45);
        moveLeft(2.4);
        moveBackward(1.25);
        moveRight(4);
        rotateCw(45);
        moveRight(0.25);
        //end of second pick up and drop, we are at basket


        moveLeft(2.38);
        rotateCcw(45);
        moveLeft(3.8);
        moveBackward(1.25);
        moveRight(5.3);
        rotateCw(45);
        moveRight(0.25);
        //end of third pick up and drop, we are at basket


        moveLeft(2.38);
        rotateCcw(45);
        //park
        moveLeft(4);
        moveForward(3.35);
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

