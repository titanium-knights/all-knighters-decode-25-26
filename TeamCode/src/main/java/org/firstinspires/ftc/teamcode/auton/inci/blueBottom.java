package org.firstinspires.ftc.teamcode.auton.inci;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.pedroPathing.Constants;
// import org.firstinspires.ftc.teamcode.utilities.Intake;


@Autonomous(name = "blueBottom")
public class blueBottom extends IncMode {
    private final Pose StartBottom_BLUE = new Pose(65, 0, Math.toRadians(90));
    private final Pose ShootBottom_BLUE = new Pose(65, 100, Math.toRadians(-45));
    private final Pose PositionC_BLUE = new Pose(60, 78, Math.toRadians(180));
    private final Pose groupCPickUp1_BLUE = new Pose(45, 78, Math.toRadians(180));
    private final Pose groupCPickUp2_BLUE = new Pose(35, 78, Math.toRadians(180));
    private final Pose groupCPickUp3_BLUE = new Pose(25, 78, Math.toRadians(180));
    private final Pose PositionB_BLUE = new Pose(96, 54, Math.toRadians(180));
    private final Pose groupBPickUp1_BLUE = new Pose(45, 54, Math.toRadians(180));
    private final Pose groupBPickUp2_BLUE = new Pose(35, 54, Math.toRadians(180));
    private final Pose groupBPickUp3_BLUE = new Pose(25, 54, Math.toRadians(180));
    private final Pose PositionA_BLUE = new Pose(96, 30, Math.toRadians(180));
    private final Pose groupAPickUp1_BLUE = new Pose(45, 30, Math.toRadians(180));
    private final Pose groupAPickUp2_BLUE = new Pose(35, 30, Math.toRadians(180));
    private final Pose groupAPickUp3_BLUE = new Pose(25, 30, Math.toRadians(180));
    private final Pose shootAtBasket_BLUE = ShootBottom_BLUE;
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private PathChain ScoreHOME, ScoreGroupC, ScoreGroupC1, ScoreGroupC2, ScoreGroupC3, ScoreGroupCShoot, ScoreGroupB, ScoreGroupB1,
            ScoreGroupB2, ScoreGroupB3, ScoreGroupBShoot, ScoreGroupA, ScoreGroupA1, ScoreGroupA2, ScoreGroupA3, ScoreGroupAShoot;

    public void buildPaths(){


        ScoreHOME = follower.pathBuilder()
                .addPath(new BezierLine(StartBottom_BLUE, ShootBottom_BLUE))
                .setLinearHeadingInterpolation(StartBottom_BLUE.getHeading(), ShootBottom_BLUE.getHeading())
                .build();

        ScoreGroupC = follower.pathBuilder()
                .addPath(new BezierLine(ShootBottom_BLUE, PositionC_BLUE))
                .setLinearHeadingInterpolation(ShootBottom_BLUE.getHeading(), PositionC_BLUE.getHeading())
                .build();

        ScoreGroupC1 = follower.pathBuilder()
                .addPath(new BezierLine(PositionC_BLUE, groupCPickUp1_BLUE))
                .setLinearHeadingInterpolation(PositionC_BLUE.getHeading(), groupCPickUp1_BLUE.getHeading())
                .build();

        ScoreGroupC2 = follower.pathBuilder()
                .addPath(new BezierLine(groupCPickUp1_BLUE, groupCPickUp2_BLUE))
                .setLinearHeadingInterpolation(groupCPickUp1_BLUE.getHeading(), groupCPickUp2_BLUE.getHeading())
                .build();

        ScoreGroupC3 = follower.pathBuilder()
                .addPath(new BezierLine(groupCPickUp2_BLUE, groupCPickUp3_BLUE))
                .setLinearHeadingInterpolation(groupCPickUp2_BLUE.getHeading(), groupCPickUp3_BLUE.getHeading())
                .build();

        ScoreGroupCShoot = follower.pathBuilder()
                .addPath(new BezierLine(groupCPickUp3_BLUE,shootAtBasket_BLUE))
                .setLinearHeadingInterpolation(groupCPickUp3_BLUE.getHeading(), shootAtBasket_BLUE.getHeading())
                .build();

        ScoreGroupB = follower.pathBuilder()
                .addPath(new BezierLine(shootAtBasket_BLUE, PositionB_BLUE))
                .setLinearHeadingInterpolation(shootAtBasket_BLUE.getHeading(), PositionB_BLUE.getHeading())
                .build();

        ScoreGroupB1 = follower.pathBuilder()
                .addPath(new BezierLine(PositionB_BLUE, groupBPickUp1_BLUE))
                .setLinearHeadingInterpolation(PositionB_BLUE.getHeading(), groupBPickUp1_BLUE.getHeading())
                .build();

        ScoreGroupB2 = follower.pathBuilder()
                .addPath(new BezierLine(groupBPickUp1_BLUE, groupBPickUp2_BLUE))
                .setLinearHeadingInterpolation(groupBPickUp1_BLUE.getHeading(), groupBPickUp2_BLUE.getHeading())
                .build();

        ScoreGroupB3 = follower.pathBuilder()
                .addPath(new BezierLine(groupBPickUp2_BLUE, groupBPickUp3_BLUE))
                .setLinearHeadingInterpolation(groupBPickUp2_BLUE.getHeading(), groupBPickUp3_BLUE.getHeading())
                .build();

        ScoreGroupBShoot = follower.pathBuilder()
                .addPath(new BezierLine(groupBPickUp3_BLUE, shootAtBasket_BLUE))
                .setLinearHeadingInterpolation(groupBPickUp3_BLUE.getHeading(), shootAtBasket_BLUE.getHeading())
                .build();

        ScoreGroupA = follower.pathBuilder()
                .addPath(new BezierLine(shootAtBasket_BLUE, PositionA_BLUE))
                .setLinearHeadingInterpolation(shootAtBasket_BLUE.getHeading(), PositionA_BLUE.getHeading())
                .build();

        ScoreGroupA1 = follower.pathBuilder()
                .addPath(new BezierLine(PositionA_BLUE, groupAPickUp1_BLUE))
                .setLinearHeadingInterpolation(PositionA_BLUE.getHeading(), groupAPickUp1_BLUE.getHeading())
                .build();

        ScoreGroupA2 = follower.pathBuilder()
                .addPath(new BezierLine(groupAPickUp1_BLUE, groupAPickUp2_BLUE))
                .setLinearHeadingInterpolation(groupAPickUp1_BLUE.getHeading(), groupAPickUp2_BLUE.getHeading())
                .build();

        ScoreGroupA3 = follower.pathBuilder()
                .addPath(new BezierLine(groupAPickUp2_BLUE, groupAPickUp3_BLUE))
                .setLinearHeadingInterpolation(groupAPickUp2_BLUE.getHeading(), groupAPickUp3_BLUE.getHeading())
                .build();

        ScoreGroupAShoot = follower.pathBuilder()
                .addPath(new BezierLine(groupAPickUp3_BLUE, shootAtBasket_BLUE))
                .setLinearHeadingInterpolation(groupAPickUp3_BLUE.getHeading(), shootAtBasket_BLUE.getHeading())
                .build();

    }


    private int counter = 0;
    private PathChain currentPath;

    private boolean finishedPath(PathChain path) {
        Pose pose = path.endPose();
        return Math.abs(follower.getPose().getX() - pose.getX()) < 1
                && Math.abs(follower.getPose().getY() - pose.getY()) < 1;
    }

    public void autonomousPathUpdate() {

        if (counter == 0) {
            follower.followPath(ScoreHOME);
            currentPath = ScoreHOME;
            counter = 1;
        } else if (counter == 1 && finishedPath(ScoreHOME)) {
            outtakeStart();
            pathTimer.resetTimer();
            counter = 101;
        } else if (counter == 101 && pathTimer.getElapsedTimeSeconds() > 5) {
            if (pathTimer.getElapsedTimeSeconds() > 10) {
                outtakeStop();
                intakeStop();
                follower.followPath(ScoreGroupC);
                currentPath = ScoreGroupC;
                counter = 2;
            } else if (pathTimer.getElapsedTimeSeconds() > 7.5) {
                intakeStart();
            }
//        } else if (counter == 2 && finishedPath(ScoreGroupC)) {
//            intakeStart();
//            follower.followPath(ScoreGroupC1);
//            currentPath = ScoreGroupC1;
//            counter = 3;
//        } else if (counter == 3 && finishedPath(ScoreGroupC1)) {
//            follower.followPath(ScoreGroupC2);
//            currentPath = ScoreGroupC2;
//            counter = 4;
//        } else if (counter == 4 && finishedPath(ScoreGroupC2)) {
//            follower.followPath(ScoreGroupC3);
//            currentPath = ScoreGroupC3;
//            counter = 5;
//        } else if (counter == 5 && finishedPath(ScoreGroupC3)) {
//            intakeStop();
//            follower.followPath(ScoreGroupCShoot);
//            currentPath = ScoreGroupCShoot;
//            counter = 6;
//        } else if (counter == 6 && finishedPath(ScoreGroupCShoot)) {
//            outtakeStart();
//            outtakeStop();
//            follower.followPath(ScoreGroupB);
//            currentPath = ScoreGroupB;
//            counter = 7;
//        } else if (counter == 7 && finishedPath(ScoreGroupB)) {
//            intakeStart();
//            follower.followPath(ScoreGroupB1);
//            currentPath = ScoreGroupB1;
//            counter = 8;
//        } else if (counter == 8 && finishedPath(ScoreGroupB1)) {
//            follower.followPath(ScoreGroupB2);
//            currentPath = ScoreGroupB2;
//            counter = 9;
//        } else if (counter == 9 && finishedPath(ScoreGroupB2)) {
//            follower.followPath(ScoreGroupB3);
//            currentPath = ScoreGroupB3;
//            counter = 10;
//        } else if (counter == 10 && finishedPath(ScoreGroupB3)) {
//            intakeStop();
//            follower.followPath(ScoreGroupBShoot);
//            currentPath = ScoreGroupBShoot;
//            counter = 11;
//        } else if (counter == 11 && finishedPath(ScoreGroupBShoot)) {
//            outtakeStart();
//            outtakeStop();
//            follower.followPath(ScoreGroupA);
//            currentPath = ScoreGroupA;
//            counter = 12;
//        } else if (counter == 12 && finishedPath(ScoreGroupA)) {
//            intakeStart();
//            follower.followPath(ScoreGroupA1);
//            currentPath = ScoreGroupA1;
//            counter = 13;
//        } else if (counter == 13 && finishedPath(ScoreGroupA1)) {
//            follower.followPath(ScoreGroupA2);
//            currentPath = ScoreGroupA2;
//            counter = 14;
//        } else if (counter == 14 && finishedPath(ScoreGroupA2)) {
//            follower.followPath(ScoreGroupA3);
//            currentPath = ScoreGroupA3;
//            counter = 15;
//        } else if (counter == 15 && finishedPath(ScoreGroupA3)) {
//            intakeStop();
//            follower.followPath(ScoreGroupAShoot);
//            currentPath = ScoreGroupAShoot;
//            counter = 16;
//        } else if (counter == 16 && finishedPath(ScoreGroupAShoot)) {
//            outtakeStart();
//            outtakeStop();
//            counter = 17; // done
        }
    }


    @Override
    public void loop() {
        // These loop the movements of the robot
        follower.update();
        autonomousPathUpdate();

        // Feedback to Driver Hub
        telemetry.addData("path state", counter);
        telemetry.addLine(String.format("x: %.2f -> %.2f", follower.getPose().getX(), currentPath.endPose().getX()));
        telemetry.addLine(String.format("y: %.2f -> %.2f", follower.getPose().getY(), currentPath.endPose().getY()));
        telemetry.addLine(String.format("h: %.2f -> %.2f", follower.getPose().getHeading(), currentPath.endPose().getHeading()));
        telemetry.update();
    }

    @Override
    public void init() {
        super.init();
        pathTimer = new Timer();
        //        Constants.setConstants(FConstants.class, LConstants.class);
        opmodeTimer = new Timer();

        opmodeTimer.resetTimer();

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(StartBottom_BLUE);

        buildPaths();
    }

    @Override
    public void init_loop() {}

    @Override
    public void start() {
        opmodeTimer.resetTimer();
    }

    @Override
    public void stop() {}
    // jajajaja
}
