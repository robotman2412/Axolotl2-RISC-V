
// SPDX-FileCopyrightText: 2025 Julian Scheffers <julian@scheffers.net>
// SPDX-FileType: SOURCE
// SPDX-License-Identifier: CERN-OHL-P-2.0

ThisBuild / version := "1.0"
ThisBuild / scalaVersion := "2.12.18"
ThisBuild / organization := "org.example"

val spinalVersion = "1.10.2"
val spinalCore = "com.github.spinalhdl" %% "spinalhdl-core" % spinalVersion
val spinalLib = "com.github.spinalhdl" %% "spinalhdl-lib" % spinalVersion
val spinalIdslPlugin = compilerPlugin("com.github.spinalhdl" %% "spinalhdl-idsl-plugin" % spinalVersion)

lazy val axo2 = (project in file("."))
    .settings(
        Compile / scalaSource := baseDirectory.value / "hdl",
        libraryDependencies ++= Seq(spinalCore, spinalLib, spinalIdslPlugin)
    )

fork := true
