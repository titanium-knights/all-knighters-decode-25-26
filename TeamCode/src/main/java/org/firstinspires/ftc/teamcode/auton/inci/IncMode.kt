package org.firstinspires.ftc.teamcode.auton.inci

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.util.ElapsedTime
import org.firstinspires.ftc.teamcode.utilities.SubsystemManager

open class IncMode : OpMode() {
    var subsystemManager: SubsystemManager? = null

    override fun init() {
        subsystemManager = SubsystemManager(hardwareMap, telemetry)
    }

    override fun loop() {}


    /** blocking methods */
    /**
     * this is blocking and uses `@JvmOverloads` to make constructors with defaults
     */
    @JvmOverloads
    fun outtakeForTime(seconds: Double = 2.5) {
        subsystemManager!!.outtake.outtakeRun()
        val timer = ElapsedTime()
        timer.reset()
        while (timer.seconds() < seconds) {
            /*
               Time, Dr. Freeman? Is it really that time again? It seems as if you only just arrived. You've done a great deal in a small time span. You've done so well, in fact, that I've received some interesting offers for your services.

               Ordinarily, I wouldn't contemplate them... but these *are* extraordinary times.

               Rather than offer you the illusion of free choice, I will take the liberty of choosing for you... if and when your time comes round again. I do apologize for what must seem to you an arbitrary imposition, Dr. Freeman. I trust it will all make sense to you in the course of... well... I'm really not at liberty to say. In the meantime... this is where I get off.
            */
        }
        subsystemManager!!.outtake.outtakeStop()
    }


    /** non-blocking methods below */
    fun intakeStart() {
        subsystemManager!!.intake.intakeRun();
    }


    fun intakeStop() {
        subsystemManager!!.intake.intakeStop();
    }

    fun outtakeStart() {
        subsystemManager!!.outtake.outtakeRun();
    }

    fun outtakeStop() {
        subsystemManager!!.outtake.outtakeStop();
    }
}
