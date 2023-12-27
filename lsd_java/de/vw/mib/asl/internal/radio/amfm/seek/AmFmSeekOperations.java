/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.seek;

import de.vw.mib.asl.internal.radio.util.StateMachineOwner;

public final class AmFmSeekOperations {
    private static int seekMode = -1;

    private AmFmSeekOperations() {
    }

    public static void stopSeek(StateMachineOwner stateMachineOwner, boolean bl) {
        if (bl) {
            stateMachineOwner.getAmfmTuner().seekStation(4);
        } else if (6 == seekMode) {
            stateMachineOwner.getAmfmTuner().seekStation(2);
        } else if (5 == seekMode) {
            stateMachineOwner.getAmfmTuner().seekStation(1);
        } else {
            stateMachineOwner.getAmfmTuner().seekStation(4);
        }
    }

    public static void setSeekMode(int n) {
        seekMode = n;
    }

    public static int getSeekMode() {
        return seekMode;
    }
}

