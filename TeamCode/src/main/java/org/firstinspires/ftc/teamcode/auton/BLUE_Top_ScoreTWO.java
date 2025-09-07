//package org.firstinspires.ftc.teamcode.auton;
//
//
//
//import com.pedropathing.follower.Follower;
//import com.pedropathing.geometry.BezierLine;
//import com.pedropathing.geometry.Pose;
//import com.pedropathing.paths.Path;
//import com.pedropathing.paths.PathChain;
//import com.pedropathing.util.Timer;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.pedropathing.pathgen.Point;
//
//import org.firstinspires.ftc.teamcode.utilities.CameraAngle;
//import org.firstinspires.ftc.teamcode.utilities.Intake;
//import org.firstinspires.ftc.teamcode.utilities.Launch;
//import org.firstinspires.ftc.teamcode.utilities.Release;
//import org.firstinspires.ftc.teamcode.utilities.Sorting;
//
//@Autonomous(name = "BLUE_Top_ScoreTWO")
//public class BLUE_Top_ScoreTWO {
//    private boolean isRed = false;
//    private Follower follower;
//    private Timer pathTimer, actionTimer, opmodeTimer;
//    private int pathState;
//    public Launch launch;
//    public Release release;
//    public Intake intake;
//    public CameraAngle cameraAngle;
//    public Sorting sorting;
//
//    private final Pose StartPoint = new Pose(m(24,isRed), 120, Math.toRadians(mr(135, isRed)));
//    private final Pose StartPoint_Turn = new Pose(m(24,isRed), 120, Math.toRadians(mr(270,isRed)));
//    private final Pose PickingUpFIRST = new Pose(m(24,isRed), 84, Math.toRadians(mr(270, isRed)));
//    //dropping off first would be going to StartPoint_Turn + StartPoint
//    //then you would StartPoint_Turn again and go to:
//
//    private final Pose PickingUpSECOND = new Pose(m(24,isRed), 60, Math.toRadians(mr(270, isRed)));
//    //dropping off second would be going to StartPoint_Turn + StartPoint
//
//    //TODO: Wrong numbers + no park ( do we need a park?)
//    //TODO: desc: uneficent way to score, initial scored, first and second scored touching basket
//
//    private PathChain ScoreFIRST, ScoreSECOND;
//
//    public void buildPaths(){
//
//        //do i need to add a path to the begining and end or nah
//
//        ScoreFIRST = follower.pathBuilder()
//                .addPath((new BezierLine(new Point(StartPoint), new Point(StartPoint_Turn))))
//                .setLinearHeadingInterpolation(StartPoint.getHeading(),   StartPoint_Turn.getHeading());
//                .addPath((new BezierLine(new Point(StartPoint_Turn), new Point(PickingUpFIRST))))
//                .setLinearHeadingInterpolation(StartPoint_Turn.getHeading(),   PickingUpFIRST.getHeading());
//                .addPath((new BezierLine(new Point(PickingUpFIRST), new Point(StartPoint_Turn))))
//                .setLinearHeadingInterpolation(PickingUpFIRST.getHeading(),   StartPoint_Turn.getHeading());
//                .addPath((new BezierLine(new Point(StartPoint_Turn), new Point(StartPoint))))
//                .setLinearHeadingInterpolation(StartPoint_Turn.getHeading(),   StartPoint.getHeading());
//                .build();
//
//
//        ScoreSECOND = follower.pathBuilder()
//                .addPath((new BezierLine(new Point(StartPoint), new Point(StartPoint_Turn))))
//                .setLinearHeadingInterpolation(StartPoint.getHeading(),   StartPoint_Turn.getHeading());
//                .addPath((new BezierLine(new Point(StartPoint_Turn), new Point(PickingUpSECOND))))
//                .setLinearHeadingInterpolation(StartPoint_Turn.getHeading(),   PickingUpSECOND.getHeading());
//                .addPath((new BezierLine(new Point(PickingUpSECOND), new Point(StartPoint_Turn))))
//                .setLinearHeadingInterpolation(PickingUpSECOND.getHeading(),   StartPoint_Turn.getHeading());
//                .addPath((new BezierLine(new Point(StartPoint_Turn), new Point(StartPoint))))
//                .setLinearHeadingInterpolation(StartPoint_Turn.getHeading(),   StartPoint.getHeading());
//                .build();
//
//    }
//
//    private int counter = 0;
//    public void autonomousPathUpdate() {
//        if (counter == 0) {
//            follower.followPath(ScoreFIRST);
//            counter = 1;
//        }
//        if (counter == 1) {
//            if ((Math.abs(follower.getPose().getX() - StartPoint.getX()) < 1) && Math.abs(follower.getPose().getY() - StartPoint.getY()) < 1) {
//                follower.followPath(ScoreSECOND, true);
//                counter = 2;
//            }
//        }
//    }
//
//    public void setPathState(int pState) {
//        pathState = pState;
//        pathTimer.resetTimer();
//    }
//
//    @Override
//    public void loop() {
//        // These loop the movements of the robot
//        follower.update();
//        autonomousPathUpdate();
//
//        // Feedback to Driver Hub
//        telemetry.addData("path state", pathState);
//        telemetry.addData("x", follower.getPose().getX());
//        telemetry.addData("y", follower.getPose().getY());
//        telemetry.addData("heading", follower.getPose().getHeading());
//        telemetry.update();
//    }
//
//    @Override
//    public void init() {
//        pathTimer = new Timer();
//        Constants.setConstants(FConstants.class, LConstants.class);
//        opmodeTimer = new Timer();
//
//        opmodeTimer.resetTimer();
//
//        follower = new Follower(hardwareMap);
//        follower.setStartingPose(StartPoint);
//
//        buildPaths();
//        //TODO: give hardware map the same name when we figure it out
//        sorting = new Sorting(hmap, telemetry);
//        release = new Release(hmap, telemetry);
//        cameraAngle = new CameraAngle(hmap, telemetry);
//        launch = new Launch(hmap, telemetry);
//        intake = new Intake(hmap, telemetry);
//
//        //TODO: add the position you would want everything to start at here like claw.closed()
//    }
//
//    @Override
//    public void init_loop() {}
//
//    @Override
//    public void start() {
//        opmodeTimer.resetTimer();
//        setPathState(0);
//    }
//
//    @Override
//    public void stop() {
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
