package org.firstinspires.ftc.teamcode.utilities

import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.Telemetry

@Configurable
class OuttakeKT(hmap: HardwareMap, telemetry: Telemetry) {
    var outtakeLeft: DcMotor
    var outtakeRight: DcMotor


    init {
        this.outtakeLeft = hmap.dcMotor.get(CONFIG.OUTTAKE_LEFT)
        this.outtakeRight = hmap.dcMotor.get(CONFIG.OUTTAKE_RIGHT)
        this.outtakeLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
        this.outtakeRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
        this.outtakeLeft.direction = CONFIG.OUT_L_DIRECTION
        this.outtakeRight.direction = CONFIG.OUT_R_DIRECTION
        Companion.telemetry = telemetry
    }

    @JvmOverloads
    fun outtakeRun(override: Double = OUTTAKE_POWER) {
        outtakeLeft.power = override
        outtakeRight.power = override
        telemetry.addLine(" outtake is running")
        telemetry.update()
    }

    fun outtakeStop() {
        outtakeLeft.power = 0.0
        outtakeRight.power = 0.0
        telemetry.addLine(" outtake is stopped")
        telemetry.update()
    }

    @JvmOverloads
    fun outtakeKYS(override: Double = OUTTAKE_STOPPING_POWER) {
        outtakeLeft.power = override
        outtakeRight.power = override
        telemetry.addLine("outtake is killing itself (on purpose)")
        telemetry.update()
    }


    companion object {
        lateinit var telemetry: Telemetry
        const val OUTTAKE_POWER: Double = 0.5
        const val OUTTAKE_STOPPING_POWER = -0.5
    }
}
