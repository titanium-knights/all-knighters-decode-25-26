package org.firstinspires.ftc.teamcode.teleop

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.utilities.SimpleTankyDrive
import kotlin.math.abs

@TeleOp(name = "OnlyTank")
class OnlyTank : OpMode() {
    private lateinit var tankyDrive: SimpleTankyDrive

    override fun init() {
        tankyDrive = SimpleTankyDrive(hardwareMap)
    }

    override fun loop() {
        val leftX = -gamepad1.left_stick_x.applyDeadzone()
        val leftY = -gamepad1.left_stick_y.applyDeadzone()
        val rightX = -gamepad1.right_stick_x.applyDeadzone()
        val rightY = -gamepad1.right_stick_y.applyDeadzone()

        tankyDrive.move(leftX, leftY, rightX, rightY)

        telemetry.addLine(
            "left:    (%.2f, %.2f) | right:   (%.2f, %.2f)".format(
                leftX, leftY, rightX, rightY
            )
        )
        telemetry.addLine(
            "l (raw): (%.2f, %.2f) | r (raw): (%.2f, %.2f)".format(
                gamepad1.left_stick_x,
                gamepad1.left_stick_y,
                gamepad1.right_stick_x,
                gamepad1.right_stick_y
            )
        )
        telemetry.update()
    }

    private fun Float.applyDeadzone(threshold: Float = 0.1f): Double {
        return if (abs(this) > threshold) this.toDouble()
        else 0.0
    }
}
