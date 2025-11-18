package org.firstinspires.ftc.teamcode.utilities

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.max
import kotlin.math.abs

class SimpleTankyDrive(hmap: HardwareMap) {
    companion object { // makes them static
        lateinit var fl: DcMotor
        lateinit var bl: DcMotor
        lateinit var fr: DcMotor
        lateinit var br: DcMotor
    }

    init {
        fr = hmap.get<DcMotor>(DcMotor::class.java, CONFIG.FRONT_RIGHT)
        br = hmap.get<DcMotor>(DcMotor::class.java, CONFIG.BACK_RIGHT)
        fl = hmap.get<DcMotor>(DcMotor::class.java, CONFIG.FRONT_LEFT)
        bl = hmap.get<DcMotor>(DcMotor::class.java, CONFIG.BACK_LEFT)

        fr.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        br.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        fl.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        bl.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE

        fr.direction = DcMotorSimple.Direction.FORWARD
        br.direction = DcMotorSimple.Direction.FORWARD
        fl.direction = DcMotorSimple.Direction.REVERSE
        bl.direction = DcMotorSimple.Direction.REVERSE
    }

    fun move(leftX: Double, leftY: Double, rightX: Double, rightY: Double) {
        val leftPower = sqrt(leftX.pow(2) + leftY.pow(2))
        val rightPower = sqrt(rightX.pow(2) + rightY.pow(2))

        var flPower = leftY - leftX
        var blPower = leftY + leftX
        var frPower = rightY - rightX
        var brPower = rightY + rightX

        // Normalize powers to   ensure none exceed 1.0
        val maxPower = max(
            max(abs(flPower), abs(blPower)),
            max(abs(frPower), abs(brPower))
        )

        if (maxPower > 1.0) {
            flPower /= maxPower
            blPower /= maxPower
            frPower /= maxPower
            brPower /= maxPower
        }

        // Set motor powers
        fl.power = flPower
        bl.power = blPower
        fr.power = frPower
        br.power = brPower
    }
}