//package org.firstinspires.ftc.teamcode.utilities;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//
//public class Cycler {
//    public static final double cyclerPower = 0.9;
//    public final DcMotor cycler;
//
//    public Cycler(HardwareMap hmap) {
//        this.cycler = hmap.dcMotor.get(CONFIG.CYCLER);
//        this.cycler.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//        this.cycler.setDirection(DcMotorSimple.Direction.FORWARD); // TODO: idk the actual direction
//    }
//
//    public void cyclerRun(){
//        cycler.setPower(cyclerPower);
//    }
//
//    public void cyclerStop(){
//        cycler.setPower(0.0);
//    }
//}
