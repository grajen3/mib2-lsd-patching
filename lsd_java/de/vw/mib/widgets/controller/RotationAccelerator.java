/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.internal.ServiceManager;

public final class RotationAccelerator
implements Runnable {
    private static final String TIMER_NAME;
    private static final int MULTIPLIER_DEFAULT;
    private static final int MULTIPLIER_SPEED_UP;
    private static final int MULTIPLIER_MIN_ITEM_COUNT;
    private static final int DELAY_SPEED_UP;
    private static final int TICKS_SPEED_UP;
    private Timer speedupTimer;
    private int multiplier = 1;
    private int lastTicks;
    private boolean lastDirectionForward;

    public int getAcceleratedTicks(int n, int n2, boolean bl) {
        if (n <= 25) {
            return n2;
        }
        if (this.lastDirectionForward == bl) {
            this.lastTicks += n2;
        } else {
            this.lastTicks = 0;
            this.lastDirectionForward = bl;
            this.multiplier = 1;
        }
        if (!this.getSpeedUpTimer().isStarted()) {
            this.getSpeedUpTimer().start();
        }
        return n2 * this.multiplier;
    }

    private Timer getSpeedUpTimer() {
        if (this.speedupTimer == null) {
            this.speedupTimer = ServiceManager.timerManager.createTimer("RotationAccelerator.SpeedupTimer", 0, false, this, ServiceManager.eventDispatcher);
        }
        return this.speedupTimer;
    }

    public boolean isAccelerated() {
        return this.multiplier == 5;
    }

    @Override
    public void run() {
        if (this.lastTicks >= 8) {
            this.multiplier = 5;
            this.getSpeedUpTimer().start();
        } else {
            this.multiplier = 1;
            this.getSpeedUpTimer().stop();
        }
        this.lastTicks = 0;
    }
}

