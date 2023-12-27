/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.api.impl;

import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateAdapter;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.InternalStartupStateListener;

public class InternalStartupStateAdapter
extends StartupStateAdapter
implements InternalStartupStateListener {
    @Override
    public void onLastUserModeReady() {
    }

    @Override
    public void onLastUserModeAvailable() {
    }

    @Override
    public void onBundleLateLoadDone() {
    }
}

