package org.firstinspires.ftc.teamcode.auton.inci;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import org.firstinspires.ftc.teamcode.auton.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.utilities.OuttakeKT;

@Autonomous(name = "redBottom")
public class redBottom extends IncMode {
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private int pathState;


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
    public void autonomousPathUpdate() {

        if (counter == 0) {
            follower.followPath(ScoreHOME);
            counter = 1;
        }
        if (counter == 1) {
            if ((Math.abs(follower.getPose().getX() - PositionC_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - PositionC_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupC1);
                intakeStop();
                counter = 2;
            }
        }
        if (counter == 2) {
            if((Math.abs(follower.getPose().getX() - groupCPickUp1_RED.getX()) < 1 ) && Math.abs(follower.getPose().getY() - groupCPickUp1_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupC2);
                intakeStop();
                counter = 3;
            }
        }
        if (counter == 3) {
            if ((Math.abs(follower.getPose().getX() - groupCPickUp2_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupCPickUp2_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupC2);
                intakeStop();
                counter = 4;
            }
        }
        if (counter == 4) {
            if ((Math.abs(follower.getPose().getX() - groupCPickUp3_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupCPickUp3_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupC3);
                intakeStop();
                counter = 5;
            }
        }if (counter == 5) {
            if ((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
                outtakeStart();
                follower.followPath(ScoreGroupCShoot);
                outtakeStop();
                counter = 6;
            }
        }
        if (counter == 6) {
            if ((Math.abs(follower.getPose().getX() - PositionB_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - PositionB_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupB);
                intakeStop();
                counter = 7;
            }
        }
        if (counter == 7) {
            if ((Math.abs(follower.getPose().getX() - groupBPickUp1_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupBPickUp1_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupB1);
                intakeStop();
                counter = 8;
            }
        }
        if (counter == 8) {
            if ((Math.abs(follower.getPose().getX() - groupBPickUp2_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupBPickUp2_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupB2);
                intakeStop();
                counter = 9;
            }
        }
        if (counter == 9) {
            if ((Math.abs(follower.getPose().getX() - groupBPickUp3_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupBPickUp3_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupB3);
                intakeStop();
                counter = 10;
            }
        }
        if (counter == 10) {
            if ((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
                outtakeStart();
                follower.followPath(ScoreGroupBShoot);
                outtakeStop();
                counter = 11;
            }
        }
        if (counter == 11) {
            if ((Math.abs(follower.getPose().getX() - PositionA_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - PositionA_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupA);
                intakeStop();
                counter = 12;
            }
        }
        if (counter == 12) {
            if ((Math.abs(follower.getPose().getX() - groupAPickUp1_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupAPickUp1_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupA1);
                intakeStop();
                counter = 13;
            }
        }
        if (counter == 13) {
            if ((Math.abs(follower.getPose().getX() - groupAPickUp2_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupAPickUp2_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupA2);
                intakeStop();
                counter = 14;
            }
        }
        if (counter == 14) {
            if ((Math.abs(follower.getPose().getX() - groupAPickUp3_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupAPickUp3_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreGroupA3);
                intakeStop();
                counter = 15;
            }
        }
        if (counter == 15) {
            if ((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
                outtakeStart();
                follower.followPath(ScoreGroupAShoot);
                outtakeStop();
                counter = 7;
            }
        }
    }

    public void setPathState(int pState) {
        pathState = pState;
        pathTimer.resetTimer();
    }

    @Override
    public void loop() {
        // These loop the movements of the robot
        follower.update();
        autonomousPathUpdate();

        // Feedback to Driver Hub
        telemetry.addData("path state", pathState);
        telemetry.addData("x", follower.getPose().getX());
        telemetry.addData("y", follower.getPose().getY());
        telemetry.addData("heading", follower.getPose().getHeading());
        telemetry.update();
    }

    @Override
    public void init() {
        pathTimer = new Timer();
//        Constants.setConstants(FConstants.class, LConstants.class);
        opmodeTimer = new Timer();

        opmodeTimer.resetTimer();

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(StartBottom_RED);

        buildPaths();
        // TODO: give hardware map the same name when we figure it out
        OuttakeKT outtake = new OuttakeKT(hardwareMap, telemetry);
//        intake = new Intake(hardwareMap, telemetry);

        //TODO: add the position you would want everything to start at here like claw.closed()
    }

    @Override
    public void init_loop() {}

    @Override
    public void start() {
        opmodeTimer.resetTimer();
        setPathState(0);
    }

    @Override
    public void stop() {
    }
    // jajajaja
}








