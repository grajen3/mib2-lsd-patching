/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.api.impl;

import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateListener;

public interface InternalStartupStateListener
extends StartupStateListener {
    default public void onLastUserModeReady() {
    }

    default public void onLastUserModeAvailable() {
    }

    default public void onBundleLateLoadDone() {
    }
}

