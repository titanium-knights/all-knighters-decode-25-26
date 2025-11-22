package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "PreLoad_BLUE_Bottom", group = "Linear OpMode")
public class PreLoad_BLUE_Bottom extends AutonMethods {
    @Override
    public void runOpMode() {
        super.runOpMode();
        waitForStart();
        //some sort of shoot function
        moveForward(5); //to parking



    }
}
