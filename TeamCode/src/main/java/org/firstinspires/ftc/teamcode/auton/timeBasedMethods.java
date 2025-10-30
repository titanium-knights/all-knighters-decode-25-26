//package org.firstinspires.ftc.teamcode.auton;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import org.firstinspires.ftc.teamcode.utilities.SimpleMecanumDrive;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.Servo;
//import org.firstinspires.ftc.teamcode.utilities.SimpleMecanumDrive;
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//
//public class timeBasedMethods {
//    import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//    public abstract class AutonMethods extends LinearOpMode {
//        public SimpleMecanumDrive drivetrain;
//        //TODO: add these v
//        public inTake inTake;
//        public middleTake middleTake;
//        public outTakeL outTakeL;
//        public outTakeR outTakeR;
//        // public Latch latch;
//
//        @Override
//        public void runOpMode() throws InterruptedException {
//
//            telemetry.addData("Status", "Initializing hardware...");
//            telemetry.update();
//
//            // Initialize components and check for null references
//            drivetrain = new SimpleMecanumDrive(hardwareMap);
//            outTakeR = new outTakeR(hardwareMap, telemetry);
//            outTakeL = new outTakeL(hardwareMap, telemetry);
//            middleTake = new middleTake(hardwareMap, telemetry);
//            inTake = new inTake(hardwareMap, telemetry);
//
//            telemetry.addData("Status", "Initialization Complete");
//            telemetry.update();
//            waitForStart();
//        }
//        public final double POWER = 1;
//
//        public void stopDrive() {
//            drivetrain.move(0, 0, 0);
//            telemetry.update();
//            sleep(100);
//        }
//        public void moveForward(double x){
//            double duration = 1080 * x;
//            drivetrain.move(0, -POWER, 0);
//            sleep((int)duration);
//            stopDrive();
//        }
//
//        public void moveBackward(double x){
//            double duration = 1080 * x;
//            drivetrain.move(0, POWER, 0);
//            sleep((int)duration);
//            stopDrive();
//        }
//
//        public void moveRight(double x){
//            double duration = 1500 * x;
//            drivetrain.move(POWER, 0, 0);
//            sleep((int)duration);
//            stopDrive();
//        }
//
//        public void moveLeft(double x){
//            double duration = 1500 * x;
//            drivetrain.move(-POWER, 0, 0);
//            sleep((int)duration);
//            stopDrive();
//        }
//
//        public void rotateCw(double x){
//            double duration = 8000 * x;
//            drivetrain.move(0, 0, -POWER);
//            sleep((int)duration);
//            stopDrive();
//        }
//
//        public void rotateCcw(double x){
//            double duration = 8000 * x;
//            drivetrain.move(0, 0, POWER);
//            sleep((int)duration);
//            stopDrive();
//        }
//
//        // slides rotate
//
//        public void slidesRotateUp() {
//            slides.rotateRight();
//            sleep(800);
//            slides.stopRotator();
////         Runnable slidesRunnable = new Runnable() {
////             @Override
////             public void run() {
////                 sleep(10);
////                 slides.stopRotator();
////             }
////         };
////         Thread newThread = new Thread(slidesRunnable);
////         newThread.start();
//
//        }
//
//        public void slidesRotateDown() {
//            slides.rotateLeft();
//            sleep(500);
//            slides.stopRotator();
//        }
//
//        // claw drop/pick up
//
//        public void clawDrop () {
//            clawrotator.toDrop();
//        }
//
//        public void clawPick() {
//            clawrotator.toPick();
//            sleep(500);
//        }
//
//        public void clawNeutral() {
//            clawrotator.toNeutral();
//            sleep(500);
//        }
//
//        double conversionVariable = 24;
//        public double convert(double num){
//            double x = num/conversionVariable;
//            return x;
//        }
//    }
//
//
//
//
//
//
//}
