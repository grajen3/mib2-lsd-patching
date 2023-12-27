/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.powerstate;

import de.vw.mib.asl.api.system.powerstate.PowerStateListener;
import de.vw.mib.asl.internal.impl.system.powerstate.PropagatingPowerStateService;
import java.util.ArrayList;
import java.util.List;

public class PowerStateServiceImpl
implements PropagatingPowerStateService {
    private final List powerStateListeners = new ArrayList();
    private int currentPowerState = 5;

    @Override
    public int getPowerState() {
        return this.currentPowerState;
    }

    @Override
    public void addListener(PowerStateListener powerStateListener) {
        this.validateListener(powerStateListener);
        this.powerStateListeners.add(powerStateListener);
    }

    @Override
    public void removeListener(PowerStateListener powerStateListener) {
        this.powerStateListeners.remove(powerStateListener);
    }

    @Override
    public void applyAslApiPowerState(int n) {
        int n2 = this.transformAslApiConstant2PowerState(n);
        if (n2 != this.currentPowerState) {
            this.currentPowerState = n2;
            this.notifyPowerStateListeners();
        }
    }

    private void notifyPowerStateListeners() {
        for (int i2 = 0; i2 < this.powerStateListeners.size(); ++i2) {
            PowerStateListener powerStateListener = (PowerStateListener)this.powerStateListeners.get(i2);
            powerStateListener.onNewPowerState(this.currentPowerState);
        }
    }

    private int transformAslApiConstant2PowerState(int n) {
        return n;
    }

    private void validateListener(PowerStateListener powerStateListener) {
        if (powerStateListener == null) {
            throw new IllegalArgumentException("Cannot add power state listener since it is null");
        }
    }
}

