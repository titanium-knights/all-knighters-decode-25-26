package org.firstinspires.ftc.teamcode.auton.inci;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.auton.pedroPathing.Constants;
// import org.firstinspires.ftc.teamcode.utilities.Intake;
import org.firstinspires.ftc.teamcode.utilities.Intake;
import org.firstinspires.ftc.teamcode.utilities.OuttakeKT;

@Autonomous(name = "blueBottom")
public class blueBottom extends IncMode {
    private final Pose StartBottom_BLUE = new Pose(89, 0, Math.toRadians(90));
    private final Pose ShootBottom_BLUE = new Pose(89, 6.5, Math.toRadians(62.36));
    private final Pose PositionC_BLUE = new Pose(96, 30, Math.toRadians(270));
    private final Pose groupCPickUp1_BLUE = new Pose(100, 30, Math.toRadians(270));
    private final Pose groupCPickUp2_BLUE = new Pose(105, 30, Math.toRadians(270));
    private final Pose groupCPickUp3_BLUE = new Pose(110, 30, Math.toRadians(270));
    private final Pose PositionB_BLUE = new Pose(96, 54, Math.toRadians(270));
    private final Pose groupBPickUp1_BLUE = new Pose(100, 54, Math.toRadians(270));
    private final Pose groupBPickUp2_BLUE = new Pose(105, 54, Math.toRadians(270));
    private final Pose groupBPickUp3_BLUE = new Pose(110, 54, Math.toRadians(270));
    private final Pose PositionA_BLUE = new Pose(96, 78, Math.toRadians(270));
    private final Pose groupAPickUp1_BLUE = new Pose(100, 78, Math.toRadians(270));
    private final Pose groupAPickUp2_BLUE = new Pose(105, 78, Math.toRadians(270));
    private final Pose groupAPickUp3_BLUE = new Pose(110, 78, Math.toRadians(270));
    private final Pose shootAtBasket_BLUE = new Pose(74, 74, Math.toRadians(45));
    public OuttakeKT outtake;
    public Intake intake;
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private int pathState;
    private Telemetry telemetry;
    private PathChain ScoreHOME, ScoreFIRST, ScoreSECOND, ScoreTHIRD;
    private int counter = 0;

    public void buildPaths() {

        ScoreHOME =
                follower.pathBuilder()
                        .addPath(new BezierLine(StartBottom_BLUE, ShootBottom_BLUE))
                        .setLinearHeadingInterpolation(
                                StartBottom_BLUE.getHeading(), ShootBottom_BLUE.getHeading())
                        .build();

        ScoreFIRST =
                follower.pathBuilder()
                        .addPath(new BezierLine(ShootBottom_BLUE, PositionC_BLUE))
                        .setLinearHeadingInterpolation(
                                ShootBottom_BLUE.getHeading(), PositionC_BLUE.getHeading())
                        .addPath(new BezierLine(PositionC_BLUE, groupCPickUp1_BLUE))
                        .setLinearHeadingInterpolation(
                                PositionC_BLUE.getHeading(), groupCPickUp1_BLUE.getHeading())
                        .addPath(new BezierLine(groupCPickUp1_BLUE, groupCPickUp2_BLUE))
                        .setLinearHeadingInterpolation(
                                groupCPickUp1_BLUE.getHeading(), groupCPickUp2_BLUE.getHeading())
                        .addPath(new BezierLine(groupCPickUp2_BLUE, groupCPickUp3_BLUE))
                        .setLinearHeadingInterpolation(
                                groupCPickUp2_BLUE.getHeading(), groupCPickUp3_BLUE.getHeading())
                        .addPath(new BezierLine(groupCPickUp3_BLUE, shootAtBasket_BLUE))
                        .setLinearHeadingInterpolation(
                                groupCPickUp3_BLUE.getHeading(), shootAtBasket_BLUE.getHeading())
                        .build();

        ScoreSECOND =
                follower.pathBuilder()
                        .addPath(new BezierLine(shootAtBasket_BLUE, PositionB_BLUE))
                        .setLinearHeadingInterpolation(
                                shootAtBasket_BLUE.getHeading(), PositionB_BLUE.getHeading())
                        .addPath(new BezierLine(PositionB_BLUE, groupBPickUp1_BLUE))
                        .setLinearHeadingInterpolation(
                                PositionB_BLUE.getHeading(), groupBPickUp1_BLUE.getHeading())
                        .addPath(new BezierLine(groupBPickUp1_BLUE, groupBPickUp2_BLUE))
                        .setLinearHeadingInterpolation(
                                groupBPickUp1_BLUE.getHeading(), groupBPickUp2_BLUE.getHeading())
                        .addPath(new BezierLine(groupBPickUp2_BLUE, groupBPickUp3_BLUE))
                        .setLinearHeadingInterpolation(
                                groupBPickUp2_BLUE.getHeading(), groupBPickUp3_BLUE.getHeading())
                        .addPath(new BezierLine(groupBPickUp3_BLUE, shootAtBasket_BLUE))
                        .setLinearHeadingInterpolation(
                                groupBPickUp3_BLUE.getHeading(), shootAtBasket_BLUE.getHeading())
                        .build();

        ScoreTHIRD =
                follower.pathBuilder()
                        .addPath(new BezierLine(shootAtBasket_BLUE, PositionC_BLUE))
                        .setLinearHeadingInterpolation(
                                shootAtBasket_BLUE.getHeading(), PositionC_BLUE.getHeading())
                        .addPath(new BezierLine(PositionC_BLUE, groupCPickUp1_BLUE))
                        .setLinearHeadingInterpolation(
                                PositionC_BLUE.getHeading(), groupCPickUp1_BLUE.getHeading())
                        .addPath(new BezierLine(groupCPickUp1_BLUE, groupCPickUp2_BLUE))
                        .setLinearHeadingInterpolation(
                                groupCPickUp1_BLUE.getHeading(), groupCPickUp2_BLUE.getHeading())
                        .addPath(new BezierLine(groupCPickUp2_BLUE, groupCPickUp3_BLUE))
                        .setLinearHeadingInterpolation(
                                groupCPickUp2_BLUE.getHeading(), groupCPickUp3_BLUE.getHeading())
                        .addPath(new BezierLine(groupCPickUp3_BLUE, shootAtBasket_BLUE))
                        .setLinearHeadingInterpolation(
                                groupCPickUp3_BLUE.getHeading(), shootAtBasket_BLUE.getHeading())
                        .build();
    }

    public void autonomousPathUpdate() {
        if (counter == 0) {
            follower.followPath(ScoreHOME);
            counter = 1;
        }
        if (counter == 1) {
            if ((Math.abs(follower.getPose().getX() - shootAtBasket_BLUE.getX()) < 1)
                    && Math.abs(follower.getPose().getY() - shootAtBasket_BLUE.getY()) < 1) {
                // shoot
                follower.followPath(ScoreFIRST);
                counter = 2;
            }
        }
        if (counter == 2) {
            if ((Math.abs(follower.getPose().getX() - shootAtBasket_BLUE.getX()) < 1)
                    && Math.abs(follower.getPose().getY() - shootAtBasket_BLUE.getY()) < 1) {
                // shoot
                follower.followPath(ScoreSECOND);
                counter = 3;
            }
            if (counter == 3) {
                if ((Math.abs(follower.getPose().getX() - shootAtBasket_BLUE.getX()) < 1)
                        && Math.abs(follower.getPose().getY() - shootAtBasket_BLUE.getY()) < 1) {
                    // shoot
                    follower.followPath(ScoreTHIRD);
                    counter = 4;
                }
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
        follower.setStartingPose(StartBottom_BLUE);

        buildPaths();
        // TODO: give hardware map the same name when we figure it out
        outtake = new OuttakeKT(hardwareMap, telemetry);
        //        intake = new Intake(hardwareMap, telemetry);

        // TODO: add the position you would want everything to start at here like claw.closed()
    }

    @Override
    public void init_loop() {}

    @Override
    public void start() {
        opmodeTimer.resetTimer();
        setPathState(0);
    }

    @Override
    public void stop() {}
    // jajajaja
}
