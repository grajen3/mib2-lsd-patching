/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerDatapool;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerState2DCarUp;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerState2DNorthUp;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerState3DCarUp;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerStateInit;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerStateMain;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerStateMobilityHorizon;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerStateOverviewZoom;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerStateRestart;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerStateTwoFingerZoom;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public class MapInMapViewerTargetHsm
extends AbstractResettableAslHsmTarget {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerTargetHsm]");
    protected final MapInMapViewerNotifierDSI notifierDSI;
    protected final MapInMapViewerNotifierModel notifierModel;
    private final MapInMapViewerState2DCarUp state2DCarUp;
    private final MapInMapViewerState2DNorthUp state2DNorthUp;
    private final MapInMapViewerState3DCarUp state3DCarUp;
    private final MapInMapViewerStateInit stateInit;
    private MapInMapViewerStateRestart stateRestart;
    protected final MapInMapViewerStateMain stateMain;
    private final MapInMapViewerStateOverviewZoom stateOverviewZoom;
    private final MapInMapViewerStateMobilityHorizon stateRangeView;
    private final MapInMapViewerStateTwoFingerZoom stateTwoFingerZoom;
    protected MapInMapViewerDatapool datapool = new MapInMapViewerDatapool();
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public MapInMapViewerTargetHsm(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.notifierModel = new MapInMapViewerNotifierModel();
        this.notifierDSI = new MapInMapViewerNotifierDSI();
        this.stateMain = new MapInMapViewerStateMain(this, this.hsm, "stateWork", this.getWorkStateParent());
        this.stateInit = new MapInMapViewerStateInit(this, "stateInit", (HsmState)this.stateMain);
        this.stateRestart = new MapInMapViewerStateRestart(this, "stateRestart", (HsmState)this.stateMain);
        this.state2DCarUp = new MapInMapViewerState2DCarUp(this, "stateMapViewer2DCarUp", (HsmState)this.stateMain);
        this.state2DNorthUp = new MapInMapViewerState2DNorthUp(this, "state2DNorthUp", (HsmState)this.stateMain);
        this.state3DCarUp = new MapInMapViewerState3DCarUp(this, "stateMapViewer3DCarUp", (HsmState)this.stateMain);
        this.stateOverviewZoom = new MapInMapViewerStateOverviewZoom(this, "stateMapInMapOverviewZoom", (HsmState)this.stateMain);
        this.stateRangeView = new MapInMapViewerStateMobilityHorizon(this, "stateRangeView", this.stateMain);
        this.stateTwoFingerZoom = new MapInMapViewerStateTwoFingerZoom(this, "stateTwoFingerZoom", (HsmState)this.stateMain);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    public boolean isOverviewZoomActive() {
        return this.getHsm().isActive(this.stateOverviewZoom);
    }

    protected void transState2DCarUp() {
        this.logger.trace("transState2DCarUp()");
        this.getHsm().trans(this.state2DCarUp);
    }

    protected void transState2DNorthUp() {
        this.logger.trace("transState2DNorthUp()");
        this.getHsm().trans(this.state2DNorthUp);
    }

    protected void transState3DCarUp() {
        this.logger.trace("transState3DCarUp()");
        this.getHsm().trans(this.state3DCarUp);
    }

    protected void transStateInit() {
        this.logger.trace("transStateInit()");
        this.getHsm().trans(this.stateInit);
    }

    protected void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    protected void transStateOverviewZoom() {
        this.logger.trace("transStateOverviewZoom()");
        if (this.isOverviewZoomActive()) {
            this.logger.warn("transStateOverviewZoom() - the state is already active, the call will be ignored, this must be fixed in the model");
            this.notifierDSI.viewSetVisible();
            return;
        }
        this.getHsm().trans(this.stateOverviewZoom);
    }

    protected void transStateRangeView() {
        this.logger.trace("transStateRangeView()");
        this.getHsm().trans(this.stateRangeView);
    }

    protected void transStateTwoFingerZoom() {
        this.logger.trace("transStateTwoFingerZoom()");
        this.getHsm().trans(this.stateTwoFingerZoom);
    }

    protected int zoomLevelDependingOnAutoZoom() {
        int n;
        if (this.datapool.isPerspectiveRangeViewActive()) {
            this.logger.trace("zoomLevelDependingOnAutoZoom() - using last zoomLevel rangeview");
            n = this.datapool.getLastZoomLevelRangeview();
        } else if (this.datapool.isAutoZoomMapInMap()) {
            this.logger.trace("zoomLevelDependingOnAutoZoom() - using autozoom zoomLevel");
            n = this.datapool.getAutoZoomRecommendedZoomLast();
        } else {
            this.logger.trace("zoomLevelDependingOnAutoZoom() - using last user zoomLevel");
            n = this.datapool.getMapInMapZoomLevel();
        }
        n = (int)MapViewerUtils.checkZoomLevelIsInRange(n);
        return n;
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapInMapViewerTargetHsm.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 2)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateRestart);
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace("no reset necessary because restarted DSI(s) is/are not used in target");
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

