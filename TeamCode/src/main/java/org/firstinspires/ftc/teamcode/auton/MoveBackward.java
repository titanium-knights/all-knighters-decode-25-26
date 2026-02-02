package org.firstinspires.ftc.teamcode.auton;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;




@Autonomous(name = "MoveBackward", group = "Linear OpMode")
public class MoveBackward extends AutonMethods {


    @Override
    public void runOpMode() {
        super.runOpMode();
        waitForStart();

        move(0, -0.3,0);
        sleep(1000);
        stopDrive();
    }
}