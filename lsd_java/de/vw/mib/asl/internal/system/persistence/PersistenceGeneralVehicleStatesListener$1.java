/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.internal.system.persistence.PersistenceGeneralVehicleStatesListener;
import de.vw.mib.asl.internal.system.persistence.ProfileSwitchState;

class PersistenceGeneralVehicleStatesListener$1
implements GlobalProfileChangeListener {
    private final /* synthetic */ ProfileSwitchState val$internalProfileSwitchState;
    private final /* synthetic */ PersistenceGeneralVehicleStatesListener this$0;

    PersistenceGeneralVehicleStatesListener$1(PersistenceGeneralVehicleStatesListener persistenceGeneralVehicleStatesListener, ProfileSwitchState profileSwitchState) {
        this.this$0 = persistenceGeneralVehicleStatesListener;
        this.val$internalProfileSwitchState = profileSwitchState;
    }

    @Override
    public void onProfileChangeStarted() {
        this.val$internalProfileSwitchState.setProfileSwitchRunning(true);
    }

    @Override
    public void onProfileChangeCompleted() {
        this.val$internalProfileSwitchState.setProfileSwitchRunning(false);
        if (this.val$internalProfileSwitchState.isProfileSwitchPending()) {
            this.this$0.performProfileSwitch(this.val$internalProfileSwitchState.getPendingProfile());
            this.val$internalProfileSwitchState.clearPendingProfile();
        }
    }
}

