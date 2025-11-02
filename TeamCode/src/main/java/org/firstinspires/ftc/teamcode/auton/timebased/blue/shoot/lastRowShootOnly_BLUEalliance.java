package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "lastRowShootOnly_BLUEalliance", group = "Linear OpMode")
public class lastRowShootOnly_BLUEalliance extends AutonMethods {

    @Override
    public void runOpMode() {
        // TODO - This is shooting two balls
        // stopDrive(), moveBackward(), moveRight(), moveLeft(), rotateCw(), rotateCcw()

        // We start on the blue side of small triangle - across from shoot
        moveForward(3);
        rotateCw(90);
        moveForward(1);
        intakeRun();
        intakeStop();
        moveBackward(1);
        rotateCw(135);
        // shoots from the back
        outtakeRun();
        sleep(1000);
        outtakeStop();
        rotateCcw(135);
        // picking up 1 at a time so it picks up 3 times
        moveForward(1);
        intakeRun();
        sleep(1000);
        intakeStop();
        moveBackward(1);
        rotateCw(135);
        outtakeRun();
        sleep(1000);

        outtakeStop();
        rotateCcw(135);
        moveForward(1);
        intakeRun();
        intakeStop();
        moveBackward(1);
        rotateCw(135);
        outtakeRun();
        sleep(1000);

        outtakeStop();
        // after 3rd, just park?
        rotateCw(45);
        moveBackward(3);
        moveLeft(3);

        // go backward
        // turn forward
        // go forward and enter the triangle
        // turn at angle to shoot
        // shoot
        // turn back
        // move back to the last row
        // turn towards the row
        // intake another ball
        // move backward
        // turn forward
        // move forward and enter triangle
        // turn at an angle to shoot
        // shoot
        // turn back
        // move backwards
        // turn
        // intake the ball
        // go back
        // turn forwards
        // go forward and enter triangle
        // turn at an angle to shoot
        // shoot
        // turn back
        // move backwards and park
        // park
    }
}
