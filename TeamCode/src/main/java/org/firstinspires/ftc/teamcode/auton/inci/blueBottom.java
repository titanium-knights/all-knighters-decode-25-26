package org.firstinspires.ftc.teamcode.auton.inci;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;

import org.firstinspires.ftc.teamcode.auton.AutonMethods;
import org.firstinspires.ftc.teamcode.auton.pedroPathing.Constants;
//import org.firstinspires.ftc.teamcode.utilities.Intake;
import org.firstinspires.ftc.teamcode.utilities.Outtake;
import org.firstinspires.ftc.teamcode.utilities.OuttakeKT;

@Autonomous(name = "blueBottom")
public class blueBottom extends InciMethods {
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private int pathState;
    public OuttakeKT outtake;
//    public Intake intake;


    private final Pose StartBottom_BLUE = new Pose(89, 0,Math.toRadians(90));

    private final Pose ShootBottom_BLUE = new Pose(89, 6.5,Math.toRadians(62.36));

    private final Pose PositionC_BLUE = new Pose(96, 30,Math.toRadians(270));

    private final Pose groupCPickUp1_BLUE = new Pose(100, 30,Math.toRadians(270));

    private final Pose groupCPickUp2_BLUE = new Pose(105,30 ,Math.toRadians(270));

    private final Pose groupCPickUp3_BLUE = new Pose(110,30 ,Math.toRadians(270));

    private final Pose PositionB_BLUE = new Pose(96, 54,Math.toRadians(270));

    private final Pose groupBPickUp1_BLUE = new Pose(100,54,Math.toRadians(270));

    private final Pose groupBPickUp2_BLUE = new Pose(105,54,Math.toRadians(270));

    private final Pose groupBPickUp3_BLUE = new Pose(110,54,Math.toRadians(270));

    private final Pose PositionA_BLUE = new Pose(96,78,Math.toRadians(270));

    private final Pose groupAPickUp1_BLUE = new Pose(100,78,Math.toRadians(270));

    private final Pose groupAPickUp2_BLUE = new Pose(105,78,Math.toRadians(270));

    private final Pose groupAPickUp3_BLUE = new Pose(110,78,Math.toRadians(270));

    private final Pose shootAtBasket_BLUE = new Pose(74,74,Math.toRadians(45));

    private PathChain ScoreHOME, ScoreFIRST, ScoreSECOND, ScoreTHIRD;

    public void buildPaths(){


        ScoreHOME = follower.pathBuilder()
                .addPath(new BezierLine(StartBottom_RED, ShootBottom_RED))
                .setLinearHeadingInterpolation(StartBottom_RED.getHeading(), ShootBottom_RED.getHeading())
                .build();

        ScoreFIRST = follower.pathBuilder()

                .addPath(new BezierLine(ShootBottom_RED, PositionC_RED))
                .setLinearHeadingInterpolation(ShootBottom_RED.getHeading(), PositionC_RED.getHeading())

                .addPath(new BezierLine(PositionC_RED, groupCPickUp1_RED))
                .setLinearHeadingInterpolation(PositionC_RED.getHeading(), groupCPickUp1_RED.getHeading())

                .addPath(new BezierLine(groupCPickUp1_RED, groupCPickUp2_RED))
                .setLinearHeadingInterpolation(groupCPickUp1_RED.getHeading(), groupCPickUp2_RED.getHeading())

                .addPath(new BezierLine(groupCPickUp2_RED, groupCPickUp3_RED))
                .setLinearHeadingInterpolation(groupCPickUp2_RED.getHeading(), groupCPickUp3_RED.getHeading())

                .addPath(new BezierLine(groupCPickUp3_RED,shootAtBasket_RED))
                .setLinearHeadingInterpolation(groupCPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
                .build();

        ScoreSECOND = follower.pathBuilder()

                .addPath(new BezierLine(shootAtBasket_RED, PositionB_RED))
                .setLinearHeadingInterpolation(shootAtBasket_RED.getHeading(), PositionB_RED.getHeading())

                .addPath(new BezierLine(PositionB_RED, groupBPickUp1_RED))
                .setLinearHeadingInterpolation(PositionB_RED.getHeading(), groupBPickUp1_RED.getHeading())

                .addPath(new BezierLine(groupBPickUp1_RED, groupBPickUp2_RED))
                .setLinearHeadingInterpolation(groupBPickUp1_RED.getHeading(), groupBPickUp2_RED.getHeading())

                .addPath(new BezierLine(groupBPickUp2_RED, groupBPickUp3_RED))
                .setLinearHeadingInterpolation(groupBPickUp2_RED.getHeading(), groupBPickUp3_RED.getHeading())

                .addPath(new BezierLine(groupBPickUp3_RED, shootAtBasket_RED))
                .setLinearHeadingInterpolation(groupBPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
                .build();

        ScoreTHIRD = follower.pathBuilder()
                .addPath(new BezierLine(shootAtBasket_RED, PositionC_RED))
                .setLinearHeadingInterpolation(shootAtBasket_RED.getHeading(), PositionC_RED.getHeading())

                .addPath(new BezierLine(PositionC_RED, groupCPickUp1_RED))
                .setLinearHeadingInterpolation(PositionC_RED.getHeading(), groupCPickUp1_RED.getHeading())

                .addPath(new BezierLine(groupCPickUp1_RED, groupCPickUp2_RED))
                .setLinearHeadingInterpolation(groupCPickUp1_RED.getHeading(), groupCPickUp2_RED.getHeading())

                .addPath(new BezierLine(groupCPickUp2_RED, groupCPickUp3_RED))
                .setLinearHeadingInterpolation(groupCPickUp2_RED.getHeading(), groupCPickUp3_RED.getHeading())

                .addPath(new BezierLine(groupCPickUp3_RED, shootAtBasket_RED))
                .setLinearHeadingInterpolation(groupCPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
                .build();

    }


    private int counter = 0;
    public void autonomousPathUpdate() {

        if (counter == 0) {
            follower.followPath(ScoreHOME);
            counter = 1;
        }
        if (counter == 1) {
            if((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
                //shoot
                follower.followPath(ScoreFIRST);
                counter = 2;
            }
        }
        if (counter == 2) {
            if((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
                //shoot
                follower.followPath(ScoreSECOND);
                counter = 3;
            }
            if (counter == 3) {
                if((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
                    //shoot
                    follower.followPath(ScoreTHIRD);
                    counter = 4;
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
                outtake = new Outtake(hardwareMap, telemetry);
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








