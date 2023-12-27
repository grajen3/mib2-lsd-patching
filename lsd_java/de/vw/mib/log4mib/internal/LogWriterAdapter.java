/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.internal.PooledBinaryMessage;
import de.vw.mib.log4mib.internal.PooledLogMessage;

abstract class LogWriterAdapter {
    LogWriterAdapter() {
    }

    void writeMessage(PooledLogMessage pooledLogMessage) {
    }

    void writeMessage(PooledBinaryMessage pooledBinaryMessage) {
    }

    void writeOSSystemLog(int n, String string) {
    }
}

