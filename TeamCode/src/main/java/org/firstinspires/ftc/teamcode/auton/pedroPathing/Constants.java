//package org.firstinspires.ftc.teamcode.auton.pedroPathing;
//
//import com.pedropathing.follower.Follower;
//import com.pedropathing.follower.FollowerConstants;
//import com.pedropathing.ftc.FollowerBuilder;
//import com.pedropathing.ftc.drivetrains.MecanumConstants;
//import com.pedropathing.ftc.localization.constants.ThreeWheelConstants;
//import com.pedropathing.paths.PathConstraints;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import org.firstinspires.ftc.teamcode.utilities.CONFIG;
//
//public class Constants {
//
//    public static FollowerConstants followerConstants =
//            new FollowerConstants()
//                    .forwardZeroPowerAcceleration(
//                            (-43.155248974904445 - 45.111116151247764 - 44.29439674084163) / 3)
//                    .lateralZeroPowerAcceleration(
//                            (-82.72257592122241 - 104.18909423999247 - 93.93106660634109) / 3);
//    public static MecanumConstants driveConstants =
//            new MecanumConstants()
//                    .leftFrontMotorName(CONFIG.FRONT_LEFT)
//                    .leftRearMotorName(CONFIG.BACK_LEFT)
//                    .rightFrontMotorName(CONFIG.FRONT_RIGHT)
//                    .rightRearMotorName(CONFIG.BACK_RIGHT)
//                    .leftFrontMotorDirection(CONFIG.FL_DIRECTION)
//                    .rightFrontMotorDirection(CONFIG.FR_DIRECTION)
//                    .leftRearMotorDirection(CONFIG.BL_DIRECTION)
//                    .rightRearMotorDirection(CONFIG.BR_DIRECTION)
//                    .xVelocity((68.8215587608126 + 68.89238162899416 + 67.85768289959903) / 3)
//                    .yVelocity((50.837193746718384 + 50.69623846628053 + 47.298194914019305) / 3);
//
//    public static ThreeWheelConstants localizerConstants =
//            new ThreeWheelConstants()
//                    .leftPodY(-1 * ((17.0 / 2.0) - 3.75))
//                    .rightPodY((17.0 / 2.0) - 4.25)
//                    .strafePodX(-1 * ((17.0 / 2.0) - 5.5))
//                    .leftEncoder_HardwareMapName(CONFIG.LEFT_ODO)
//                    .rightEncoder_HardwareMapName(CONFIG.RIGHT_ODO)
//                    .strafeEncoder_HardwareMapName(CONFIG.BACK_ODO)
//                    .leftEncoderDirection(CONFIG.LEFT_ODO_DIRECTION)
//                    .rightEncoderDirection(CONFIG.RIGHT_ODO_DIRECTION)
//                    .strafeEncoderDirection(CONFIG.BACK_ODO_DIRECTION)
//                    .forwardTicksToInches(
//                            (0.00196607212991782 + 0.0019881096060913117 + 0.0019880031977263964)
//                                    / 3)
//                    .strafeTicksToInches(
//                            (0.002009976001604704 + 0.002041508937831714 + 0.002012647092666368)
//                                    / 3)
//                    .turnTicksToInches(
//                            (0.001884453071334851 + 0.0018875352236261628 + 0.0018905010619355532)
//                                    / 3);
//    public static PathConstraints pathConstraints = new PathConstraints(0.995, 500, 1, 1);
//
//    public static Follower createFollower(HardwareMap hardwareMap) {
//        return new FollowerBuilder(followerConstants, hardwareMap)
//                .threeWheelLocalizer(localizerConstants)
//                .pathConstraints(pathConstraints)
//                .mecanumDrivetrain(driveConstants)
//                .build();
//    }
//}
