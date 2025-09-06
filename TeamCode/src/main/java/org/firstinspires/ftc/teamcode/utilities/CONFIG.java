package org.firstinspires.ftc.teamcode.utilities;

public class CONFIG {
    //TODO: label all strings with associated ports and types.
    // ex: ch motor 3 (control hub > motor > port 3)

    // drivetrain wheels
    public static String FRONT_LEFT = "fl";  // ch motor 0
    public static String BACK_RIGHT = "br";  // ch motor 3
    public static String FRONT_RIGHT = "fr"; // ch motor 2
    public static String BACK_LEFT = "bl";   // ch motor 1

    // horizontal slides
    public static String horizontalSlidesMotor = "horizontalSlidesMotor"; // tape: "scissorsMotor", eh motor 0

    // misc
    public static String webcam = "Webcam 1";

    // swiper
    public static String swiperServo = "swiperServo"; // tape: nothing yet, ch servo 1

    // intake
    public static String clawServoBottom = "clawB";      // tape: “bottomclaw”, eh servo 1
    public static String clawRotator = "clawR";          // tape: “clawrotator”, ch servo 5
    public static String rightWristServo = "rightWrist"; // tape: “R Wrist”,  eh servo 3

    // outtake:
    public static String slidesMotor = "slidesMotor";   // tape: “SlidesMotor”, eh motor 3
    public static String armServo = "armServo";         // tape: “R Bucket”,    ch servo 3
    public static String topClawServo = "claw";         // tape: "Claw",        ch servo 2

    //NOTE: ch servo 4 is bad, do not use it until further investigation
}