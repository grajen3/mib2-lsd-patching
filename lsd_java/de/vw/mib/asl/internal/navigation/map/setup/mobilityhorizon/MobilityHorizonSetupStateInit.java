/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMobilityHorizonVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMobilityHorizonVWFactory;
import de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon.MobilityHorizonSetupHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MobilityHorizonSetupStateInit
extends AbstractHsmState {
    private static final int[] ASL_OBSERVER = new int[]{0xA0A0040, -110938880, -94161664, -77384448};
    private static final int[] ATTRIBUTES_MOBILITY_HORIZON = new int[]{2, 3, 1};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerMobilityHorizonSetupHsmTarget - MapViewerMobilityHorizonSetupStateInit]");
    private final MobilityHorizonSetupHsmTarget target;

    public MobilityHorizonSetupStateInit(MobilityHorizonSetupHsmTarget mobilityHorizonSetupHsmTarget, Hsm hsm, String string, HsmState hsmState) {
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
            case 3499001: {
                this.mobilityHorizonServiceAvailable();
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
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.handleStartInitModel();
        this.handleStartInitObservers();
        this.handleStartInitDSIServices();
    }

    private void handleStartInitDSIServices() {
        this.logger.trace("handleStartInitDSIServices()");
        DSIMobilityHorizonVW dSIMobilityHorizonVW = DSIMobilityHorizonVWFactory.createMobilityHorizonMainMap(this.target, ATTRIBUTES_MOBILITY_HORIZON);
        this.target.notifierDSI.setMobilityHorizon(dSIMobilityHorizonVW);
    }

    private void handleStartInitModel() {
        this.logger.trace("handleStartInitModel()");
        this.target.notifierModel.notifyMobilityHorizonServiceNotAvailable();
    }

    private void handleStartInitObservers() {
        this.logger.trace("handleStartInitObservers()");
        this.target.addObservers(ASL_OBSERVER);
    }

    private void initDriveTrainMode() {
        this.logger.trace("initDriveTrainMode()");
        if (this.target.datapool.isBEV()) {
            this.initDriveTrainModeBEV();
        } else if (this.target.datapool.isPHEV()) {
            this.initDriveTrainModePHEV();
        }
    }

    private void initDriveTrainModeBEV() {
        this.logger.trace("initDriveTrainModeBEV()");
        this.target.notifierDSI.setDriveTrainMode(0);
    }

    private void initDriveTrainModePHEV() {
        this.logger.trace("initDriveTrainModePHEV()");
        int n = this.target.datapool.getPrimaryEngineType();
        int n2 = this.target.datapool.getSecondaryEngineType();
        if (n == 3) {
            this.target.notifierDSI.setDriveTrainMode(0);
        } else if (n2 == 3) {
            this.target.notifierDSI.setDriveTrainMode(1);
        } else {
            this.logger.error("No electric engine type found, driveTrainMode will be set to PRIMARY");
            this.target.notifierDSI.setDriveTrainMode(0);
        }
    }

    private void initSetup() {
        this.logger.trace("initSetup()");
        this.initSetupConsideredLocationTypes();
        this.initSetupHomeLocation();
    }

    private void initSetupConsideredLocationTypes() {
        this.logger.trace("initSetupConsideredLocationTypes()");
        int[] nArray = this.target.datapool.getMobilityHorizonConsideredLocationTypes();
        if (nArray.length == 1) {
            int n = nArray[0];
            if (n == 1) {
                this.target.notifierDSI.setConsideredLocationTypes(nArray);
                this.target.notifierModel.notifyLocationTypeOneWay();
            } else if (n == 2) {
                this.target.notifierDSI.setConsideredLocationTypes(nArray);
                this.target.notifierModel.notifyLocationTypeSafeReturn();
            } else {
                this.logger.makeError().append("Unsupported location type '").append(nArray[0]).append("', using default 'oneway'").log();
                int[] nArray2 = new int[]{1};
                this.target.datapool.setMobilityHorizonConsideredLocationTypes(nArray2);
                this.target.notifierDSI.setConsideredLocationTypes(nArray2);
                this.target.notifierModel.notifyLocationTypeOneWay();
            }
        } else if (nArray.length > 1) {
            this.target.notifierDSI.setConsideredLocationTypes(nArray);
            this.target.notifierModel.notifyLocationTypeCombined();
        }
    }

    private void initSetupHomeLocation() {
        this.logger.trace("initSetupHomeLocation()");
        this.target.updateHomeLocation();
    }

    private void mobilityHorizonServiceAvailable() {
        this.logger.trace("initTarget()");
        this.initDriveTrainMode();
        this.initSetup();
        this.target.notifierModel.notifyMobilityHorizonServiceAvailable();
        this.target.transStateWork();
    }
}

