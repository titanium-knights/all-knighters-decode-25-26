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


@Autonomous(name = "redTop")
public class redTop extends IncMode {
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private int pathState;


    private final Pose StartTop_RED = new Pose(72, 144, Math.toRadians(270));
    private final Pose StartBottom_RED = new Pose(72, 0,Math.toRadians(90));
    private final Pose ShootBottom_RED = new Pose(72, 6.5,Math.toRadians(117.64));
    private final Pose ShootTop_RED = new Pose(72, 137.5, Math.toRadians(242.36));
    private final Pose PositionC_RED = new Pose(48, 42,Math.toRadians(180));
    private final Pose groupCPickUp1_RED = new Pose(44, 42,Math.toRadians(180));
    private final Pose groupCPickUp2_RED = new Pose(39,42 ,Math.toRadians(180));
    private final Pose groupCPickUp3_RED = new Pose(34,42 ,Math.toRadians(180));
    // y: 128, x: 35
    private final Pose PositionB_RED = new Pose(48, 66,Math.toRadians(180));
    private final Pose groupBPickUp1_RED = new Pose(44,66,Math.toRadians(180));
    private final Pose groupBPickUp2_RED = new Pose(39,66,Math.toRadians(180));
    private final Pose groupBPickUp3_RED = new Pose(34,66,Math.toRadians(180));
    private final Pose PositionA_RED = new Pose(48, 90,Math.toRadians(180));
    private final Pose groupAPickUp1_RED = new Pose(44,90,Math.toRadians(180));
    private final Pose groupAPickUp2_RED = new Pose(39,90,Math.toRadians(180));
    private final Pose groupAPickUp3_RED = new Pose(34,90,Math.toRadians(180));
    private final Pose shootAtBasket_RED = new Pose(70,74,Math.toRadians(135));
    private PathChain ScoreHOME, ScoreSECOND, ScoreTHIRD, ScoreFIRST_A1, ScoreFIRST_A2, ScoreSECOND_A1, ScoreSECOND_A2, ScoreTHIRD_A1,
    ScoreFIRST_B1, ScoreFIRST_B2, ScoreSECOND_B1, ScoreSECOND_B2, ScoreTHIRD_B1,
    ScoreFIRST_C1, ScoreFIRST_C2, ScoreSECOND_C1, ScoreSECOND_C2, ScoreTHIRD_C1;

    public void buildPaths(){


        ScoreHOME = follower.pathBuilder()
                .addPath(new BezierLine(StartTop_RED, StartTop_RED))
                .setLinearHeadingInterpolation(StartTop_RED.getHeading(), StartTop_RED.getHeading())
                .build();


         ScoreFIRST_A1 = follower.pathBuilder()
                 .addPath(new BezierLine(ShootTop_RED, PositionA_RED))
                 .setLinearHeadingInterpolation(ShootTop_RED.getHeading(), PositionA_RED.getHeading())
                 .build();

         ScoreFIRST_A2 = follower.pathBuilder()
                 .addPath(new BezierLine(PositionA_RED, groupAPickUp1_RED))
                 .setLinearHeadingInterpolation(PositionA_RED.getHeading(), groupAPickUp1_RED.getHeading())
                 .build();

         ScoreSECOND_A1 = follower.pathBuilder()
                 .addPath(new BezierLine(groupAPickUp1_RED, groupAPickUp2_RED))
                 .setLinearHeadingInterpolation(groupAPickUp1_RED.getHeading(), groupAPickUp2_RED.getHeading())
                 .build();

         ScoreSECOND_A2 = follower.pathBuilder()
                 .addPath(new BezierLine(groupAPickUp2_RED, groupAPickUp3_RED))
                 .setLinearHeadingInterpolation(groupAPickUp2_RED.getHeading(), groupAPickUp3_RED.getHeading())
                 .build();

         ScoreTHIRD_A1 = follower.pathBuilder()
                 .addPath(new BezierLine(groupAPickUp3_RED,shootAtBasket_RED))
                 .setLinearHeadingInterpolation(groupAPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
                 .build();

        ScoreFIRST_B1 = follower.pathBuilder()
                .addPath(new BezierLine(shootAtBasket_RED, PositionB_RED))
                .setLinearHeadingInterpolation(shootAtBasket_RED.getHeading(), PositionB_RED.getHeading())
                .build();

        ScoreFIRST_B2 = follower.pathBuilder()
                .addPath(new BezierLine(PositionB_RED, groupBPickUp1_RED))
                .setLinearHeadingInterpolation(PositionB_RED.getHeading(), groupBPickUp1_RED.getHeading())
                .build();

        ScoreSECOND_B1 = follower.pathBuilder()
                .addPath(new BezierLine(groupBPickUp1_RED, groupBPickUp2_RED))
                .setLinearHeadingInterpolation(groupBPickUp1_RED.getHeading(), groupBPickUp2_RED.getHeading())
                .build();

        ScoreSECOND_B2 = follower.pathBuilder()
                .addPath(new BezierLine(groupBPickUp2_RED, groupBPickUp3_RED))
                .setLinearHeadingInterpolation(groupBPickUp2_RED.getHeading(), groupBPickUp3_RED.getHeading())
                .build();

        ScoreTHIRD_B1 = follower.pathBuilder()
                .addPath(new BezierLine(groupBPickUp3_RED, shootAtBasket_RED))
                .setLinearHeadingInterpolation(groupBPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
                .build();

        ScoreTHIRD_C1 = follower.pathBuilder()
                .addPath(new BezierLine(shootAtBasket_RED, PositionC_RED))
                .setLinearHeadingInterpolation(shootAtBasket_RED.getHeading(), PositionC_RED.getHeading())
                .build();

        ScoreFIRST_C2 = follower.pathBuilder()
                .addPath(new BezierLine(PositionC_RED, groupCPickUp1_RED))
                .setLinearHeadingInterpolation(PositionC_RED.getHeading(), groupCPickUp1_RED.getHeading())
                .build();

        ScoreSECOND_C1 = follower.pathBuilder()
                .addPath(new BezierLine(groupCPickUp1_RED, groupCPickUp2_RED))
                .setLinearHeadingInterpolation(groupCPickUp1_RED.getHeading(), groupCPickUp2_RED.getHeading())
                .build();

        ScoreSECOND_C2 = follower.pathBuilder()
                .addPath(new BezierLine(groupCPickUp2_RED, groupCPickUp3_RED))
                .setLinearHeadingInterpolation(groupCPickUp2_RED.getHeading(), groupCPickUp3_RED.getHeading())
                .build();

        ScoreTHIRD_C1 = follower.pathBuilder()
                .addPath(new BezierLine(groupCPickUp3_RED, shootAtBasket_RED))
                .setLinearHeadingInterpolation(groupCPickUp3_RED.getHeading(), shootAtBasket_RED.getHeading())
                .build();

    }


    private int counter = 0;
    public void autonomousPathUpdate() {
        //a
        if (counter == 0) {
            follower.followPath(ScoreHOME);
            counter = 1;
        }
        if (counter == 1) {
            if((Math.abs(follower.getPose().getX() - PositionA_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - PositionA_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreFIRST_A1);
                intakeStop();
                counter = 2;
            }
        }
        if (counter == 2) {
            if ((Math.abs(follower.getPose().getX() - groupAPickUp1_RED.getX()) < 1)
                    && Math.abs(follower.getPose().getY() - groupAPickUp1_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreFIRST_A2);
                intakeStop();
                counter = 3;
            }
        }
        if (counter == 3) {
            if((Math.abs(follower.getPose().getX() - groupAPickUp2_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupAPickUp2_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreSECOND_A1);
                intakeStop();
                counter = 4;
            }
        }
        if (counter == 4) {
            if((Math.abs(follower.getPose().getX() - groupAPickUp3_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupAPickUp3_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreSECOND_A2);
                intakeStop();
                counter = 5;
            }
        }
        if (counter == 5) {
            if((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
               outtakeStart();
                follower.followPath(ScoreTHIRD_A1);
                outtakeStop();
                counter = 6;
            }
        }
        // b
        if (counter == 6) {
            if((Math.abs(follower.getPose().getX() - PositionB_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - PositionB_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreFIRST_B1);
                intakeStop();
                counter = 7;
            }
        }
        if (counter == 7) {
            if((Math.abs(follower.getPose().getX() - groupBPickUp1_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupBPickUp1_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreFIRST_B2);
                intakeStop();
                counter = 8;
            }
        }
        if (counter == 8) {
            if((Math.abs(follower.getPose().getX() - groupBPickUp2_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupBPickUp2_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreSECOND_B1);
                intakeStop();
                counter = 9;
            }
        }
        if (counter == 9) {
            if((Math.abs(follower.getPose().getX() - groupBPickUp3_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupBPickUp3_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreSECOND_B2);
                intakeStop();
                counter = 10;
            }
        }
        if (counter == 10) {
            if((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
                outtakeStart();
                follower.followPath(ScoreTHIRD_B1);
                outtakeStop();
                counter = 11;
            }
        }
        // c
        if (counter == 11) {
            if((Math.abs(follower.getPose().getX() - PositionC_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - PositionC_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreTHIRD_C1);
                intakeStop();
                counter = 12;
            }
        }
        if (counter == 12) {
            if((Math.abs(follower.getPose().getX() - groupCPickUp1_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupCPickUp1_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreFIRST_C2);
                intakeStop();
                counter = 13;
            }
        }
        if (counter == 13) {
            if((Math.abs(follower.getPose().getX() - groupCPickUp2_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupCPickUp2_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreSECOND_C1);
                intakeStop();
                counter = 14;
            }
        }
        if (counter == 14) {
            if((Math.abs(follower.getPose().getX() - groupCPickUp3_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - groupCPickUp3_RED.getY()) < 1) {
                intakeStart();
                follower.followPath(ScoreSECOND_C2);
                intakeStop();
                counter = 15;
            }
        }
        if (counter == 15) {
            if((Math.abs(follower.getPose().getX() - shootAtBasket_RED.getX()) < 1) && Math.abs(follower.getPose().getY() - shootAtBasket_RED.getY()) < 1) {
               outtakeStart();
                follower.followPath(ScoreTHIRD_C1);
                outtakeStop();
                counter = 16;
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
        follower.setStartingPose(StartTop_RED);

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
}
