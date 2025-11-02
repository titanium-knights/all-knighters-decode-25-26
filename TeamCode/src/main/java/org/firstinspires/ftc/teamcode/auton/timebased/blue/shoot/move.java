package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


import org.firstinspires.ftc.teamcode.auton.AutonMethods;


@Autonomous(name = "move", group = "Linear OpMode")
public class move extends AutonMethods {


    @Override
    public void runOpMode() {
        super.runOpMode();
        waitForStart();

        moveRight(0.2);
    }
}

