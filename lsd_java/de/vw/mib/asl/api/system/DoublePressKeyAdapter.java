/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

import de.vw.mib.asl.api.system.DoublePressKeyAdapter$1;
import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public abstract class DoublePressKeyAdapter
extends KeyAdapter {
    private static final int DOUBLEPRESS_TIMEOUT;
    private final IntIntMap mapKeyId2PressReleaseCount = new IntIntOptHashMap();
    private final Services services;

    public DoublePressKeyAdapter(Services services) {
        Preconditions.checkNotNull(services, "Services must not be null");
        this.services = services;
    }

    public abstract void onSinglePressed(int n) {
    }

    public abstract void onDoublePressed(int n) {
    }

    public abstract void onSingleReleased(int n) {
    }

    @Override
    public final void onPressed(int n) {
        int n2 = this.mapKeyId2PressReleaseCount.get(n);
        this.mapKeyId2PressReleaseCount.put(n, ++n2);
        if (n2 == 1) {
            this.onSinglePressed(n);
            this.startDoublePressTimeoutTimer(n);
        }
    }

    @Override
    public final void onReleased(int n) {
        int n2 = this.mapKeyId2PressReleaseCount.get(n);
        if (n2 != 0) {
            this.mapKeyId2PressReleaseCount.put(n, ++n2);
        }
    }

    void onDoublePressTimeout(int n) {
        int n2 = this.mapKeyId2PressReleaseCount.get(n);
        if (n2 == 2) {
            this.onSingleReleased(n);
        } else if (n2 > 2) {
            this.onDoublePressed(n);
        }
        this.mapKeyId2PressReleaseCount.remove(n);
    }

    private Runnable createDoublePressTimeoutRunnable(int n) {
        return new DoublePressKeyAdapter$1(this, n);
    }

    private void startDoublePressTimeoutTimer(int n) {
        TimerManager timerManager = this.services.getTimerManager();
        ThreadSwitchingTarget threadSwitchingTarget = this.services.getASLThreadSwitch();
        String string = "Double Press Timeout Timer";
        boolean bl = false;
        Runnable runnable = this.createDoublePressTimeoutRunnable(n);
        Timer timer = timerManager.createTimer(string, 0, bl, runnable, threadSwitchingTarget);
        timer.start();
    }
}

