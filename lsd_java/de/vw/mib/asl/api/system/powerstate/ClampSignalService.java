/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.powerstate;

import de.vw.mib.asl.api.system.powerstate.ClampSignalListener;

public interface ClampSignalService {
    default public void addListener(ClampSignalListener clampSignalListener) {
    }

    default public void removeListener(ClampSignalListener clampSignalListener) {
    }

    default public boolean isCurrentClamp15Activated() {
    }

    default public boolean isCurrentClampSActivated() {
    }
}

