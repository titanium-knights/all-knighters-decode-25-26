package org.firstinspires.ftc.teamcode.auton.timebased.blue.shoot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;

@Autonomous(name = "parkOnly_startBottom_BLUEalliance", group = "Linear OpMode")
public class parkOnly_startBottom_BLUEalliance extends AutonMethods {

    @Override
    public void runOpMode() {
       moveForward(1);
       moveRight(2.5);
    }
}
