/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity.component;

import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.proximity.ProximityServiceImpl;
import de.vw.mib.asl.internal.system.proximity.component.AbstractProximityComponent$1;
import de.vw.mib.timer.Timer;

public abstract class AbstractProximityComponent {
    public static long DEFAULT_PROXMITY_TIMEOUT = 0;
    public static int PROXIMITY_COMPONENT_TYPE_USER_INTERACTION = 0;
    public static int PROXIMITY_COMPONENT_TYPE_OTHER = 1;
    private final int componentType;
    private final Timer proximityTimer;
    private final ProximityServiceImpl proximityService;
    private boolean isApproximated;

    public AbstractProximityComponent(SystemServices systemServices, ProximityServiceImpl proximityServiceImpl, int n) {
        this.proximityTimer = systemServices.getTimerManager().createTimer("Proximity Timer", this.getTimeout(), false, this.createTimeoutRunnable(), systemServices.getThreadSwitcher());
        this.proximityTimer.start();
        this.componentType = n;
        this.proximityService = proximityServiceImpl;
        proximityServiceImpl.registerComponent(this);
    }

    public int getComponentType() {
        return this.componentType;
    }

    public boolean getProximityState() {
        return this.isApproximated;
    }

    protected void installProximityValue(boolean bl) {
        if (bl) {
            if (this.proximityTimer.isStarted()) {
                this.proximityTimer.stop();
            }
            if (!this.isApproximated) {
                this.setApproximated(true);
            }
        } else if (this.isApproximated) {
            this.proximityTimer.start();
        }
    }

    protected long getTimeout() {
        return DEFAULT_PROXMITY_TIMEOUT;
    }

    void setApproximated(boolean bl) {
        this.isApproximated = bl;
        this.proximityService.onComponentProximityChanged();
    }

    private Runnable createTimeoutRunnable() {
        return new AbstractProximityComponent$1(this);
    }
}

