/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.internal.impl.system.VehicleStatesListenerAdapter;
import de.vw.mib.asl.internal.system.persistence.PersistenceGeneralVehicleStatesListener$1;
import de.vw.mib.asl.internal.system.persistence.ProfileSwitchState;
import de.vw.mib.log4mib.Logger;

public class PersistenceGeneralVehicleStatesListener
extends VehicleStatesListenerAdapter {
    private final ProfileSwitchState profileSwitchState = new ProfileSwitchState();
    private final Logger logger;
    private final AslPersistenceSyncApi persistenceApi;

    public PersistenceGeneralVehicleStatesListener(AslPersistenceSyncApi aslPersistenceSyncApi, Logger logger) {
        this.persistenceApi = aslPersistenceSyncApi;
        this.logger = logger;
        this.persistenceApi.addGlobalProfileChangeListener(this.createProfileChangeListener());
    }

    @Override
    public void updatePersonalizationStatus(boolean bl, int n, int n2) {
        boolean bl2;
        boolean bl3 = bl2 = n >= 1 && n <= 9;
        if (bl && bl2) {
            byte by = (byte)n;
            this.performProfileSwitch(by);
        }
    }

    void performProfileSwitch(byte by) {
        boolean bl;
        boolean bl2 = bl = by != this.persistenceApi.getActiveProfile();
        if (bl) {
            if (!this.profileSwitchState.isProfileSwitchRunning()) {
                this.persistenceApi.activateProfile(by);
            } else {
                this.profileSwitchState.setPendingProfile(by);
                if (this.logger.isTraceEnabled(2048)) {
                    this.logger.trace(2048).append("Delaying profile switch since a profile switch is already running");
                }
            }
        } else if (this.logger.isTraceEnabled(2048)) {
            this.logger.trace(2048).append("Omitting profile, since the profile is alread active");
        }
    }

    private GlobalProfileChangeListener createProfileChangeListener() {
        ProfileSwitchState profileSwitchState = this.profileSwitchState;
        PersistenceGeneralVehicleStatesListener$1 persistenceGeneralVehicleStatesListener$1 = new PersistenceGeneralVehicleStatesListener$1(this, profileSwitchState);
        return persistenceGeneralVehicleStatesListener$1;
    }

    @Override
    public void updateSTPState(int n, int n2) {
    }

    @Override
    public void updateAutomaticGearShiftTransMode(int n, int n2) {
    }
}

