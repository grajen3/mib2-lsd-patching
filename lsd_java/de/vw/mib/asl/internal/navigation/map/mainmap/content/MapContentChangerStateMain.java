/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.traffic.TrafficMessageDetails;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapContentChangerStateMain
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapContentChangerStateMain]");
    private MapContentChangerTargetHSM target;

    public MapContentChangerStateMain(MapContentChangerTargetHSM mapContentChangerTargetHSM, String string, HsmState hsmState) {
        super(mapContentChangerTargetHSM.getHsm(), string, hsmState);
        this.target = mapContentChangerTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.handleStart();
                break;
            }
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 1073742382: {
                this.handleSetContent(eventGeneric);
                break;
            }
            case 3499004: {
                this.handleGotoLocation(eventGeneric);
                break;
            }
            case 3499007: {
                this.handleShowTMCMessage(eventGeneric);
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
            this.logger.makeTrace().append("handle(): DEFAULT ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params=").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleGotoLocation(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        Object object = eventGeneric.getObject(1);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleGotoLocation(content=").append(n).append(")").log();
        }
        if (!(object instanceof MapConfiguration)) {
            this.logger.error("Parameter 1 is not an instance of MapConfiguration, the event 'ASLNavigationASLNavigationMapFactory.getNavigationMapApi().EV_MAP_MAIN_CONTENT_GOTO_LOCATION' will not be procedded.");
            return;
        }
        MapConfiguration mapConfiguration = (MapConfiguration)object;
        Integer n2 = new Integer(n);
        this.target.datapool.getQueuedGotoLocations().put(n2, mapConfiguration);
        this.transToSubstate(n2);
    }

    private void handleSetContent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.target.datapool.setMainMapContent(n);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetContent(content=").append(n).append(")").log();
        }
        if (n == 255) {
            this.handleSetContentNoMap();
            return;
        }
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        int n5 = eventGeneric.getInt(4);
        Integer n6 = new Integer(n);
        Rect rect = new Rect(n2, n3, n5, n4);
        this.target.datapool.getStoredZoomAreas().put(n6, rect);
        this.transToSubstate(n6);
    }

    private void handleSetContentNoMap() {
        this.logger.trace("handleSetContentNoMap()");
        this.target.transStateNoMap();
    }

    private void handleShowTMCMessage(EventGeneric eventGeneric) {
        this.logger.trace("handleShowTMCMessage()");
        Object object = eventGeneric.getObject(0);
        if (!(object instanceof TrafficMessageDetails)) {
            this.logger.error("The object in the event is not an TrafficMessageDetails, stopping execution");
            return;
        }
        TrafficMessageDetails trafficMessageDetails = (TrafficMessageDetails)object;
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleShowTMCMessage(messageId= ").append(trafficMessageDetails.messageID).append(")").log();
        }
        MapConfiguration mapConfiguration = new MapConfiguration(trafficMessageDetails);
        Integer n = new Integer(9);
        this.target.datapool.getQueuedGotoLocations().put(n, mapConfiguration);
        if (this.target.datapool.getMapSwitchState() == 0 || this.target.datapool.getMapSwitchState() == 1 && !this.target.datapool.isMapFPKSwitchRunning()) {
            this.logger.makeTrace().append(" switchState=").append(this.target.datapool.getMapSwitchState()).append(", isMapFPKSwitchRunning=").append(this.target.datapool.isMapFPKSwitchRunning()).append(". Show TMC possible.").log();
            this.transToSubstate(n);
        } else {
            this.logger.makeTrace().append("switchState=").append(this.target.datapool.getMapSwitchState()).append(", isMapFPKSwitchRunning=").append(this.target.datapool.isMapFPKSwitchRunning()).append(". Show TMC not possible yet!").log();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void transToSubstate(Integer n) {
        if (this.target.datapool.getMainMapContent() == 255) {
            this.logger.trace("main map content is 'NO_MAP', no transition to any substate...");
            return;
        }
        Rect rect = (Rect)this.target.datapool.getStoredZoomAreas().get(n);
        if (rect == null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("no zoomArea found for content '").append(n).append("', waiting for setContent()").log();
            }
            return;
        }
        this.target.datapool.setZoomArea(rect);
        Point point = MapViewerUtils.calculateHotPointByZoomArea(rect);
        this.target.datapool.setHotPoint(point);
        if (n == 0) {
            this.target.transStateMainMap();
            return;
        }
        if (n == 22 || n == 10) {
            this.target.transStateDetailScreenHome();
            return;
        }
        if (n == 33) {
            this.target.transStateRubberbandMap();
            return;
        }
        if (n == 34) {
            this.target.transStatePNavShowInMap();
            return;
        }
        if (n == 29) {
            this.target.transStateWPMDetail();
            return;
        }
        if (n == 36) {
            this.target.transStateTrafficDualListView();
            return;
        }
        this.transToSubstateIfMapConfigExists(n);
    }

    private void transToSubstateIfMapConfigExists(Integer n) {
        this.logger.trace("transToSubstateIfMapConfigExists()");
        MapConfiguration mapConfiguration = (MapConfiguration)this.target.datapool.getQueuedGotoLocations().get(n);
        if (mapConfiguration == null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("no map config found for content '").append(n).append("', waiting for goToLocation() or showTmcMessage()").log();
            }
            if (n == 12 && !this.target.datapool.isViewVisible()) {
                this.target.notifierDSI.viewSetVisible(true);
            }
            return;
        }
        this.target.datapool.setMapConfiguration(mapConfiguration);
        if (n == 12) {
            this.target.transStateChnCrosshairMapInput();
        } else if (n == 9) {
            this.target.transStateDetailScreenTMC();
        } else if (n == 13) {
            this.target.transStateDetailScreenPOI();
        } else if (n == 28) {
            this.target.transStateDetailScreenGPSInput();
        } else if (n == 27) {
            this.target.transStateDetailScreenChnCrosshairInput();
        } else if (n == 30) {
            this.target.transStateDetailScreenDualList();
        } else if (n == 31) {
            this.target.transStateDetailScreenDualList();
        } else if (n == 35) {
            this.target.transStateDetailScreenDualList();
        } else if (n == 37) {
            this.target.transStateDetailscreen();
        } else if (n == 38) {
            this.target.transStateDetailScreenDualList();
        } else {
            this.target.transStateDetailscreen();
        }
    }
}

