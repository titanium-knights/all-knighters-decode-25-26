package org.firstinspires.ftc.teamcode.utilities;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;



/**
 * This class is used to encapsulate all utility classes for subsystems.
 * Any OpMode (teleop or auton) can initialize this class and access any utility class
 * The instance of this object should be passed to any TeleopState to provide access to utility classes
 * This prevents the need to pass references to several utility classes to each TeleopState
 */

public class SubsystemManager {
    public SimpleMecanumDrive drive;
    public Sorting sorting;
    public Release release;
    public CameraAngle cameraAngle;
    public Launch launch;
    public Intake intake;
    public AngleThing angleThing;

    public SubsystemManager(HardwareMap hmap, Telemetry telemetry) {
        // add util class initializations here
        drive = new SimpleMecanumDrive(hmap);
        sorting = new Sorting(hmap, telemetry);
        release = new Release(hmap, telemetry);
        cameraAngle = new CameraAngle(hmap, telemetry);
        launch = new Launch(hmap, telemetry);
        intake = new Intake(hmap, telemetry);
        angleThing = new AngleThing(hmap, telemetry);

    }
}
