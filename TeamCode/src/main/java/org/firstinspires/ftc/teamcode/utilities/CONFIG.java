package org.firstinspires.ftc.teamcode.utilities;

import com.pedropathing.ftc.localization.Encoder;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class CONFIG {
    //TODO: label all strings with associated ports and types.
    // ex: ch motor 3 (control hub > motor > port 3)

    // drivetrain wheels
    public static final String FRONT_LEFT = "fl";
    public static final DcMotorSimple.Direction FL_DIRECTION = DcMotorSimple.Direction.FORWARD;

    public static final String FRONT_RIGHT = "fr";
    public static final DcMotorSimple.Direction FR_DIRECTION = DcMotorSimple.Direction.FORWARD;

    public static final String BACK_LEFT = "bl";
    public static final DcMotorSimple.Direction BL_DIRECTION = DcMotorSimple.Direction.REVERSE;

    public static final String BACK_RIGHT = "br";
    public static final DcMotorSimple.Direction BR_DIRECTION = DcMotorSimple.Direction.FORWARD;

    public static final String OUTTAKE = "outtake";

    public static final String INTAKE = "intake";

    public static final String AGITATOR = "agitator";

    public static final String HOOD = "hood";
    public static final String THE_NOTHING_BURGER = "theNothingBurger";

    public static final String LEFT_ODO = INTAKE;
    public  static  final double LEFT_ODO_DIRECTION = Encoder.REVERSE;
    public static final String RIGHT_ODO = BACK_LEFT;
    public static final double RIGHT_ODO_DIRECTION = Encoder.REVERSE;
    public static final String BACK_ODO = AGITATOR;
    public static final double BACK_ODO_DIRECTION = Encoder.REVERSE;
}