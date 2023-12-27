/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rubberband;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSINavigationFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class RubberBandStateInit
extends AbstractHsmState {
    private final IExtLogger logger;
    private final RubberBandHsmTarget target;
    private static final int[] ASL_OBSERVERS = new int[]{771883072, -255324096, -188215232, -221769664, -204992448, -238546880, 476329216, 75956480};
    private final int[] ASL_SERVICES = new int[]{693908736, 744240384, 710685952};
    private static final int[] ATTRIBUTES_NAVIGATION = new int[]{11, 49, 42};
    private static final int[] ATTRIBUTES_MAPVIEWER = new int[]{44};

    public RubberBandStateInit(RubberBandHsmTarget rubberBandHsmTarget, String string, HsmState hsmState) {
        super(rubberBandHsmTarget.getHsm(), string, hsmState);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[RubberBandStateInit]");
        this.target = rubberBandHsmTarget;
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
            case 101003: {
                this.handleNaviTargetPrepareOn();
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

    private void handleNaviTargetPrepareOn() {
        this.logger.trace("handleNaviTargetPrepareOn()");
        this.initDSI();
        this.initASL();
        this.initModel();
        this.target.transStateRubberBandInactive();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.target.registerServices(this.ASL_SERVICES, false);
        this.target.addObservers(ASL_OBSERVERS);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        this.target.notifierDSI.setDsiMapViewerControl(DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, ATTRIBUTES_MAPVIEWER));
        this.target.notifierDSI.setDsiNavigation(DSINavigationFactoryVW.createNavigation(this.target, ATTRIBUTES_NAVIGATION));
    }

    private void initModel() {
        this.logger.trace("initModel()");
        this.target.notifierModel.notifyMapMovedFalse();
    }
}

