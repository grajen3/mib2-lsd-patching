/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib;

import de.vw.mib.log4mib.LogHeartbeatInformationProvider;
import de.vw.mib.log4mib.LogManagerDiagListener;
import de.vw.mib.log4mib.LogWriter;

public interface LogManager {
    default public void addHeartbeatInformation(String string, String string2) {
    }

    default public void addHeartbeatInformationProvider(String string, LogHeartbeatInformationProvider logHeartbeatInformationProvider) {
    }

    default public void clearMessageCache() {
    }

    default public int getTraceSubClassifierMask(int n) {
    }

    default public void registerLogWriter(LogWriter logWriter) {
    }

    default public void setTraceSubClassifierMask(int n, int n2) {
    }

    default public void updateLogManagerDiagListener(LogManagerDiagListener logManagerDiagListener) {
    }

    default public void unregisterLogWriter() {
    }
}

