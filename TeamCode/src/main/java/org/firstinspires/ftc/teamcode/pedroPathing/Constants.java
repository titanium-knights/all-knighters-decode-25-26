package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.utilities.CONFIG;

public class Constants {

    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(11.42)
            .forwardZeroPowerAcceleration(-55.8487)
            .lateralZeroPowerAcceleration(-72.1592)
            .useSecondaryTranslationalPIDF(true)
            .useSecondaryHeadingPIDF(true)
            .useSecondaryDrivePIDF(true)
            .centripetalScaling(0.0002)
            .translationalPIDFCoefficients(new PIDFCoefficients(0.1, 0, 0.01, 0))
            .headingPIDFCoefficients(new PIDFCoefficients(2, 0, 0.1, 0))
            .drivePIDFCoefficients(
                    new FilteredPIDFCoefficients(0.008, 0, 0.000005, 0.6, 0)
            )
            .secondaryTranslationalPIDFCoefficients(
                    new PIDFCoefficients(0.1, 0, 0.01, 0)
            )
            .secondaryHeadingPIDFCoefficients(new PIDFCoefficients(2, 0, 0.1, 0))
            .secondaryDrivePIDFCoefficients(
                    new FilteredPIDFCoefficients(0.1, 0, 0, 0.6, 0)
            );

    public static MecanumConstants driveConstants = new MecanumConstants()
            .leftFrontMotorName(CONFIG.FRONT_LEFT)
            .leftRearMotorName(CONFIG.BACK_LEFT)
            .rightFrontMotorName(CONFIG.FRONT_RIGHT)
            .rightRearMotorName(CONFIG.BACK_RIGHT)
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .xVelocity(53.5)
            .yVelocity(40.7168);

    public static PinpointConstants localizerConstants = new PinpointConstants()
            .forwardPodY(-2.1875)
            .strafePodX(-2.0625)
            .distanceUnit(DistanceUnit.INCH)
            .hardwareMapName("pinpoint")
            .yawScalar(1.0)
            .encoderResolution(
                    GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD
            )
            .customEncoderResolution(13.26291192)
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED);

    public static PathConstraints pathConstraints = new PathConstraints(
            0.995,
            500,
            1,
            1
    );

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .mecanumDrivetrain(driveConstants)
                .pinpointLocalizer(localizerConstants)
                .pathConstraints(pathConstraints)
                .build();
    }
}