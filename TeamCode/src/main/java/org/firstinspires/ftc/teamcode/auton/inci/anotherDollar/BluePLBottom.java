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

@Autonomous(name = "BluePLBottom")
public class BluePLBottom extends IncMode {
    private final Pose StartBottom = new Pose(65, 0, Math.toRadians(90));
    private final Pose ShootBottom = new Pose(65, 100, Math.toRadians(-45));
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private PathChain Score;
    private int counter = 0;
    private PathChain currentPath;

    public void buildPaths(){
        Score = follower.pathBuilder()
                .addPath(new BezierLine(StartBottom, ShootBottom))
                .setLinearHeadingInterpolation(StartBottom.getHeading(), ShootBottom.getHeading())
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
            if (pathTimer.getElapsedTimeSeconds() > 9.5) {
                outtakeStop();
                intakeStop();
                counter = 2;
            } else if (pathTimer.getElapsedTimeSeconds() > 9) {
                intakeStart();
            } else if (pathTimer.getElapsedTimeSeconds() > 8.5) {
                intakeStop();
            } else if (pathTimer.getElapsedTimeSeconds() > 8) {
                intakeStart();
            } else if (pathTimer.getElapsedTimeSeconds() > 7.5) {
                intakeStop();
            } else if (pathTimer.getElapsedTimeSeconds() > 7) {
                intakeStart();
            } else if (pathTimer.getElapsedTimeSeconds() > 6.5) {
                intakeStop();
            } else if (pathTimer.getElapsedTimeSeconds() > 6) {
                intakeStart();
            } else if (pathTimer.getElapsedTimeSeconds() > 5.5) {
                intakeStop();
            } else if (pathTimer.getElapsedTimeSeconds() > 5) {
                intakeStart();
            } else if (pathTimer.getElapsedTimeSeconds() > 4.5) {
                intakeStop();
            } else if (pathTimer.getElapsedTimeSeconds() > 4) {
                intakeStart();
            } else if (pathTimer.getElapsedTimeSeconds() > 3.5) {
                intakeStop();
            } else if (pathTimer.getElapsedTimeSeconds() > 3) {
                intakeStart();
            }

        } else if (counter == 2) {
            follower.holdPoint(ShootBottom);
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
        follower.setStartingPose(StartBottom);

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
