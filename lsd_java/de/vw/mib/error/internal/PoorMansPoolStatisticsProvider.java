/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.error.internal;

import de.vw.mib.error.ErrorHandler;
import de.vw.mib.error.HMIDumpInformationProvider;
import de.vw.mib.pool.PoorMansPool;

final class PoorMansPoolStatisticsProvider
implements HMIDumpInformationProvider {
    PoorMansPoolStatisticsProvider(ErrorHandler errorHandler) {
        errorHandler.addHMIDumpInformationProvider(this);
    }

    @Override
    public void clearDumpInformation() {
    }

    @Override
    public String[] getDumpInformation() {
        return PoorMansPool.report();
    }

    @Override
    public String getName() {
        return "Current PoorMansPool statistics";
    }
}

