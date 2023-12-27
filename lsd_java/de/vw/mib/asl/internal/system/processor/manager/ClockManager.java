/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.manager;

import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.persistence.PersistedBooleanCallback;
import de.vw.mib.asl.internal.system.persistence.PersistedBooleanManager;

public class ClockManager {
    private final PersistedBooleanManager clockState;

    public ClockManager(SystemServices systemServices, int n, int n2, int n3, PersistedBooleanCallback persistedBooleanCallback) {
        this.clockState = new PersistedBooleanManager(systemServices, n, n2, n3, persistedBooleanCallback);
    }

    public boolean isClockOn() {
        return this.clockState.get();
    }
}

