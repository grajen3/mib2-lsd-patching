/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerStreetViewCtrlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSINavigationFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class MapViewerStreetviewStateInit
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerStreetviewStateInit]");
    private final MapViewerStreetviewTargetHSM target;
    private static final int[] ATTRIBUTES_GOOGLE_STREET_VIEW = new int[]{6, 7, 2, 1, 4, 3};
    private static final int[] ATTRIBUTES_NAVIGATION = new int[]{11, 28};
    private static final int[] ASL_OBSERVERS = new int[]{-1526071232, -1509294016, -1442185152, 1745485888, 684265536, -493076224, 1224867904, 459552000, 576992512, 241448192, 778319104, -1047453440, 1097086208};
    private static final int[] ASL_SERVICES = new int[]{576992512, 1097086208};
    private static final int[] ATTRIBUTES_MAPVIEWER_CONTROL = new int[]{13};

    public MapViewerStreetviewStateInit(MapViewerStreetviewTargetHSM mapViewerStreetviewTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerStreetviewTargetHSM;
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
            case 3499035: {
                this.handleServiceAvailableChangedGoogleStreetView(eventGeneric);
                break;
            }
            case 2200001: {
                this.target.handleDataConnectionAvailable(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handle(): DEFAULT ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleServiceAvailableChangedGoogleStreetView(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleServiceAvailableChangedGoogleStreetView(available=").append(bl).append(")").log();
        }
        this.target.datapool.setStreetviewDSIready(bl);
        if (!bl) {
            return;
        }
        this.initDSI();
        this.target.notifierModel.notifyTwoFingerZoomActive();
        if (this.target.datapool.isStreetviewServiceAvailable()) {
            this.target.notifierModel.notifyStreetViewServiceAvailable();
        }
        this.target.transStateMain();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.initASL();
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.target.registerServices(ASL_SERVICES, false);
        this.target.addObservers(ASL_OBSERVERS);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        this.target.notifierDSI.setDsiMapViewerControl(DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, ATTRIBUTES_MAPVIEWER_CONTROL));
        this.target.notifierDSI.setDsiNavigation(DSINavigationFactoryVW.createNavigation(this.target, ATTRIBUTES_NAVIGATION));
        this.target.notifierDSI.setDsiMapViewerStreetViewCtrl(DSIMapViewerStreetViewCtrlFactoryVW.createMapViewerGoogleCtrl(this.target, ATTRIBUTES_GOOGLE_STREET_VIEW));
        this.target.notifierDSI.streetViewEnabled(true);
        this.target.notifierDSI.streetViewSetScreenViewport(MapViewerStreetviewTargetHSM.SCREEN_VIEW_PORT);
        this.target.notifierDSI.streetViewSetDayView();
    }
}

