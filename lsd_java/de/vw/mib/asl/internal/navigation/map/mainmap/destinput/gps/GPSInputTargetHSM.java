/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputDataPool;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputIncrementDecrementor;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputStateMain;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputStateMoveMapToNewCoordinates;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputStateSetClickInMapDragged;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputStateSetClickInMapSelected;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;

public class GPSInputTargetHSM
extends AbstractResettableAslHsmTarget {
    public static final int[] ASL_OBSERVERS = new int[]{-16187328, -150405056, -133627840, -116850624, -100073408, 503971904, -83296192, -66518976, -49741760, -603914176, -788463552, 1308753984};
    public static final int[] ATTRIBUTES_MAPVIEWER = new int[]{8, 13, 11};
    protected final GPSInputDataPool datapool;
    protected final GPSInputIncrementDecrementor incrementDecrementor;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GPSInputTargetHSM] ");
    protected final GPSInputNotifierDSI notifierDSI;
    protected final GPSInputNotifierModel notifierModel;
    private final GPSInputStateInit stateInit;
    private final GPSInputStateMain stateMain;
    private final GPSInputStateMoveMapToNewCoordinates stateMoveMapToNewCoordinates;
    private final GPSInputStateSetClickInMapDragged stateSetClickInMapDragged;
    private final GPSInputStateSetClickInMapSelected stateSetClickInMapSelected;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public GPSInputTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = GPSInputDataPool.getInstance();
        this.notifierModel = new GPSInputNotifierModel(this);
        this.notifierDSI = new GPSInputNotifierDSI(this);
        this.incrementDecrementor = new GPSInputIncrementDecrementor(this.notifierModel);
        this.stateMain = new GPSInputStateMain(this, this.hsm, "stateMain", this.getWorkStateParent());
        this.stateInit = new GPSInputStateInit(this, this.hsm, "stateInit", this.stateMain);
        this.stateMoveMapToNewCoordinates = new GPSInputStateMoveMapToNewCoordinates(this, this.hsm, "stateMoveMapToNewCoordinates", this.stateMain);
        this.stateSetClickInMapDragged = new GPSInputStateSetClickInMapDragged(this, this.hsm, "stateSetClickInMapDragged", this.stateMain);
        this.stateSetClickInMapSelected = new GPSInputStateSetClickInMapSelected(this, this.hsm, "stateSetClickInMapSelected", this.stateMain);
    }

    @Override
    protected HsmState getDefaultState() {
        this.logger.trace("getDefaultState()");
        return this.stateMain;
    }

    protected void initTarget() {
        this.logger.trace("initTarget()");
        this.registerService(10138);
        this.notifierDSI.registerDsiServicesHSM();
        this.addObservers(ASL_OBSERVERS);
    }

    public void sendEvMapMainContentGotoLocation(int n, MapConfiguration mapConfiguration) {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(n, mapConfiguration);
    }

    public void transStateInit() {
        this.logger.trace("transStateInit()");
        this.getHsm().trans(this.stateInit);
    }

    public void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    public void transStateMoveMapToNewCoordinates() {
        this.logger.trace("transStateMoveMapToNewCoordinates()");
        this.getHsm().trans(this.stateMoveMapToNewCoordinates);
    }

    public void transStateSetClickInMapClicked() {
        this.logger.trace("transStateSetClickInMapSelected()");
        this.getHsm().trans(this.stateSetClickInMapSelected);
    }

    public void transStateSetClickInMapDragged() {
        this.logger.trace("transStateSetClickInMapDragged()");
        this.getHsm().trans(this.stateSetClickInMapDragged);
    }

    public void updateLocationCurrentAndSendEvent(ILocationWrapper iLocationWrapper) {
        this.logger.trace("updateLocationCurrentAndSendEvent()");
        this.datapool.setLocationCurrent(iLocationWrapper);
        MapConfiguration mapConfiguration = new MapConfiguration(iLocationWrapper.getLocation(), 29, 0);
        this.sendEvMapMainContentGotoLocation(28, mapConfiguration);
    }

    public void updateLocationCurrentByPosInfo(PosInfo[] posInfoArray) {
        this.logger.trace("updateLocationCurrent()");
        NavLocation navLocation = null;
        for (int i2 = 0; i2 < posInfoArray.length; ++i2) {
            NavLocation navLocation2 = posInfoArray[i2].getTLocation();
            if (navLocation2 == null) continue;
            navLocation = navLocation2;
            break;
        }
        if (navLocation == null) {
            this.logger.error("updateLocationCurrent() - no valid nav location found in PosInfo-Array");
            return;
        }
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        if (iLocationWrapper.getLatitude() == 0 && iLocationWrapper.getLongitude() == 0) {
            this.logger.warn("Latitude and Longitude are both 0, the Location won't be updated, the last Location will be used");
        } else {
            this.updateLocationCurrentAndSendEvent(iLocationWrapper);
        }
    }

    public void updateWindowValues(int n, int n2, int n3, int n4) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateWindowValues(windowX=").append(n).append(", windowY=").append(n2).append(", windowHeight=").append(n4).append(", windowWidth=").append(n3).append(")").log();
        }
        Rect rect = new Rect(n, n2, n3, n4);
        Point point = MapViewerUtils.calculateHotPointByZoomArea(rect);
        this.datapool.setZoomArea(rect);
        this.datapool.setHotPoint(point);
    }

    public void updateXandY(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(1);
        int n2 = eventGeneric.getInt(2);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateXandY(").append("x=").append(n).append(", y=").append(n2).append(")").log();
        }
        this.datapool.setSelectedX(n);
        this.datapool.setSelectedY(n2);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = GPSInputTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
            this.trace("resetting values after DSI restart");
            this.resetHsmToState(this.stateMain);
        } else {
            this.trace("no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

