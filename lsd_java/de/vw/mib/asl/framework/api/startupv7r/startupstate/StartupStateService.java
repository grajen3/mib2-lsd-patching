/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.startupv7r.startupstate;

import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateListener;

public interface StartupStateService {
    public static final int STARTUP_STATE_PENDING;
    public static final int STARTUP_STATE_STARTING;
    public static final int STARTUP_STATE_DONE;

    default public int getStartupState() {
    }

    default public void addListener(StartupStateListener startupStateListener) {
    }

    default public void removeListener(StartupStateListener startupStateListener) {
    }
}

