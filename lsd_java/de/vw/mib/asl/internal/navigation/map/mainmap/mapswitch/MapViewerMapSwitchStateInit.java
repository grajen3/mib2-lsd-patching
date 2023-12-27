/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.displaymanagement.ASLDisplaymanagementFactory;
import de.vw.mib.asl.framework.api.displaymanagement.displayable.DisplayableService;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchStateInit$1;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerMapSwitchStateInit
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerMapSwitchStateInit]");
    private MapViewerMapSwitchTargetHSM target;
    private static final int[] ASL_OBSERVERS = new int[]{1405685824, 2026442816, 1575039744, -154660800, -171438016, 1080308992, 822214720, 342111488, 358888704, 1342308416, 1174536256, 1113863424};
    private static final int[] ASL_SERVICES = new int[]{1080308992, 1113863424};
    private static final int[] ATTRIBUTES_MAPVIEWER_CONTROL = new int[0];

    public MapViewerMapSwitchStateInit(MapViewerMapSwitchTargetHSM mapViewerMapSwitchTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerMapSwitchTargetHSM;
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
            case 101001: {
                this.handleNaviTargetGoOn();
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
            this.logger.makeTrace().append("handleDefault(ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleNaviTargetGoOn() {
        this.logger.trace("handleNaviTargetGoOn()");
        this.initDSI();
        this.initASL();
        this.initDisplayManagement();
        if (this.target.datapool.isMapLocatedInKombi()) {
            this.logger.trace("Last mode: Map was visible in Kombi - set switch state so a switch is triggered as soon as MOST is available");
            this.target.datapool.setMapSwitchState(5);
            this.target.notifierModel.notifyMainMapNotShownInABT();
            this.target.datapool.setMapVisibilityForFPKSwitch(false);
        } else {
            this.target.datapool.setMapSwitchState(1);
            this.target.datapool.setMapVisibilityForFPKSwitch(true);
            if (!this.target.datapool.isMapSwitchFunctionAvailableInKombi()) {
                this.target.notifierModel.notifyMapSwitchButtonDisabled();
            }
        }
        this.target.transStateWork();
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.initASLServices();
        this.initASLObservers();
    }

    private void initASLObservers() {
        this.logger.trace("initASLObservers()");
        this.target.addObservers(ASL_OBSERVERS);
    }

    private void initASLServices() {
        this.logger.trace("initASLServices()");
        this.target.registerServices(ASL_SERVICES, false);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        this.target.notifierDSI.setDsiMapViewerControl(DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, ATTRIBUTES_MAPVIEWER_CONTROL));
    }

    private void initDisplayManagement() {
        DisplayableService displayableService = ASLDisplaymanagementFactory.getDisplaymanagementApi().getDisplayableService();
        MapViewerMapSwitchStateInit$1 mapViewerMapSwitchStateInit$1 = new MapViewerMapSwitchStateInit$1(this);
        if (displayableService != null) {
            displayableService.addListener(mapViewerMapSwitchStateInit$1);
        }
    }

    static /* synthetic */ IExtLogger access$000(MapViewerMapSwitchStateInit mapViewerMapSwitchStateInit) {
        return mapViewerMapSwitchStateInit.logger;
    }

    static /* synthetic */ MapViewerMapSwitchTargetHSM access$100(MapViewerMapSwitchStateInit mapViewerMapSwitchStateInit) {
        return mapViewerMapSwitchStateInit.target;
    }
}

