/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.duallistview;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class DualListViewStateInit
extends AbstractHsmState {
    protected final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DualListViewStateInit]");
    protected final DualListViewHsmTarget target;
    private final int[] ATTRIBUTES_MAPVIEWER = null;
    private static final int[] ASL_OBSERVER = new int[]{771883072, -43830016, -27052800, -490205120, -305655744, 241448192};
    private static final int[] SERVICES = new int[]{-43830016, -27052800};

    public DualListViewStateInit(DualListViewHsmTarget dualListViewHsmTarget, String string, HsmState hsmState) {
        super(dualListViewHsmTarget.getHsm(), string, hsmState);
        this.target = dualListViewHsmTarget;
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
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault() ").append(eventGeneric).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.initDSI();
        this.initASL();
        this.initModel();
        this.target.transStateInactive();
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.initServices();
        this.initObservers();
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        DSIMapViewerControlVW dSIMapViewerControlVW = DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, this.ATTRIBUTES_MAPVIEWER);
        this.target.notifierDSI.setMapViewerControl(dSIMapViewerControlVW);
    }

    private void initModel() {
    }

    private void initObservers() {
        this.logger.trace("initObservers()");
        this.target.addObservers(ASL_OBSERVER);
    }

    private void initServices() {
        this.logger.trace("initServices()");
        ServiceRegister serviceRegister = ServiceManager.eventMain.getServiceRegister();
        serviceRegister.registerServicesWithoutCheck(SERVICES, -1588915200, false);
    }
}

