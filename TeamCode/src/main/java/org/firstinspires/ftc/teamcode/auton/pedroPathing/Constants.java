package org.firstinspires.ftc.teamcode.auton.pedroPathing;

import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.ThreeWheelConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.utilities.CONFIG;

public class Constants {

    public static FollowerConstants followerConstants =
            new FollowerConstants()
                    .translationalPIDFCoefficients(new PIDFCoefficients(0.1, 0.0004, 0.01, 0))
                    .headingPIDFCoefficients(new PIDFCoefficients(1.5, 0.1, 0, 0.01))
                    .drivePIDFCoefficients(
                            new FilteredPIDFCoefficients(0.001, 0.001, 0.00002, 0.6, 0.067));

    public static MecanumConstants driveConstants =
            new MecanumConstants()
                    .leftFrontMotorName(CONFIG.FRONT_LEFT)
                    .leftRearMotorName(CONFIG.BACK_LEFT)
                    .rightFrontMotorName(CONFIG.FRONT_RIGHT)
                    .rightRearMotorName(CONFIG.BACK_RIGHT)
                    .leftFrontMotorDirection(CONFIG.FL_DIRECTION)
                    .rightFrontMotorDirection(CONFIG.FR_DIRECTION)
                    .leftRearMotorDirection(CONFIG.BL_DIRECTION)
                    .rightRearMotorDirection(CONFIG.BR_DIRECTION)
                    .xVelocity((71.73591741450626 + 72.86681658956445 + 71.261306270706) / 3)
                    .yVelocity((52.945704383231075 + 53.004110379356305 + 52.36135792874717) / 3);

    public static ThreeWheelConstants localizerConstants =
            new ThreeWheelConstants()
                    .forwardTicksToInches(
                            (0.001997477706295442 + 0.002001019562158589 + 0.001997147738848221)
                                    / 3)
                    .strafeTicksToInches(
                            (0.002003851615776408 + 0.002118880363535722 + 0.002012519127441897)
                                    / 3)
                    .turnTicksToInches(
                            // (0.0020590062456552244 + 0.004117539736164494 + 0.004129549753816808)
                            // (0.004132563213329115 + 0.004134151011851167 + 0.004135263196981174)
                            (0.004117539736164494 + 0.004129549753816808) / 2)
                    .leftPodY((17.0 / 2) - 4.375)
                    .rightPodY(-1 * (17.0 / 2) - 4.5)
                    .strafePodX((17.0 / 2.0) - 8)
                    .leftEncoder_HardwareMapName(CONFIG.LEFT_ODO)
                    .rightEncoder_HardwareMapName(CONFIG.RIGHT_ODO)
                    .strafeEncoder_HardwareMapName(CONFIG.BACK_ODO)
                    .leftEncoderDirection(CONFIG.LEFT_ODO_DIRECTION)
                    .rightEncoderDirection(CONFIG.RIGHT_ODO_DIRECTION)
                    .strafeEncoderDirection(CONFIG.BACK_ODO_DIRECTION);

    public static PathConstraints pathConstraints = new PathConstraints(0.995, 500, 1, 1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .threeWheelLocalizer(localizerConstants)
                .build();
    }
}
