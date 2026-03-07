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
                    .lateralZeroPowerAcceleration(
                            (-76.7222356679041 - 85.99500753658874 - 107.29585165635946) / 3)
                    .forwardZeroPowerAcceleration(
                            (-56.16911319356693 - 55.67726496461103 - 44.81693132852102) / 3)
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
                    .xVelocity((75.27824375857799 + 73.00715602474443 + 73.31933500010989) / 3)
                    .yVelocity((42.36875602081255 + 41.14756847098387 + 40.924077508898066) / 3);

    public static ThreeWheelConstants localizerConstants =
            new ThreeWheelConstants()
                    .forwardTicksToInches(
                            (0.001987052088226984 + 0.001989133492595857 + 0.001984533693417579)
                                    / 3)
                    .strafeTicksToInches(
                            (-0.001995202497433042 - 0.001987463633665086 - 0.0020004462865510614)
                                    / 3)
                    .turnTicksToInches(
                            (0.0019551097481992053 + 0.001956078995241521 + 0.0019529899884137625)
                                    / 3)
                    .leftPodY((16.0 / 2) - 1.4375)
                    .rightPodY(-1 * ((16.0 / 2) - 1.375))
                    .strafePodX(-1 * ((17.0 / 2.0) - 2.875))
                    .leftEncoder_HardwareMapName(CONFIG.LEFT_ODO)
                    .rightEncoder_HardwareMapName(CONFIG.RIGHT_ODO)
                    .strafeEncoder_HardwareMapName(CONFIG.BACK_ODO)
                    .leftEncoderDirection(CONFIG.LEFT_ODO_DIRECTION)
                    .rightEncoderDirection(CONFIG.RIGHT_ODO_DIRECTION)
                    .strafeEncoderDirection(CONFIG.BACK_ODO_DIRECTION);

    public static PathConstraints pathConstraints = new PathConstraints(0.995, 500, 1, 1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                //                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .threeWheelLocalizer(localizerConstants)
                .build();
    }
}
