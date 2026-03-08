package org.firstinspires.ftc.teamcode.auton.inci;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.pedroPathing.Constants;
// import org.firstinspires.ftc.teamcode.utilities.Intake;


@Autonomous(name = "redBottom")
public class redBottom extends IncMode {
    private final Pose StartBottom_RED = new Pose(100, 0,Math.toRadians(90));
    private final Pose ShootBottom_RED = new Pose(100, 100,Math.toRadians(117.64));
    private final Pose PositionC_RED = new Pose(96, 42,Math.toRadians(180));
    private final Pose groupCPickUp1_RED = new Pose(125, 42,Math.toRadians(180));
    private final Pose groupCPickUp2_RED = new Pose(130,42 ,Math.toRadians(180));
    private final Pose groupCPickUp3_RED = new Pose(135,42 ,Math.toRadians(180));
    private final Pose PositionB_RED = new Pose(100, 66,Math.toRadians(180));
    private final Pose groupBPickUp1_RED = new Pose(125,66,Math.toRadians(180));
    private final Pose groupBPickUp2_RED = new Pose(130,66,Math.toRadians(180));
    private final Pose groupBPickUp3_RED = new Pose(135,66,Math.toRadians(180));
    private final Pose PositionA_RED = new Pose(100, 90,Math.toRadians(180));
    private final Pose groupAPickUp1_RED = new Pose(125,90,Math.toRadians(180));
    private final Pose groupAPickUp2_RED = new Pose(130,90,Math.toRadians(180));
    private final Pose groupAPickUp3_RED = new Pose(135,90,Math.toRadians(180));
    private final Pose shootAtBasket_RED = new Pose(100,74,Math.toRadians(135));
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private PathChain ScoreHOME, ScoreGroupC, ScoreGroupC1, ScoreGroupC2, ScoreGroupC3, ScoreGroupCShoot, ScoreGroupB, ScoreGroupB1,
            ScoreGroupB2, ScoreGroupB3, ScoreGroupBShoot, ScoreGroupA, ScoreGroupA1, ScoreGroupA2, ScoreGroupA3, ScoreGroupAShoot;

    public void buildPaths(){

        ScoreHOME = follower.pathBuilder()
                .addPath(new BezierLine(StartBottom_RED, ShootBottom_RED))
                .setLinearHeadingInterpolation(StartBottom_RED.getHeading(), ShootBottom_RED.getHeading())
                .build();

        ScoreGroupC = follower.pathBuilder()
                .addPath(new BezierLine(ShootBottom_RED, PositionC_RED))
                .setLinearHeadingInterpolation(ShootBottom_RED.getHeading(), PositionC_RED.getHeading())
                .build();

        ScoreGroupC1 = follower.pathBuilder()
                .addPath(new BezierLine(PositionC_RED, groupCPickUp1_RED))
                .setLinearHeadingInterpolation(PositionC_RED.getHeading(), groupCPickUp1_RED.getHeading())
                .build();

        ScoreGroupC2 = follower.pathBuilder()
                .addPath(new BezierLine(groupCPickUp1_RED, groupCPickUp2_RED))
                .setLinearHeadingInterpolation(groupCPickUp1_RED.getHeading(), groupCPickUp2_RED.getHeading())
                .build();

        ScoreGroupC3 = follower.pathBuilder()
                .addPath(new BezierLine(groupCPickUp2_RED, groupCPickUp3_RED))
                .setLinearHeadingInterpolation(groupCPickUp2_RED.getHeading(), groupCPickUp3_RED.getHeading())
                .build();

        ScoreGroupCShoot = follower.pathBuilder()
                .addPath(new BezierLine(groupCPickUp3_RED,shootAtBasket_RED))
                .setLinearHeadingInterpolation(groupCPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
                .build();

        ScoreGroupB = follower.pathBuilder()
                .addPath(new BezierLine(shootAtBasket_RED, PositionB_RED))
                .setLinearHeadingInterpolation(shootAtBasket_RED.getHeading(), PositionB_RED.getHeading())
                .build();

        ScoreGroupB1 = follower.pathBuilder()
                .addPath(new BezierLine(PositionB_RED, groupBPickUp1_RED))
                .setLinearHeadingInterpolation(PositionB_RED.getHeading(), groupBPickUp1_RED.getHeading())
                .build();

        ScoreGroupB2 = follower.pathBuilder()
                .addPath(new BezierLine(groupBPickUp1_RED, groupBPickUp2_RED))
                .setLinearHeadingInterpolation(groupBPickUp1_RED.getHeading(), groupBPickUp2_RED.getHeading())
                .build();

        ScoreGroupB3 = follower.pathBuilder()
                .addPath(new BezierLine(groupBPickUp2_RED, groupBPickUp3_RED))
                .setLinearHeadingInterpolation(groupBPickUp2_RED.getHeading(), groupBPickUp3_RED.getHeading())
                .build();

        ScoreGroupBShoot = follower.pathBuilder()
                .addPath(new BezierLine(groupBPickUp3_RED, shootAtBasket_RED))
                .setLinearHeadingInterpolation(groupBPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
                .build();

        ScoreGroupA = follower.pathBuilder()
                .addPath(new BezierLine(shootAtBasket_RED, PositionA_RED))
                .setLinearHeadingInterpolation(shootAtBasket_RED.getHeading(), PositionA_RED.getHeading())
                .build();

        ScoreGroupA1 = follower.pathBuilder()
                .addPath(new BezierLine(PositionA_RED, groupAPickUp1_RED))
                .setLinearHeadingInterpolation(PositionA_RED.getHeading(), groupAPickUp1_RED.getHeading())
                .build();

        ScoreGroupA2 = follower.pathBuilder()
                .addPath(new BezierLine(groupAPickUp1_RED, groupAPickUp2_RED))
                .setLinearHeadingInterpolation(groupAPickUp1_RED.getHeading(), groupAPickUp2_RED.getHeading())
                .build();

        ScoreGroupA3 = follower.pathBuilder()
                .addPath(new BezierLine(groupAPickUp2_RED, groupAPickUp3_RED))
                .setLinearHeadingInterpolation(groupAPickUp2_RED.getHeading(), groupAPickUp3_RED.getHeading())
                .build();

        ScoreGroupAShoot = follower.pathBuilder()
                .addPath(new BezierLine(groupAPickUp3_RED, shootAtBasket_RED))
                .setLinearHeadingInterpolation(groupAPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
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

        } else if (counter == 101) {
            if (pathTimer.getElapsedTimeSeconds() > 10) {
                outtakeStop();
                intakeStop();
                follower.followPath(ScoreGroupC);
                currentPath = ScoreGroupC;
                counter = 2;
            } else if (pathTimer.getElapsedTimeSeconds() > 7.5) {
                intakeStart();
            }

        } else if (counter == 2 && finishedPath(ScoreGroupC)) {
            intakeStart();
            follower.followPath(ScoreGroupC1);
            currentPath = ScoreGroupC1;
            counter = 3;

        } else if (counter == 3 && finishedPath(ScoreGroupC1)) {
            follower.followPath(ScoreGroupC2);
            currentPath = ScoreGroupC2;
            counter = 4;

        } else if (counter == 4 && finishedPath(ScoreGroupC2)) {
            follower.followPath(ScoreGroupC3);
            currentPath = ScoreGroupC3;
            counter = 5;

        } else if (counter == 5 && finishedPath(ScoreGroupC3)) {
            intakeStop();
            follower.followPath(ScoreGroupCShoot);
            currentPath = ScoreGroupCShoot;
            counter = 6;

        } else if (counter == 6 && finishedPath(ScoreGroupCShoot)) {
            outtakeStart();
            pathTimer.resetTimer();
            counter = 102;

        } else if (counter == 102) {
            if (pathTimer.getElapsedTimeSeconds() > 10) {
                outtakeStop();
                intakeStop();
                follower.followPath(ScoreGroupB);
                currentPath = ScoreGroupB;
                counter = 7;
            } else if (pathTimer.getElapsedTimeSeconds() > 7.5) {
                intakeStart();
            }

        } else if (counter == 7 && finishedPath(ScoreGroupB)) {
            intakeStart();
            follower.followPath(ScoreGroupB1);
            currentPath = ScoreGroupB1;
            counter = 8;

        } else if (counter == 8 && finishedPath(ScoreGroupB1)) {
            follower.followPath(ScoreGroupB2);
            currentPath = ScoreGroupB2;
            counter = 9;

        } else if (counter == 9 && finishedPath(ScoreGroupB2)) {
            follower.followPath(ScoreGroupB3);
            currentPath = ScoreGroupB3;
            counter = 10;

        } else if (counter == 10 && finishedPath(ScoreGroupB3)) {
            intakeStop();
            follower.followPath(ScoreGroupBShoot);
            currentPath = ScoreGroupBShoot;
            counter = 11;

        } else if (counter == 11 && finishedPath(ScoreGroupBShoot)) {
            outtakeStart();
            pathTimer.resetTimer();
            counter = 103;

        } else if (counter == 103) {
            if (pathTimer.getElapsedTimeSeconds() > 10) {
                outtakeStop();
                intakeStop();
                follower.followPath(ScoreGroupA);
                currentPath = ScoreGroupA;
                counter = 12;
            } else if (pathTimer.getElapsedTimeSeconds() > 7.5) {
                intakeStart();
            }

        } else if (counter == 12 && finishedPath(ScoreGroupA)) {
            intakeStart();
            follower.followPath(ScoreGroupA1);
            currentPath = ScoreGroupA1;
            counter = 13;

        } else if (counter == 13 && finishedPath(ScoreGroupA1)) {
            follower.followPath(ScoreGroupA2);
            currentPath = ScoreGroupA2;
            counter = 14;

        } else if (counter == 14 && finishedPath(ScoreGroupA2)) {
            follower.followPath(ScoreGroupA3);
            currentPath = ScoreGroupA3;
            counter = 15;

        } else if (counter == 15 && finishedPath(ScoreGroupA3)) {
            intakeStop();
            follower.followPath(ScoreGroupAShoot);
            currentPath = ScoreGroupAShoot;
            counter = 16;

        } else if (counter == 16 && finishedPath(ScoreGroupAShoot)) {
            outtakeStart();
            pathTimer.resetTimer();
            counter = 104;

        } else if (counter == 104) {
            if (pathTimer.getElapsedTimeSeconds() > 10) {
                outtakeStop();
                intakeStop();
                counter = 17;
            } else if (pathTimer.getElapsedTimeSeconds() > 7.5) {
                intakeStart();
            }
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
        follower.setStartingPose(StartBottom_RED);

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
