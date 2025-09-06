package org.firstinspires.ftc.teamcode.utilities;

import static java.lang.Math.min;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Sorting {

    Servo sortingServo;
    public Sorting(HardwareMap hmap) {
        this.sortingServo = hmap.servo.get(CONFIG.sortingServo);
    }

    public void toPurple() {

    }

    public void toGreen() {

    }

}
