package org.firstinspires.ftc.teamcode.utilities

import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.Telemetry

@Configurable
class OuttakeKT(hmap: HardwareMap, telemetry: Telemetry) {
    var outTake1: DcMotor
    var outTake2: DcMotor


    init {
        this.outTake1 = hmap.dcMotor.get(CONFIG.OUTTAKE1)
        this.outTake2 = hmap.dcMotor.get(CONFIG.OUTTAKE2)
        this.outTake1.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
        this.outTake2.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
        this.outTake1.direction = DcMotorSimple.Direction.REVERSE
        this.outTake2.direction = DcMotorSimple.Direction.FORWARD
        Companion.telemetry = telemetry
    }

    @JvmOverloads
    fun outtakeRun(override: Double = OUTTAKE_POWER) {
        outTake1.power = override
        outTake2.power = override
        telemetry.addLine(" outtake is running")
        telemetry.update()
    }

    fun outtakeStop() {
        outTake1.power = 0.0
        outTake2.power = 0.0
        telemetry.addLine(" outtake is stopped")
        telemetry.update()
    }

    @JvmOverloads
    fun outtakeKYS(override: Double = OUTTAKE_STOPPING_POWER) {
        outTake1.power = override
        outTake2.power = override
        telemetry.addLine("outtake is killing itself (on purpose)")
        telemetry.update()
    }


    companion object {
        lateinit var telemetry: Telemetry
        const val OUTTAKE_POWER: Double = 0.7
        const val OUTTAKE_STOPPING_POWER = -0.7
    }
}
