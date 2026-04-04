package org.firstinspires.ftc.teamcode.auton.inci.anotherDollar;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.inci.IncMode;
import org.firstinspires.ftc.teamcode.auton.pedroPathing.Constants;

// import org.firstinspires.ftc.teamcode.utilities.Intake;

@Autonomous(name = "RedPLTop")
public class RedPLTop extends IncMode {
    private final Pose StartTop = new Pose(0, 0, 0);
    private final Pose ShootTop = new Pose(62.610831, 7.58995288, 0.3);
    private final Pose LeaveTriangle = new Pose(62.610831, 7.58995288 + 6.7, 0.3);
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private PathChain Score, Exit;
    private int counter = 0;
    private PathChain currentPath;

    public void buildPaths() {
        Score =
                follower.pathBuilder()
                        .addPath(new BezierLine(StartTop, ShootTop))
                        .setLinearHeadingInterpolation(StartTop.getHeading(), ShootTop.getHeading())
                        .build();
        Exit =
                follower.pathBuilder()
                        .addPath(new BezierLine(ShootTop, LeaveTriangle))
                        .setLinearHeadingInterpolation(ShootTop.getHeading(), LeaveTriangle.getHeading())
                        .build();

    }

    private boolean finishedPath(PathChain path) {
        Pose pose = path.endPose();
        return Math.abs(follower.getPose().getX() - pose.getX()) < 1
                && Math.abs(follower.getPose().getY() - pose.getY()) < 1;
    }

    public void autonomousPathUpdate() {

        if (counter == 0) {
            follower.followPath(Score);
            currentPath = Score;
            counter = 1;

        } else if (counter == 1 && finishedPath(Score)) {
            outtakeStart();
            pathTimer.resetTimer();
            counter = 101;
        } else if (counter == 101) {
            if (pathTimer.getElapsedTimeSeconds() > 12) {
                outtakeStop();
                intakeStop();
                counter = 2;
            } else if (pathTimer.getElapsedTimeSeconds() > 9.9) {
                intakeStart(1.0);
            } else if (pathTimer.getElapsedTimeSeconds() > 6.9) {
                intakeStop();
            } else if (pathTimer.getElapsedTimeSeconds() > 6.7) {
                intakeReverse();
            } else if (pathTimer.getElapsedTimeSeconds() > 6.35) {
                intakeStop();
            } else if (pathTimer.getElapsedTimeSeconds() > 6.3) {
                intakeStart();
            } else if (pathTimer.getElapsedTimeSeconds() > 3.2) {
                intakeStop();
            } else if (pathTimer.getElapsedTimeSeconds() > 3.1) {
                intakeStart();
            }
        }else if (counter == 2) {
            follower.followPath(Exit);
            currentPath = Exit;
            counter = 3;
        } else if (counter == 3) {
            follower.holdPoint(LeaveTriangle);
        }
    }

    @Override
    public void loop() {
        // These loop the movements of the robot
        follower.update();
        autonomousPathUpdate();

        // Feedback to Driver Hub
        telemetry.addData("path state", counter);
        telemetry.addLine(
                String.format(
                        "x: %.2f -> %.2f",
                        follower.getPose().getX(), currentPath.endPose().getX()));
        telemetry.addLine(
                String.format(
                        "y: %.2f -> %.2f",
                        follower.getPose().getY(), currentPath.endPose().getY()));
        telemetry.addLine(
                String.format(
                        "h: %.2f -> %.2f",
                        follower.getPose().getHeading(), currentPath.endPose().getHeading()));
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
        follower.setStartingPose(StartTop);

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
