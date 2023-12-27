/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.proximity.ProximityListener;
import de.vw.mib.asl.api.system.proximity.ProximityService;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.has.SystemHasBridge;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;

public class ProximityModelUpdater
implements ProximityListener {
    private final ASLPropertyManager propertyManager;
    private final SystemEventDispatcher systemEventDispatcher;
    private final SystemHasBridge systemHasBridge;

    public ProximityModelUpdater(SystemServices systemServices, ProximityService proximityService) {
        this.propertyManager = systemServices.getPropertyManager();
        this.systemEventDispatcher = systemServices.getSystemEventDispatcher();
        this.systemHasBridge = systemServices.getSystemHasBridge();
        this.synchronizeModelToProximityServiceState(proximityService);
    }

    @Override
    public void onProximityChanged(boolean bl) {
        this.propertyManager.valueChangedBoolean(1647, bl);
        int n = bl ? 300 : 301;
        this.systemEventDispatcher.createAndSubmitProximityEvent(bl, n);
        this.systemHasBridge.setPropertyMainDisplayApproximity(bl);
    }

    @Override
    public void onUserInteractionProximityChanged(boolean bl) {
        this.propertyManager.valueChangedBoolean(1496457216, bl);
    }

    private void synchronizeModelToProximityServiceState(ProximityService proximityService) {
        boolean bl;
        boolean bl2 = proximityService.getCurrentProximityState();
        if (bl2) {
            this.onProximityChanged(bl2);
        }
        if (bl = proximityService.getCurrentUserInteractionState()) {
            this.onUserInteractionProximityChanged(bl);
        }
    }
}

