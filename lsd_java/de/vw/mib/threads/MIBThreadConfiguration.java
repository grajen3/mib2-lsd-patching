/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads;

import de.vw.mib.threads.MIBThreadDescription;

public interface MIBThreadConfiguration {
    default public MIBThreadDescription[] getMIBThreadDescriptions() {
    }

    default public long getWatchdogPollTime() {
    }

    default public int getWatchdogPriority() {
    }
}

