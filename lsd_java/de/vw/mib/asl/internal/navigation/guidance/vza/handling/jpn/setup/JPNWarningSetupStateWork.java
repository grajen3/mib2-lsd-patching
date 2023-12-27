/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupEvents;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class JPNWarningSetupStateWork
extends AbstractHsmState
implements TargetForResetNavigation {
    private JPNWarningSetupHsmTarget target;
    private FactoryResetParticipantWithCallback navigationResetParticipant = null;

    public JPNWarningSetupStateWork(JPNWarningSetupHsmTarget jPNWarningSetupHsmTarget, String string, HsmState hsmState) {
        super(jPNWarningSetupHsmTarget.getHsm(), string, hsmState);
        this.target = jPNWarningSetupHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState("HSM_ENTRY ");
                this.handleEntry();
                break;
            }
            case 101001: {
                this.target.traceState("NAVI_TARGET_GO_ON");
                break;
            }
            case 4: {
                this.target.traceState("HSM_EXIT");
                JPNWarningSetupEvents.removeObservers(this.target);
                this.handleExit();
                break;
            }
            case 1073742569: {
                this.target.traceState("JPNWarningSetupStateWork.TRAFFIC_SIGN_ANNOUNCEMENT_TYPE_SET");
                boolean bl = 1 == eventGeneric.getInt(0);
                this.target.jpnWarningSignsSetupHandling.notifyWarningSignsEnableDisable(bl);
                break;
            }
            case 1074841956: {
                this.target.traceState("JPNWarningSetupStateWork.SET_SPEED_CAMERA_WARNING_TYPE");
                this.target.jpnWarningSignsSetupHandling.notifySpeedCameraWarningTypeChanged(eventGeneric.getInt(0));
                break;
            }
            case 1074841957: {
                this.target.traceState("JPNWarningSetupStateWork.SET_WARNING_ENABLED_RAILWAY_CROSSING");
                this.target.jpnWarningSignsSetupHandling.notifyRailwayCrossingChanged(eventGeneric.getBoolean(0));
                break;
            }
            case 1074841958: {
                this.target.traceState("JPNWarningSetupStateWork.SET_WARNING_ENABLED_MERGING_TRAFFIC");
                this.target.jpnWarningSignsSetupHandling.notifyMergingTrafficChanged(eventGeneric.getBoolean(0));
                break;
            }
            case 1074841959: {
                this.target.traceState("JPNWarningSetupStateWork.SET_WARNING_ENABLED_REDUCE_LANE");
                this.target.jpnWarningSignsSetupHandling.notifyReduceLaneChanged(eventGeneric.getBoolean(0));
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void notifyMergingTrafficChanged(boolean bl) {
        this.target.jpnWarningSignsSetupHandling.notifyMergingTrafficChanged(bl);
    }

    public void notifyRailwayCrossingChanged(boolean bl) {
        this.target.jpnWarningSignsSetupHandling.notifyRailwayCrossingChanged(bl);
    }

    public void notifyReduceLaneChanged(boolean bl) {
        this.target.jpnWarningSignsSetupHandling.notifyReduceLaneChanged(bl);
    }

    public void notifySpeedCameraWarningTypeChanged(int n) {
        this.target.jpnWarningSignsSetupHandling.notifySpeedCameraWarningTypeChanged(n);
    }

    public void initWarningMenu() {
        this.target.traceState("JPNWarningSetupStateWork.initWarningMenu");
        this.target.jpnWarningSignsSetupHandling.initWarningMenu();
    }

    public void notifyWarningSignsEnableDisable(boolean bl) {
        this.target.jpnWarningSignsSetupHandling.notifyWarningSignsEnableDisable(bl);
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.target.traceState("JPNWarningSetupStateWork.handleNavigationSettingsReset");
        this.ensureReset();
        this.initWarningMenu();
        this.navigationResetParticipant.notifyResetDone();
    }

    private void handleEntry() {
        this.target.traceState("JPNWarningSetupStateWork.handleEntry()");
        if (this.navigationResetParticipant == null) {
            this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
        }
    }

    private void handleExit() {
        this.target.traceState("JPNWarningSetupStateWork.handleExit()");
        if (this.navigationResetParticipant != null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
            this.navigationResetParticipant = null;
        }
    }

    private void ensureReset() {
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setRailwayCrossing(true);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setReduceLane(true);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setMergingTraffic(true);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setSpeedCameraWarningType(1);
    }
}

