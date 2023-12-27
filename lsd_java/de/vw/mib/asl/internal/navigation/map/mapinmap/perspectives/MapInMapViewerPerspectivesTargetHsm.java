/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapAPI;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesDatapool;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesState2DCarUp;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesState2DNorthUp;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesState3DCarUp;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesStateInit;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesStateMain;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesStateMobilityHorizon;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesStateOverviewZoom;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapInMapViewerPerspectivesTargetHsm
extends AbstractASLHsmTarget {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerPerspectivesTargetHsm]");
    protected final MapInMapViewerPerspectivesNotifierDSI notifierDSI;
    protected final MapInMapViewerPerspectivesNotifierModel notifierModel;
    private final MapInMapViewerPerspectivesState2DCarUp state2DCarUp;
    private final MapInMapViewerPerspectivesState2DNorthUp state2DNorthUp;
    private final MapInMapViewerPerspectivesState3DCarUp state3DCarUp;
    private final MapInMapViewerPerspectivesStateInit stateInit;
    protected final MapInMapViewerPerspectivesStateMain stateMain;
    private final MapInMapViewerPerspectivesStateOverviewZoom stateOverviewZoom;
    private final MapInMapViewerPerspectivesStateMobilityHorizon stateRangeView;
    protected MapInMapViewerPerspectivesDatapool datapool;
    protected final ASLNavigationMapAPI mapAPI = ASLNavigationMapFactory.getNavigationMapApi();

    public MapInMapViewerPerspectivesTargetHsm(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapInMapViewerPerspectivesDatapool();
        this.notifierModel = new MapInMapViewerPerspectivesNotifierModel();
        this.notifierDSI = new MapInMapViewerPerspectivesNotifierDSI();
        this.stateMain = new MapInMapViewerPerspectivesStateMain(this, this.hsm, "stateWork", this.getWorkStateParent());
        this.stateInit = new MapInMapViewerPerspectivesStateInit(this, "stateInit", (HsmState)this.stateMain);
        this.state2DCarUp = new MapInMapViewerPerspectivesState2DCarUp(this, "stateMapViewer2DCarUp", (HsmState)this.stateMain);
        this.state2DNorthUp = new MapInMapViewerPerspectivesState2DNorthUp(this, "state2DNorthUp", (HsmState)this.stateMain);
        this.state3DCarUp = new MapInMapViewerPerspectivesState3DCarUp(this, "stateMapViewer3DCarUp", (HsmState)this.stateMain);
        this.stateOverviewZoom = new MapInMapViewerPerspectivesStateOverviewZoom(this, "stateMapInMapOverviewZoom", (HsmState)this.stateMain);
        this.stateRangeView = new MapInMapViewerPerspectivesStateMobilityHorizon(this, "stateRangeView", this.stateMain);
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
        return n;
    }
}

