/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib;

import de.vw.mib.log4mib.LogMessage;

public interface LogWriter {
    default public void close() {
    }

    default public void emitOSEvent(int n, String string) {
    }

    default public void flush() {
    }

    default public void write(LogMessage logMessage) {
    }
}

