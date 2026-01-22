//package org.firstinspires.ftc.teamcode.auton.inci;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//
//import com.pedropathing.follower.Follower;
//import com.pedropathing.geometry.BezierLine;
//import com.pedropathing.geometry.Pose;
//import com.pedropathing.paths.PathChain;
//import com.pedropathing.util.Timer;
//import org.firstinspires.ftc.teamcode.auton.pedroPathing.Constants;
//import org.firstinspires.ftc.teamcode.utilities.OuttakeKT;
//
//@Autonomous(name = "redBottom")
//public class redBottom extends OpMode {
//    private Follower follower;
//    private Timer pathTimer, actionTimer, opmodeTimer;
//    private int pathState;
//
//
//    private final Pose StartBottom_RED = new Pose(72, 0,Math.toRadians(90));
//
//    private final Pose ShootBottom_RED = new Pose(72, 6.5,Math.toRadians(117.64));
//
//    private final Pose PositionC_RED = new Pose(48, 42,Math.toRadians(180));
//
//    private final Pose groupCPickUp1_RED = new Pose(44, 42,Math.toRadians(180));
//
//    private final Pose groupCPickUp2_RED = new Pose(39,42 ,Math.toRadians(180));
//
//    private final Pose groupCPickUp3_RED = new Pose(34,42 ,Math.toRadians(180));
//
//    private final Pose PositionB_RED = new Pose(48, 66,Math.toRadians(180));
//
//    private final Pose groupBPickUp1_RED = new Pose(44,66,Math.toRadians(180));
//
//    private final Pose groupBPickUp2_RED = new Pose(39,66,Math.toRadians(180));
//
//    private final Pose groupBPickUp3_RED = new Pose(34,66,Math.toRadians(180));
//
//    private final Pose PositionA_RED = new Pose(48, 90,Math.toRadians(180));
//
//    private final Pose groupAPickUp1_RED = new Pose(44,90,Math.toRadians(180));
//
//    private final Pose groupAPickUp2_RED = new Pose(39,90,Math.toRadians(180));
//
//    private final Pose groupAPickUp3_RED = new Pose(34,90,Math.toRadians(180));
//
//    private final Pose shootAtBasket_RED = new Pose(70,74,Math.toRadians(135));
//
//    private PathChain ScoreHOME, ScoreFIRST, ScoreSECOND, ScoreTHIRD;
//
//    public void buildPaths(){
//
//
//        ScoreHOME = follower.pathBuilder()
//                .addPath(new BezierLine(StartBottom_RED, ShootBottom_RED))
//                .setLinearHeadingInterpolation(StartBottom_RED.getHeading(), ShootBottom_RED.getHeading())
//                .build();
//
//        ScoreFIRST = follower.pathBuilder()
//
//                .addPath(new BezierLine(ShootBottom_RED, PositionC_RED))
//                .setLinearHeadingInterpolation(ShootBottom_RED.getHeading(), PositionC_RED.getHeading())
//
//                .addPath(new BezierLine(PositionC_RED, groupCPickUp1_RED))
//                .setLinearHeadingInterpolation(PositionC_RED.getHeading(), groupCPickUp1_RED.getHeading())
//
//                .addPath(new BezierLine(groupCPickUp1_RED, groupCPickUp2_RED))
//                .setLinearHeadingInterpolation(groupCPickUp1_RED.getHeading(), groupCPickUp2_RED.getHeading())
//
//                .addPath(new BezierLine(groupCPickUp2_RED, groupCPickUp3_RED))
//                .setLinearHeadingInterpolation(groupCPickUp2_RED.getHeading(), groupCPickUp3_RED.getHeading())
//
//                .addPath(new BezierLine(groupCPickUp3_RED,shootAtBasket_RED))
//                .setLinearHeadingInterpolation(groupCPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
//                .build();
//
//        ScoreSECOND = follower.pathBuilder()
//
//                .addPath(new BezierLine(shootAtBasket_RED, PositionB_RED))
//                .setLinearHeadingInterpolation(shootAtBasket_RED.getHeading(), PositionB_RED.getHeading())
//
//                .addPath(new BezierLine(PositionB_RED, groupBPickUp1_RED))
//                .setLinearHeadingInterpolation(PositionB_RED.getHeading(), groupBPickUp1_RED.getHeading())
//
//                .addPath(new BezierLine(groupBPickUp1_RED, groupBPickUp2_RED))
//                .setLinearHeadingInterpolation(groupBPickUp1_RED.getHeading(), groupBPickUp2_RED.getHeading())
//
//                .addPath(new BezierLine(groupBPickUp2_RED, groupBPickUp3_RED))
//                .setLinearHeadingInterpolation(groupBPickUp2_RED.getHeading(), groupBPickUp3_RED.getHeading())
//
//                .addPath(new BezierLine(groupBPickUp3_RED, shootAtBasket_RED))
//                .setLinearHeadingInterpolation(groupBPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
//                .build();
//
//        ScoreTHIRD = follower.pathBuilder()
//                .addPath(new BezierLine(shootAtBasket_RED, PositionC_RED))
//                .setLinearHeadingInterpolation(shootAtBasket_RED.getHeading(), PositionC_RED.getHeading())
//
//                .addPath(new BezierLine(PositionC_RED, groupCPickUp1_RED))
//                .setLinearHeadingInterpolation(PositionC_RED.getHeading(), groupCPickUp1_RED.getHeading())
//
//                .addPath(new BezierLine(groupCPickUp1_RED, groupCPickUp2_RED))
//                .setLinearHeadingInterpolation(groupCPickUp1_RED.getHeading(), groupCPickUp2_RED.getHeading())
//
//                .addPath(new BezierLine(groupCPickUp2_RED, groupCPickUp3_RED))
//                .setLinearHeadingInterpolation(groupCPickUp2_RED.getHeading(), groupCPickUp3_RED.getHeading())
//
//                .addPath(new BezierLine(groupCPickUp3_RED, shootAtBasket_RED))
//                .setLinearHeadingInterpolation(groupCPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
//                .build();
//
//    }
//
//
//    private int counter = 0;
//    public void autonomousPathUpdate() {
//
//        if (counter == 0) {
//            follower.followPath(ScoreHOME);
//            counter = 1;
//        }
//        if (counter == 1) {
//            if((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
//                //shoot
//                follower.followPath(ScoreFIRST);
//                counter = 2;
//            }
//        }
//        if (counter == 2) {
//            if ((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1)
//                    && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
//                // shoot
//                follower.followPath(ScoreSECOND);
//                counter = 3;
//            }
//        }
//        if (counter == 3) {
//            if((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
//                //shoot
//                follower.followPath(ScoreTHIRD);
//                counter = 4;
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
////        Constants.setConstants(FConstants.class, LConstants.class);
//        opmodeTimer = new Timer();
//
//        opmodeTimer.resetTimer();
//
//        follower = Constants.createFollower(hardwareMap);
//        follower.setStartingPose(StartBottom_RED);
//
//        buildPaths();
//        // TODO: give hardware map the same name when we figure it out
//        OuttakeKT outtake = new OuttakeKT(hardwareMap, telemetry);
////        intake = new Intake(hardwareMap, telemetry);
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
//    // jajajaja
//}
//
//
//
//
//
//
//
//
