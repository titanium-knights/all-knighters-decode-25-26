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
    public Sorting sorter;
    public Release releaser;
    public CameraAngle cameraServo;
    public Launch launcher;
    public Intake intakeServo;

    public SubsystemManager(HardwareMap hmap, Telemetry telemetry) {
        // add util class initializations here
        drive = new SimpleMecanumDrive(hmap);
        sorter = new Sorting(hmap, telemetry);
        releaser = new Release(hmap, telemetry);
        cameraServo = new CameraAngle(hmap, telemetry);
        launcher = new Launch(hmap, telemetry);
        intakeServo = new Intake(hmap, telemetry);

    }
}
