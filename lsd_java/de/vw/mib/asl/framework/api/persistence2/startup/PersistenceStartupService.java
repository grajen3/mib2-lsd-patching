/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2.startup;

import de.vw.mib.asl.framework.api.persistence2.startup.PersistenceStartupListener;

public interface PersistenceStartupService {
    public static final int PROFILE_CHANGE_MODE_STARTUP;
    public static final int PROFILE_CHANGE_MODE_NORMAL;

    default public void addListener(PersistenceStartupListener persistenceStartupListener) {
    }

    default public boolean isInitialStartupProfileSet() {
    }

    default public void removeListener(PersistenceStartupListener persistenceStartupListener) {
    }

    default public int getProfileChangeMode() {
    }
}

