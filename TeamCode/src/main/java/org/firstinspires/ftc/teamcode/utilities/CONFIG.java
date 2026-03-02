package org.firstinspires.ftc.teamcode.utilities;

import com.pedropathing.ftc.localization.Encoder;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class CONFIG {
    //TODO: label all strings with associated ports and types.
    // ex: ch motor 3 (control hub > motor > port 3)

    // drivetrain wheels

    /*
    fr ex0 dc
    br ex1 dc
    fl ex2 dc
    bl ex3 dc
    o c0 dc
    i c3 dc

    backOdo c0 dcx
    leftOdo c3 dcx
    rightOdo ex3 dcx
     */
    public static final String FRONT_LEFT = "fl"; // c1
    public static final DcMotorSimple.Direction FL_DIRECTION = DcMotorSimple.Direction.FORWARD;

    public static final String FRONT_RIGHT = "fr"; // c2
    public static final DcMotorSimple.Direction FR_DIRECTION = DcMotorSimple.Direction.FORWARD;

    public static final String BACK_LEFT = "bl"; // c0
    public static final DcMotorSimple.Direction BL_DIRECTION = DcMotorSimple.Direction.REVERSE;

    public static final String BACK_RIGHT = "br"; // c3
    public static final DcMotorSimple.Direction BR_DIRECTION = DcMotorSimple.Direction.FORWARD;

    public static final String OUTTAKE_LEFT = "out_l"; // e3
    public static final DcMotorSimple.Direction OUT_L_DIRECTION = DcMotorSimple.Direction.FORWARD;

    public static final String OUTTAKE_RIGHT = "out_r"; // e1
    public static final DcMotorSimple.Direction OUT_R_DIRECTION = DcMotorSimple.Direction.REVERSE;

    public static final String INTAKE = "in"; // e0
    public static final DcMotorSimple.Direction IN_DIRECTION = DcMotorSimple.Direction.FORWARD;



    public static final String LEFT_ODO = BACK_LEFT; // c0
    public  static  final double LEFT_ODO_DIRECTION = Encoder.REVERSE;

    public static final String RIGHT_ODO = OUTTAKE_LEFT; //e3
    public static final double RIGHT_ODO_DIRECTION = Encoder.REVERSE;

    public static final String BACK_ODO = BACK_RIGHT; // c3
    public static final double BACK_ODO_DIRECTION = Encoder.REVERSE;
}