/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForFullFactoryReset;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon.MobilityHorizonSetupHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MobilityHorizonSetupStateWork
extends AbstractHsmState
implements TargetForFullFactoryReset,
TargetForResetNavigation {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerMobilityHorizonTarget - MapViewerMobilityHorizonSetupStateWork]");
    private final MobilityHorizonSetupHsmTarget target;
    private FactoryResetParticipantWithCallback navigationResetParticipant;
    private FactoryResetParticipantWithCallback factoryResetParticipant;

    public MobilityHorizonSetupStateWork(MobilityHorizonSetupHsmTarget mobilityHorizonSetupHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mobilityHorizonSetupHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 0x40000A0A: {
                this.handleSetConsideredLocationType(eventGeneric);
                break;
            }
            case 3499003: {
                this.handleEvDestInputHomeLocationChanged();
                break;
            }
            case 3499002: {
                this.mobilityHorizonServiceNotAvailable();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        if (this.navigationResetParticipant == null) {
            this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
        }
        if (this.factoryResetParticipant == null) {
            this.factoryResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForFullFactoryResetAndAddToService(this);
        }
    }

    private void handleEvDestInputHomeLocationChanged() {
        this.logger.trace("handleEvDestInputHomeLocationChanged()");
        this.target.updateHomeLocation();
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        if (this.navigationResetParticipant != null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
            this.navigationResetParticipant = null;
        }
        if (this.factoryResetParticipant != null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().removeFullFactoryResetParticipantFromService(this.factoryResetParticipant);
            this.factoryResetParticipant = null;
        }
    }

    private void handleSetConsideredLocationType(EventGeneric eventGeneric) {
        this.logger.trace("handleSetConsideredLocationTypes()");
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                this.handleSetConsideredLocationTypeCombined();
                break;
            }
            case 1: {
                this.handleSetConsideredLocationTypeOneWay();
                break;
            }
            case 2: {
                this.handleSetConsideredLocationTypeSaveReturn();
                break;
            }
            default: {
                this.logger.makeError().append("locationType '").append(n).append("' is not defined").log();
            }
        }
    }

    private void handleSetConsideredLocationTypeCombined() {
        this.logger.trace("handleSetConsideredLocationTypeCombined()");
        int[] nArray = new int[]{2, 1};
        this.target.datapool.setMobilityHorizonConsideredLocationTypes(nArray);
        this.target.notifierModel.notifyLocationTypeCombined();
        this.target.notifierDSI.setConsideredLocationTypes(nArray);
    }

    private void handleSetConsideredLocationTypeOneWay() {
        this.logger.trace("handleSetConsideredLocationTypeOneWay()");
        int[] nArray = new int[]{1};
        this.target.datapool.setMobilityHorizonConsideredLocationTypes(nArray);
        this.target.notifierModel.notifyLocationTypeOneWay();
        this.target.notifierDSI.setConsideredLocationTypes(nArray);
    }

    private void handleSetConsideredLocationTypeSaveReturn() {
        this.logger.trace("handleSetConsideredLocationTypeSaveReturn()");
        int[] nArray = new int[]{2};
        this.target.datapool.setMobilityHorizonConsideredLocationTypes(nArray);
        this.target.notifierModel.notifyLocationTypeSafeReturn();
        this.target.notifierDSI.setConsideredLocationTypes(nArray);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void mobilityHorizonServiceNotAvailable() {
        this.logger.trace("mobilityHorizonServiceNotAvailable()");
        this.target.notifierModel.notifyMobilityHorizonServiceNotAvailable();
        this.target.transStateInit();
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.handleSetConsideredLocationTypeOneWay();
        this.navigationResetParticipant.notifyResetDone();
    }

    @Override
    public void handleFullFacotryReset() {
        this.handleSetConsideredLocationTypeOneWay();
        this.factoryResetParticipant.notifyResetDone();
    }
}

