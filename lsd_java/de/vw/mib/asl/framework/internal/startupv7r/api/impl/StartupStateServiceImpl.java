/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.api.impl;

import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateListener;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.InternalStartupStateListener;
import java.util.ArrayList;
import java.util.List;

public class StartupStateServiceImpl
implements StartupStateService {
    private final List listeners = new ArrayList();
    private int startupState = 0;
    private boolean bundleLateLoadDone;

    @Override
    public int getStartupState() {
        return this.startupState;
    }

    @Override
    public void addListener(StartupStateListener startupStateListener) {
        this.assertListenerValidity(startupStateListener);
        this.listeners.add(startupStateListener);
    }

    @Override
    public void removeListener(StartupStateListener startupStateListener) {
        this.listeners.remove(startupStateListener);
    }

    public void notifyLastUserModeAvailable() {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            Object object = this.listeners.get(i2);
            if (!(object instanceof InternalStartupStateListener)) continue;
            InternalStartupStateListener internalStartupStateListener = (InternalStartupStateListener)object;
            internalStartupStateListener.onLastUserModeAvailable();
        }
    }

    public void notifyLastUserModeReady() {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            Object object = this.listeners.get(i2);
            if (!(object instanceof InternalStartupStateListener)) continue;
            InternalStartupStateListener internalStartupStateListener = (InternalStartupStateListener)object;
            internalStartupStateListener.onLastUserModeReady();
        }
    }

    public void notifyBundleLateLoadDone() {
        this.bundleLateLoadDone = true;
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            Object object = this.listeners.get(i2);
            if (!(object instanceof InternalStartupStateListener)) continue;
            InternalStartupStateListener internalStartupStateListener = (InternalStartupStateListener)object;
            internalStartupStateListener.onBundleLateLoadDone();
        }
    }

    public void updateStartupState(int n) {
        boolean bl;
        boolean bl2 = bl = this.startupState != n;
        if (bl) {
            this.startupState = n;
            this.notifyListeners();
        }
    }

    public boolean isBundleLateLoadDone() {
        return this.bundleLateLoadDone;
    }

    private void assertListenerValidity(StartupStateListener startupStateListener) {
        if (startupStateListener == null) {
            throw new IllegalArgumentException("Cannot add statup state listener since it is null.");
        }
        if (this.listeners.contains(startupStateListener)) {
            throw new IllegalArgumentException("Cannot add startup state listener since it was added before.");
        }
    }

    private void notifyListeners() {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            StartupStateListener startupStateListener = (StartupStateListener)this.listeners.get(i2);
            startupStateListener.onStartupStateChanged(this.startupState);
        }
    }
}

