package org.firstinspires.ftc.teamcode.auton.inci;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auton.pedroPathing.Constants;

@Autonomous(name = "MF")
public class MF extends IncMode {
    private final Pose start = new Pose(0, 24, Math.toRadians(0));
    private final Pose one = new Pose(24, 24, Math.toRadians(45));
    private final Pose two = new Pose(0, 0, Math.toRadians(45));

    private Follower follower;
    private Timer opmodeTimer;
    private PathChain sigma1, sigma2, sigma3;
    private int counter = 0;
    private PathChain currentPath;

    public void buildPaths() {

        sigma1 =
                follower.pathBuilder()
                        .addPath(new BezierLine(start, one))
                        .setLinearHeadingInterpolation(start.getHeading(), one.getHeading())
                        .build();
        sigma2 =
                follower.pathBuilder()
                        .addPath(new BezierLine(one, two))
                        .setLinearHeadingInterpolation(one.getHeading(), two.getHeading())
                        .build();
        sigma3 =
                follower.pathBuilder()
                        .addPath(new BezierLine(two, start))
                        .setLinearHeadingInterpolation(two.getHeading(), start.getHeading())
                        .build();
    }

    public void autonomousPathUpdate() {
        if (counter == 0) {
            follower.followPath(sigma1);
            currentPath = sigma1;
            counter = 1;
        } else if (counter == 1 && !follower.isBusy()) {
            follower.followPath(sigma2);
            currentPath = sigma2;
            counter = 2;
        } else if (counter == 2 && !follower.isBusy()) {
            follower.followPath(sigma3);
            currentPath = sigma3;
            counter = 3;
        } else if (counter == 3) {
            follower.holdPoint(start);
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
        opmodeTimer = new Timer();

        opmodeTimer.resetTimer();

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(start);

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
