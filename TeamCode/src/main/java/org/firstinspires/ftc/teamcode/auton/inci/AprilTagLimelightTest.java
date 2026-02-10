package org.firstinspires.ftc.teamcode.auton.inci;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="AprilTag Limelight Test", group="Tests")
public class AprilTagLimelightTest extends OpMode {

    private Limelight3A limelight;
    private IMU imu;

    // Stores the last seen tag object
    private LLResultTypes.FiducialResult lastSeenTag = null;

    @Override
    public void init() {
        // Initialize Limelight
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(8); // Make sure pipeline 8 is your AprilTag pipeline

        // Initialize IMU
        imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot hubOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );
        imu.initialize(new IMU.Parameters(hubOrientation));

        telemetry.addLine("Init complete");
        telemetry.update();
    }

    @Override
    public void start() {
        limelight.start(); // Start the Limelight
    }

    @Override
    public void loop() {
        // Update orientation in degrees
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        limelight.updateRobotOrientation(orientation.getYaw(AngleUnit.DEGREES));

        // Get latest Limelight result
        LLResult result = limelight.getLatestResult();

        if (result != null && result.isValid()) {
            LLResultTypes.FiducialResult[] tags = result.getFiducialResults();
            telemetry.addData("Tag Count", tags.length);

            if (tags.length > 0) {
                // Grab the first tag
                lastSeenTag = tags[0];

                // ⚡ Print the entire object to telemetry so we can see which field has the ID
                telemetry.addLine("Tag object dump:");
                telemetry.addData("Tag", lastSeenTag.toString());

                // Optional: you can add more telemetry if known fields exist
                telemetry.addData("Tx", result.getTx());
                telemetry.addData("Ty", result.getTy());
                telemetry.addData("Ta", result.getTa());
            } else {
                telemetry.addLine("No AprilTags detected");
            }

        } else {
            telemetry.addLine("No valid Limelight result");
        }

        telemetry.update();
    }
}
