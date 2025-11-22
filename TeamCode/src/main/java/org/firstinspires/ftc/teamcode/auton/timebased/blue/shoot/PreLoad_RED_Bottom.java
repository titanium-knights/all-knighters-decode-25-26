package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "PreLoad_RED_Bottom", group = "Linear OpMode")
public class PreLoad_RED_Bottom extends AutonMethods {
    @Override
    public void runOpMode() {
        super.runOpMode();
        waitForStart();
        someSortOfShootFunction();
        moveForward(5); //to parking spot



    }
}