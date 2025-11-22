package org.firstinspires.ftc.teamcode.utilities

import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.Telemetry

@Configurable
class OuttakeKT(hmap: HardwareMap, telemetry: Telemetry) {
    var outTakeL: DcMotor
    var outTakeR: DcMotor


    init {
        this.outTakeL = hmap.dcMotor.get(CONFIG.OUTTAKE_L)
        this.outTakeR = hmap.dcMotor.get(CONFIG.OUTTAKE_R)
        this.outTakeL.direction = DcMotorSimple.Direction.FORWARD
        this.outTakeR.direction = DcMotorSimple.Direction.REVERSE
        Companion.telemetry = telemetry
    }

    @JvmOverloads
    fun outtakeRun(override: Double = OUTTAKE_POWER) {
        outTakeL.power = override
        outTakeR.power = override
        telemetry.addLine(" outtake is running")
        telemetry.update()
    }

    fun outtakeStop() {
        outTakeL.power = 0.0
        outTakeR.power = 0.0
        telemetry.addLine(" outtake is stopped")
        telemetry.update()
    }


    companion object {
        lateinit var telemetry: Telemetry
        const val OUTTAKE_POWER: Double = 0.7
    }
}
