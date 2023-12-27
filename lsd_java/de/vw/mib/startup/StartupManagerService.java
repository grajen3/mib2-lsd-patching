/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.startup;

import de.vw.mib.startup.StartupManagerServiceListener;

public interface StartupManagerService {
    default public void addStartupManagerServiceListener(StartupManagerServiceListener startupManagerServiceListener) {
    }

    default public boolean isDatapoolUpdatesEnabled() {
    }

    default public void removeStartupManagerServiceListener(StartupManagerServiceListener startupManagerServiceListener) {
    }
}

