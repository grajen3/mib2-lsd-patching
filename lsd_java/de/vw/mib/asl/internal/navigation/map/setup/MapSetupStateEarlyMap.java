/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIAdbEditFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSINavigationFactoryVW;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapSetupStateEarlyMap
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapSetupStateEarlyMap]");
    private final MapSetupTargetHSM target;
    private static final int[] SERVICES = new int[]{275002624, 291779840, 325334272, 425997568, 795096320, 811873536, -77384448};
    private static final int[] SERVICES_SAVE_LAST_EVENT = new int[]{308557056};
    private static final int[] ASL_OBSERVER = new int[]{872546368, 838991936, 805437504, 855769152, 278741248, 275002624, 291779840, 325334272, -77384448, 409220352, 425997568, 795096320, 811873536, 627324160, -822017984, 1674121280, 140784896, 107230464};
    private static final int[] ATTRIBUTES_MAPVIEWER_MAIN = new int[]{8, 45};

    public MapSetupStateEarlyMap(MapSetupTargetHSM mapSetupTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapSetupTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateEhCategoryVisibility(int[] nArray, int n) {
        this.logger.trace("dsiMapViewerControlUpdateEhCategoryVisibility()");
        this.target.datapool.setVisibleCategoryUids(nArray);
        this.target.notifierModel.notifyPOICategoriesAvailable();
        return null;
    }

    public void dsiMapViewerControlUpdateViewFreeze(boolean bl, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateViewFreeze(viewFreeze=").append(bl).append(")").log();
        }
        if (bl) {
            this.target.datapool.setViewFreezeTrueReceived(true);
            return;
        }
        if (!bl && !this.target.datapool.isViewFreezeTrueReceived()) {
            this.logger.trace("ignoring updateViewFreeze(false), because the configuration is not yet running");
            return;
        }
        EventGeneric eventGeneric = this.target.datapool.getPrepareOnEvent();
        boolean bl2 = this.target.datapool.isRenderingOfFirstMapActive();
        if (eventGeneric != null && !bl && bl2) {
            this.logger.trace("Map was rendered for the first time with persisted settings. Sending prepareOnEvent back to Navi Startup in StateMapSetupWork and inform model.");
            try {
                this.target.datapool.setPrepareOnEvent(null);
                this.target.sendBack(eventGeneric);
                this.target.notifierModel.notifyMapReady();
                ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainDrawn();
                if (ServiceManager.perfService != null) {
                    ServiceManager.perfService.performanceLogMsgByID(5);
                }
            }
            catch (GenericEventException genericEventException) {
                this.logger.makeError().append("Exception in dsiMapViewerControlUpdateViewFreeze(): ").append(genericEventException.getMessage()).attachThrowable(genericEventException).log();
            }
            this.target.datapool.setEarlyMapUpdateViewFreezeFalseReceived(true);
            if (this.target.datapool.isEarlyMapGoOnReceived()) {
                this.initASLObserver();
                this.target.transStateInit();
            } else {
                this.logger.trace("can't leave stateEarlyMap because 'GoOn' was not yet received, waiting for startup");
            }
        }
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
                this.handleNaviTargetPrepareOn(eventGeneric);
                break;
            }
            case 101001: {
                this.handleGoOn();
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
        this.initASLServices();
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleGoOn() {
        this.logger.trace("handleGoOn");
        this.target.datapool.setEarlyMapGoOnReceived(true);
        if (this.target.datapool.isEarlyMapUpdateViewFreezeFalseReceived()) {
            this.initASLObserver();
            this.target.transStateInit();
        } else {
            this.logger.trace("can't leave stateEarlyMap because updateViewFreeze( false ) was not yet received, waiting for southside");
        }
    }

    private void handleNaviTargetPrepareOn(EventGeneric eventGeneric) {
        this.logger.trace("handleNaviTargetPrepareOn()");
        eventGeneric.setBlocked(true);
        this.target.datapool.setPrepareOnEvent(eventGeneric);
        this.initDSI();
        this.target.addDayNightModeListener();
        this.target.initDayNightMode();
        this.target.initMapForFirstRendering();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void initASLObserver() {
        this.logger.trace("initASLObserver()");
        this.target.addObservers(ASL_OBSERVER);
        this.target.initSystemObserver();
    }

    private void initASLServices() {
        this.logger.trace("initASLServices()");
        this.target.registerServices(SERVICES, false);
        this.target.registerServices(SERVICES_SAVE_LAST_EVENT, true);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        this.initDSIMapViewer();
        this.initDSINavigation();
        this.initDSIAdbEdit();
    }

    private void initDSIAdbEdit() {
        this.logger.trace("initDSIAdbEdit()");
        this.target.notifierDSI.setDsiAdbEditService(DSIAdbEditFactoryVW.createAdbEdit(this.target, null));
    }

    private void initDSIMapViewer() {
        this.logger.trace("initDSIMapViewer()");
        this.target.notifierDSI.setDsiMapViewerControlMainMap(DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, ATTRIBUTES_MAPVIEWER_MAIN));
        if (this.target.datapool.isMapInMapAvailable()) {
            this.target.notifierDSI.setDsiMapViewerControlSplitscreenMap(DSIMapViewerControlFactoryVW.createMapViewerSplitscreen(this.target, null));
        }
    }

    private void initDSINavigation() {
        this.logger.trace("initDSINavigation()");
        this.target.notifierDSI.setDsiNavigation(DSINavigationFactoryVW.createNavigation(this.target, null));
    }
}

