/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.setup;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.setup.HsmTargetSetup;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;

public class StateSetupResetFactorySettings
extends AbstractHsmState {
    private HsmTargetSetup myTarget;
    private boolean isBlockingDeleted;
    private boolean isFlagDestDeleted;
    private boolean isStreetHistoryDeleted;
    private boolean isCityHistoryDeleted;
    private boolean isLastDestMemDeleted;
    private boolean isNavInternalDataSetToFactorySettings;

    StateSetupResetFactorySettings(HsmTargetSetup hsmTargetSetup, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetSetup;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.myTarget.traceState(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.myTarget.traceState(this, "HSM_START");
                this.isBlockingDeleted = false;
                this.isFlagDestDeleted = false;
                this.isStreetHistoryDeleted = false;
                this.isCityHistoryDeleted = false;
                this.isLastDestMemDeleted = false;
                this.isNavInternalDataSetToFactorySettings = false;
                this.resetAllData();
                break;
            }
            case 4: {
                this.myTarget.traceState(this, "HSM_EXIT");
                break;
            }
            case 100104: {
                this.myTarget.traceState(this, "EV_NAVI_SETUP_WAIT_FOR_BLOCKING_DELETED");
                this.isBlockingDeleted = true;
                this.checkResetState();
                break;
            }
            default: {
                hsmState = this.myTarget.getWorkStateParent();
            }
        }
        return hsmState;
    }

    private void resetAllData() {
        this.myTarget.traceState(this, "resetAllData");
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence().clear();
        this.myTarget.deleteMemoryTour();
        this.myTarget.deleteNavInternalData();
        this.myTarget.deleteMemoryBlocking();
        this.myTarget.deleteMemoryFlagDestination();
        this.myTarget.deleteMemoryHomeLocation();
        this.myTarget.deleteMemoryLastCitiesAndStreets();
        this.myTarget.deleteMemoryLastDestinations();
        this.myTarget.deleteShieldHistory();
        this.myTarget.GUIDANCE_OPTIONS.setWasGuidanceActive(false, false);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvAddressBookEntryChanged(this.myTarget, null);
        this.trans(this.myTarget.stateSetupMain);
    }

    private void checkResetState() {
        this.myTarget.traceState(this, "checkResetState");
        if (this.isBlockingDeleted && this.isFlagDestDeleted && this.isCityHistoryDeleted && this.isLastDestMemDeleted && this.isStreetHistoryDeleted && this.isNavInternalDataSetToFactorySettings) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(758, true);
            this.trans(this.myTarget.stateSetupMain);
        } else {
            this.myTarget.traceState(this, "Reset not finished yet.");
        }
    }

    public void dsiNavigationUpdateDmFlagDestination(NavLocation navLocation, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateDmFlagDestination");
        this.isFlagDestDeleted = true;
    }

    public void dsiNavigationLiLastCityAndStreetHistoryResult(long l) {
        this.myTarget.traceState(this, "dsiNavigationLiLastCityAndStreetHistoryResult");
        if (this.isCityHistoryDeleted) {
            this.isStreetHistoryDeleted = true;
        } else {
            this.isCityHistoryDeleted = true;
        }
    }

    public void dsiNavigationDmResult(long l, long l2) {
        this.myTarget.traceState(this, "dsiNavigationDmResult");
        this.isLastDestMemDeleted = true;
    }

    public void dsiNavigationSetNavInternalDataToFactorySettingsResult(int n) {
        this.isNavInternalDataSetToFactorySettings = true;
    }
}

