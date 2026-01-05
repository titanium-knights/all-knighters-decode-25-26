package org.firstinspires.ftc.teamcode.teleop;

public class Calculator {

    // TODO: tune
    // TODO: tune
    // TODO: tune

    public static final double ballMass = 1; //filler
    public static final double acceleration = 1; //filler
    public static final double force = acceleration*ballMass;
    public static final double distance = 1; //filler
    public static final double velocity = Math.sqrt((2*force*distance)/ballMass);
    public static final double height = 1.23; //meters

    public static double toLaunchAngle(double gravity) {

        double inside = (2 * gravity * height) / Math.pow(velocity, 2);
        inside = Math.min(1.0, Math.max(0.0, inside));
        double angleRadians = Math.asin(Math.sqrt(inside));
        return Math.toDegrees(angleRadians);

    }


    public static double toFacingAngle(double X, double Y) {

        double angleRadians = Math.atan2(Y, X);
        return Math.toDegrees(angleRadians);

    }

    public static double getVelocity() {

        return velocity;

    }

    public static double toOuttakePower() {
        double velocity = getVelocity();

        // TODO: tune
        double maxVelocity = 10.0;
        double maxPower = 1.0;

        double power = (velocity / maxVelocity) * maxPower;
        return Math.min(1.0, Math.max(0.0, power));
    }

}