package org.firstinspires.ftc.teamcode.auton;



import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.pedropathing.pathgen.Point;

import org.firstinspires.ftc.teamcode.utilities.CameraAngle;
import org.firstinspires.ftc.teamcode.utilities.Intake;
import org.firstinspires.ftc.teamcode.utilities.Launch;
import org.firstinspires.ftc.teamcode.utilities.Release;
import org.firstinspires.ftc.teamcode.utilities.Sorting;

@Autonomous(name = "RED_Top_ScoreTWO")
public class RED_Top_ScoreTWO {
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private int pathState;
    public Launch launch;
    public Release release;
    public Intake intake;
    public CameraAngle cameraAngle;
    public Sorting sorting;

    private final boolean isRed = true;
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

    private final Pose RED_Top_StartPoint = new Pose(m(24,isRed), 120, mr(135,isRed));
    private final Pose RED_Top_StartPoint_Turn = new Pose(m(24,isRed), 120, mr(270,isRed));
    private final Pose RED_Top_PickingUpFIRST = new Pose(m(24,isRed), 84, mr(270,isRed));
    //dropping off first would be going to RED_Top_StartPoint_Turn + RED_Top_StartPoint
    //then you would RED_Top_StartPoint_Turn again and go to:

    private final Pose RED_Top_PickingUpSECOND = new Pose(m(24,isRed), 60, mr(270,isRed));
    //dropping off second would be going to RED_Top_StartPoint_Turn + RED_Top_StartPoint

    //TODO: Wrong numbers + no park ( do we need a park?)
    private PathChain RED_TOP_ScoreFIRST;

    public void buildPaths(){
        RED_TOP_ScoreFIRST follower.pathBuilder()
                .addPath((new BezierLine(new Point(RED_Top_StartPoint), new Point(RED_Top_StartPoint_Turn))))
                .setLinearHeadingInterpolation(RED_Top_StartPoint.getHeading(),   RED_Top_StartPoint_Turn.getHeading())

    }






}

