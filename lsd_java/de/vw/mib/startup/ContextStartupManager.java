/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.startup;

import de.vw.mib.startup.ASLStartupManager;
import de.vw.mib.startup.DatapoolStartupManager;
import de.vw.mib.startup.InstrumentClusterStartupManager;

public interface ContextStartupManager {
    default public void contextReady(int n) {
    }

    default public void registerASLStartupManager(ASLStartupManager aSLStartupManager) {
    }

    default public void registerDatapoolStartupManager(DatapoolStartupManager datapoolStartupManager) {
    }

    default public void registerInstrumentClusterStartupManager(InstrumentClusterStartupManager instrumentClusterStartupManager) {
    }

    default public void startContext(int n) {
    }
}

