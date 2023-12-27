/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.asl.internal.ASLDatapoolManager;
import de.vw.mib.datapool.ASLDatapool;

class Activator$DatapoolInitializer
implements Runnable {
    private final ASLDatapoolManager manager;
    private final ASLDatapool datapool;

    Activator$DatapoolInitializer(ASLDatapoolManager aSLDatapoolManager, ASLDatapool aSLDatapool) {
        this.manager = aSLDatapoolManager;
        this.datapool = aSLDatapool;
    }

    @Override
    public void run() {
        this.manager.setDatapool(this.datapool);
    }
}

