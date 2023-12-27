/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib;

import de.vw.mib.collections.ints.IntIntMap;

public interface Settings {
    default public long getLogHeartbeatFrequency() {
    }

    default public IntIntMap getInitialSubClassifierMasks() {
    }

    default public int getLogMessageCacheSize() {
    }

    default public int getLogMessagePoolSize() {
    }

    default public int getLogMessageQueueSize() {
    }

    default public boolean isConsoleLoggingEnabled() {
    }

    default public boolean isTcpSinkEnabled() {
    }
}

