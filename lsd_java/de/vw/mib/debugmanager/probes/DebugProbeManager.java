/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.probes;

import de.vw.mib.debugmanager.probes.DebugProbeFactory;

public interface DebugProbeManager {
    default public void registerDebugProbe(DebugProbeFactory debugProbeFactory) {
    }

    default public void unregisterDebugProbe(DebugProbeFactory debugProbeFactory) {
    }
}

