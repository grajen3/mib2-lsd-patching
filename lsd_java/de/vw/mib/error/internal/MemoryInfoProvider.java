/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.error.internal;

import de.vw.mib.error.ErrorHandler;
import de.vw.mib.error.HMIDumpInformationProvider;
import de.vw.mib.log4mib.LogHeartbeatInformationProvider;
import de.vw.mib.log4mib.LogManager;

final class MemoryInfoProvider
implements LogHeartbeatInformationProvider,
HMIDumpInformationProvider {
    private static final int HEARTBEAT_COUNT;
    private int counter;

    public MemoryInfoProvider(LogManager logManager, ErrorHandler errorHandler) {
        logManager.addHeartbeatInformationProvider("free.memory", this);
        errorHandler.addHMIDumpInformationProvider(this);
    }

    @Override
    public void clearDumpInformation() {
    }

    @Override
    public String[] getDumpInformation() {
        return new String[]{""};
    }

    @Override
    public String getName() {
        return new StringBuffer().append("Memory - free memory: ").append(this.getFreeMemory()).append(" / total memory: ").append(this.getTotalMemory()).toString();
    }

    @Override
    public String getInformation(String string) {
        if ("free.memory".equals(string)) {
            if (this.counter == 5) {
                this.counter = 0;
                return new StringBuffer().append("").append(this.getFreeMemory()).toString();
            }
            ++this.counter;
            return null;
        }
        return null;
    }

    private long getFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    private long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }
}

