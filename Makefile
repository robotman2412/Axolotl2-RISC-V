
# SPDX-FileCopyrightText: 2025 Julian Scheffers <julian@scheffers.net>
# SPDX-FileType: SOURCE
# SPDX-License-Identifier: CERN-OHL-P-2.0

.PHONY: all build vhdl sim wave clean

MAKEFLAGS += --silent

SIM  = $(shell cd hdl/axo2; find sim -name '*.scala' | sed 's|\.scala$$||')
WAVE = $(shell cd hdl/axo2; find sim -name '*.scala' | sed 's|\.scala$$|.wave|')
HDL  = $(shell find hdl -name '*.scala')

.PHONY: $(SIM)

all:
	echo '$(SIM)'
	echo '$(WAVE)'

build:
	sbt compile

$(SIM):
	sbt "runMain axo2.sim.$(@F)"

$(WAVE):
	sbt "runMain axo2.sim.$(shell echo '$(@F)' | sed 's|.wave$$||g')"
	gtkwave "simWorkspace/$(shell echo '$(@F)' | sed 's|.wave$$||g')$$/wave.fst"

clean:
	rm -rf tmp target simWorkspace project gen
