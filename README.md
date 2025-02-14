# Axo2: A size-optimized RISC-V CPU
This project is the beginning of my second generation RISC-V CPUs and a redefinition of the naming scheme. Axo refers to a size-optimized CPU and Boa refers to a balance between size and performance from now on.

## Rationale
Axo2 aims to be size-optimized; it is intended to be the kind of CPU you see on low-cost mass production microcontrollers. I also make it now because I've taken on (as usual) too ambitious a project in Nebula RISC-V; making the jump from multicycle to pipelined to out-of-order is simply too fase.

Axo2, unlike its predecessor, will be a multicycle CPU; it uses multiple clock cycles to run its instructions. The primary reasoning is that this allows it to be smaller and the secondary is that I want to make a multicycle RISC-V CPU.

## Scope
RV32E or RV32I and the M, A and C extensions from [the RISC-V instruction set manual volume I](https://drive.google.com/file/d/1uviu1nH-tScFfgrovvFCrj7Omv8tFtkp/view?usp=drive_link), each configurable at elaboration time.

The machine-level ISA including NAPOT and NA2 PMP, U-mode support from [the RISC-V instruction set manual volume II](https://drive.google.com/file/d/17GeetSnT5wW3xNuAHI95-SI1gPGd5sJ_/view?usp=drive_link), PMP support and granularity and U-mode support configurable at elaboration time.

# License
This work ("Axolotl2 RISC-V" or "Axo2 RISC-V") is licensed under [CERN-OHL-P](https://cern-ohl.web.cern.ch/) v2.

If you create an FPGA bitstream, a compiled simulation, a tapeout or other compiled design with a Axo2-RISC-V core, the `marchid` CSR is all the necessary attribution. For this, the value of `marchid` must not be changed and it must be readable by software running in M-mode. It is recommended that any third-party releases of a modified Axo2-RISC-V CPU set the highest bit of `mimpid` to 1 to distinguish from official releases.
