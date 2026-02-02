package org.firstinspires.ftc.teamcode.auton;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;




@Autonomous(name = "MoveRight", group = "Linear OpMode")
public class MoveRight extends AutonMethods {


    @Override
    public void runOpMode() {
        super.runOpMode();
        waitForStart();

        move(0.3, 0,0);
        sleep(1000);
        stopDrive();
    }
}