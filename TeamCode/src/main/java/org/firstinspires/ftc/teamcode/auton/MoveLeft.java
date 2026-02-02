package org.firstinspires.ftc.teamcode.auton;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;




@Autonomous(name = "MoveLeft", group = "Linear OpMode")
public class MoveLeft extends AutonMethods {


    @Override
    public void runOpMode() {
        super.runOpMode();
        waitForStart();

        move(-0.3, 0,0);
        sleep(1000);
        stopDrive();
    }
}