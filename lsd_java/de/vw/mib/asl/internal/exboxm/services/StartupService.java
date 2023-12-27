/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.services;

import de.vw.mib.asl.internal.exboxm.services.StartupListener;

public interface StartupService {
    default public void addStartupListener(StartupListener startupListener) {
    }

    default public boolean isPowerOnEventSent() {
    }
}

