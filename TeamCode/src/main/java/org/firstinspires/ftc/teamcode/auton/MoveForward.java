package org.firstinspires.ftc.teamcode.auton;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;




@Autonomous(name = "MoveForward", group = "Linear OpMode")
public class MoveForward extends AutonMethods {


    @Override
    public void runOpMode() {
        super.runOpMode();
        waitForStart();

        move(0, 0.3,0);
        sleep(1000);
        stopDrive();
    }
}