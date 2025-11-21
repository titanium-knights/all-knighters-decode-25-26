package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;

import org.firstinspires.ftc.teamcode.auton.pedroPathing.Constants;
//import org.firstinspires.ftc.teamcode.utilities.Intake;
import org.firstinspires.ftc.teamcode.utilities.Outtake;

@Autonomous(name = "RED_Bottom_ScoreONE")
public class RED_Bottom_ScoreTHREE extends OpMode {
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private int pathState;
    public Outtake outtake;
//    public Intake intake;

    private final boolean isRed = false;
    private double m(double init, boolean isRed) {
        if (isRed) { return init; }
        else { return 144 - init; }
    }
    private double mr(double init, boolean isRed) {
        if (isRed) { return Math.toRadians(init); }
        else {
            double result =
                    Math.atan2(
                            Math.sin(Math.toRadians(init)),
                            -1 * Math.cos(Math.toRadians(init))
                    );
            if (result < 0) {
                result = 360 + result;
            }
            return result;
        }
    }


    private final Pose StartBottom_RED = new Pose(96, 0,Math.toRadians(90));
    private final Pose StartBottom_BLUE = new Pose(65.25, 0,Math.toRadians(90));

    private final Pose humanPlayer_RED = new Pose(133.75, 0,Math.toRadians(0));
    private final Pose humanPlayer_BLUE = new Pose(10.25, 0,Math.toRadians(180));

    private final Pose groupCPickUp1_RED = new Pose(96, 27.375,Math.toRadians(0));
    private final Pose groupCPickUp1_BLUE = new Pose(48,44.625,Math.toRadians(180));

    private final Pose groupCPickUp2_RED = new Pose(126.75, 27.375 ,Math.toRadians(0));
    private final Pose groupCPickUp2_BLUE = new Pose(0,44.625,Math.toRadians(180));

    private final Pose groupBPickUp1_RED = new Pose(96,51.375,Math.toRadians(0));
    private final Pose groupBPickUp1_BLUE = new Pose(48,68.625,Math.toRadians(180));

    private final Pose groupBPickUp2_RED = new Pose(126.75,51.375,Math.toRadians(0));
    private final Pose groupBPickUp2_BLUE = new Pose(0,68.625,Math.toRadians(180));

    private final Pose groupAPickUp1_RED = new Pose(96,75.375,Math.toRadians(0));
    private final Pose groupAPickUp1_BLUE = new Pose(48,92.625,Math.toRadians(180));

    private final Pose groupAPickUp2_RED = new Pose(126.75,75.375,Math.toRadians(0));
    private final Pose groupAPickUp2_BLUE = new Pose(0,92.625,Math.toRadians(180));

    private final Pose shootAtBasket_RED = new Pose(120,120,Math.toRadians(45));
    private final Pose shootAtBasket_BLUE = new Pose(24,24,Math.toRadians(135));

    private PathChain ScoreFIRST;
    private PathChain ScoreSECOND;
    private PathChain ScoreTHIRD;

    public void buildPaths(){

        //do i need to add a path to the begining and end or nah

        ScoreFIRST = follower.pathBuilder()
                .addPath(new BezierLine(StartBottom_RED, humanPlayer_RED))
                .setLinearHeadingInterpolation(StartBottom_RED.getHeading(), humanPlayer_RED.getHeading())

                .addPath(new BezierLine(humanPlayer_RED, StartBottom_RED))
                .setLinearHeadingInterpolation(humanPlayer_RED.getHeading(), StartBottom_RED.getHeading())

                .addPath(new BezierLine(StartBottom_RED, groupCPickUp1_RED))
                .setLinearHeadingInterpolation(StartBottom_RED.getHeading(), groupCPickUp1_RED.getHeading())

                .addPath(new BezierLine(groupCPickUp1_RED, groupCPickUp2_RED))
                .setLinearHeadingInterpolation(groupCPickUp1_RED.getHeading(), groupCPickUp2_RED.getHeading())

                .addPath(new BezierLine(groupCPickUp2_RED, shootAtBasket_RED))
                .setLinearHeadingInterpolation(groupCPickUp2_RED.getHeading(), shootAtBasket_RED.getHeading())
                .build();
        ScoreSECOND = follower.pathBuilder()
                .addPath(new BezierLine(shootAtBasket_RED, groupBPickUp1_RED))
                .setLinearHeadingInterpolation(shootAtBasket_RED.getHeading(), groupBPickUp1_RED.getHeading())

                .addPath(new BezierLine(groupBPickUp1_RED, groupBPickUp2_RED))
                .setLinearHeadingInterpolation(groupBPickUp1_RED.getHeading(), groupBPickUp2_RED.getHeading())

                .addPath(new BezierLine(groupBPickUp2_RED, shootAtBasket_RED))
                .setLinearHeadingInterpolation(groupBPickUp2_RED.getHeading(), shootAtBasket_RED.getHeading())
                .build();
        ScoreTHIRD = follower.pathBuilder()
                .addPath(new BezierLine(shootAtBasket_RED, groupAPickUp1_RED))
                .setLinearHeadingInterpolation(shootAtBasket_RED.getHeading(), groupAPickUp1_RED.getHeading())

                .addPath(new BezierLine(groupAPickUp1_RED, groupAPickUp2_RED))
                .setLinearHeadingInterpolation(groupAPickUp1_RED.getHeading(), groupAPickUp2_RED.getHeading())

                .addPath(new BezierLine(groupAPickUp2_RED, shootAtBasket_RED))
                .setLinearHeadingInterpolation(groupAPickUp2_RED.getHeading(), shootAtBasket_RED.getHeading())

                .build();

    }


    private int counter = 0;
    public void autonomousPathUpdate() {
        if (counter == 0) {
            follower.followPath(ScoreFIRST);
            counter = 1;
        }
        if (counter == 1) {
            follower.followPath(ScoreSECOND);
            counter = 2;
        }
        if (counter == 2) {
            follower.followPath(ScoreTHIRD);
            counter = 3;
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








