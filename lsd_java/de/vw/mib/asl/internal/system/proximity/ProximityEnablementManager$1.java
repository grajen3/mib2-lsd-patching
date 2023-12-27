/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.system.proximity.ProximityEnablementManager;

class ProximityEnablementManager$1
extends AbstractProfileChangeHandler {
    private final /* synthetic */ ProximityEnablementManager this$0;

    ProximityEnablementManager$1(ProximityEnablementManager proximityEnablementManager) {
        this.this$0 = proximityEnablementManager;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadPersistedData();
        this.this$0.updateEnablement();
        this.this$0.updateProximityActivity();
        this.notifyProfileChanged(true);
    }
}

