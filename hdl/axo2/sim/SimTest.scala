package axo2.sim

// SPDX-FileCopyrightText: 2025 Julian Scheffers <julian@scheffers.net>
// SPDX-FileType: SOURCE
// SPDX-License-Identifier: CERN-OHL-P-2.0

import axo2._
import spinal.core._
import spinal.core.sim._
import spinal.lib._

case class DummyDut() extends Component {
    val io = new Bundle {
        val a = in  port Bool()
        val b = in  port Bool()
        val q = out port Bool()
    }
    io.q := io.a ^ io.b
}

object SimTest extends App {
    Config.sim.compile(DummyDut()).doSim(this.getClass.getSimpleName) { dut =>
        // Fork a process to generate the reset and the clock on the dut
        dut.clockDomain.forkStimulus(period = 10)
        
        dut.io.a #= false
        dut.io.b #= false
        dut.clockDomain.waitSampling()
        
        dut.io.a #= true
        dut.io.b #= false
        dut.clockDomain.waitSampling()
        
        dut.io.a #= false
        dut.io.b #= true
        dut.clockDomain.waitSampling()
        
        dut.io.a #= true
        dut.io.b #= true
        dut.clockDomain.waitSampling()
    }
}