/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.perspectives;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateAlternativeRoute;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateCarUp2D;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateCarUp3D;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateCarUpBirdview;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateCountryOverview;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateDestinationZoom;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateFinalDestinationZoom;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateMain;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateNorthUp2D;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateOverviewZoom;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStatePNav;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateRangeView;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateRouteOverview;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesStateWayPointOverview;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public final class MapViewerPerspectivesTargetHSM
extends AbstractResettableAslHsmTarget {
    protected final MapViewerPerspectivesDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerPerspectivesTargetHSM]");
    protected final MapViewerPerspectivesNotifierDSI notifierDSI;
    protected final MapViewerPerspectivesNotifierModel notifierModel;
    private final AbstractHsmState stateAlternativeRoute;
    private final AbstractHsmState stateCarUp2D;
    private final AbstractHsmState stateCarUp3D;
    private final AbstractHsmState stateCarUpBirdview;
    private final AbstractHsmState stateCountryOverview;
    private final AbstractHsmState stateDestinationZoom;
    private final AbstractHsmState stateFinalDestinationZoom;
    private final AbstractHsmState stateInit;
    private final AbstractHsmState stateMain;
    private final AbstractHsmState stateNorthUp2D;
    private final AbstractHsmState stateOverviewZoom;
    private final AbstractHsmState statePNavView;
    private final AbstractHsmState stateRangeView;
    private final AbstractHsmState stateRouteOverview;
    private final AbstractHsmState stateWayPointOverview;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public MapViewerPerspectivesTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapViewerPerspectivesDatapool();
        this.notifierModel = new MapViewerPerspectivesNotifierModel();
        this.notifierDSI = new MapViewerPerspectivesNotifierDSI();
        this.stateInit = new MapViewerPerspectivesStateInit(this, "stateInit", this.getWorkStateParent());
        this.stateMain = new MapViewerPerspectivesStateMain(this, "stateMain", this.getWorkStateParent());
        this.stateCarUp2D = new MapViewerPerspectivesStateCarUp2D(this, "stateCarUp2D", (HsmState)this.stateMain);
        this.stateCarUpBirdview = new MapViewerPerspectivesStateCarUpBirdview(this, "stateCarUpBirdview", (HsmState)this.stateMain);
        this.stateCarUp3D = new MapViewerPerspectivesStateCarUp3D(this, "stateCarUp3D", (HsmState)this.stateMain);
        this.stateNorthUp2D = new MapViewerPerspectivesStateNorthUp2D(this, "stateNorthUp2D", (HsmState)this.stateMain);
        this.stateAlternativeRoute = new MapViewerPerspectivesStateAlternativeRoute(this, "stateAlternativeRoute", (HsmState)this.stateMain);
        this.stateDestinationZoom = new MapViewerPerspectivesStateDestinationZoom(this, "stateDestinationZoom", (HsmState)this.stateMain);
        this.stateFinalDestinationZoom = new MapViewerPerspectivesStateFinalDestinationZoom(this, "stateFinalDestinationZoom", (HsmState)this.stateMain);
        this.stateOverviewZoom = new MapViewerPerspectivesStateOverviewZoom(this, "stateOverviewZoom", (HsmState)this.stateMain);
        this.stateCountryOverview = new MapViewerPerspectivesStateCountryOverview(this, "stateCCPZoom", (HsmState)this.stateMain);
        this.stateRouteOverview = new MapViewerPerspectivesStateRouteOverview(this, "stateRouteOverview", (HsmState)this.stateMain);
        this.stateRangeView = new MapViewerPerspectivesStateRangeView(this, "stateRangeView", (HsmState)this.stateMain);
        this.statePNavView = new MapViewerPerspectivesStatePNav(this, "statePNavView", (HsmState)this.stateMain);
        this.stateWayPointOverview = new MapViewerPerspectivesStateWayPointOverview(this, "stateWayPointOverview", (HsmState)this.stateMain);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    public void transStateAlternativeRoute() {
        this.logger.trace("transStateAlternativeRoute()");
        this.getHsm().trans(this.stateAlternativeRoute);
    }

    public void transStateCarUp2D() {
        this.logger.trace("transStateCarUp2D()");
        if (this.datapool.isMobilityHorzionVisible()) {
            this.logger.error("Perspective 2D car up will be ignored while mobility horizon is visible, this is a model issue and must be fixed in the model!");
            return;
        }
        this.getHsm().trans(this.stateCarUp2D);
    }

    public void transStateCarUp3D() {
        this.logger.trace("transStateCarUp3D()");
        this.getHsm().trans(this.stateCarUp3D);
    }

    public void transStateCarUpBirdview() {
        this.logger.trace("transStateCarUpBirdview()");
        this.getHsm().trans(this.stateCarUpBirdview);
    }

    public void transStateCountryOverview() {
        this.logger.trace("transStateCountryOverview()");
        this.getHsm().trans(this.stateCountryOverview);
    }

    public void transStateDestinationZoom() {
        this.logger.trace("transStateDestinationZoom()");
        this.getHsm().trans(this.stateDestinationZoom);
    }

    public void transStateFinalDestionationZoom() {
        this.logger.trace("transStateFinalDestionationZoom()");
        this.getHsm().trans(this.stateFinalDestinationZoom);
    }

    public void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    public void transStateNorthUp2D() {
        this.logger.trace("transStateNorthUp2D()");
        this.getHsm().trans(this.stateNorthUp2D);
    }

    public void transStateOverviewZoom() {
        this.logger.trace("transStateOverviewZoom()");
        this.getHsm().trans(this.stateOverviewZoom);
    }

    public void transStatePNavView() {
        this.logger.trace("transStatePNavView()");
        if (this.isStateActive(this.stateRangeView)) {
            this.datapool.setRangeViewBeforePNav(true);
        } else {
            this.datapool.setRangeViewBeforePNav(false);
        }
        this.getHsm().trans(this.statePNavView);
    }

    public void transStateRangeView() {
        this.logger.trace("transStateRangeView()");
        this.getHsm().trans(this.stateRangeView);
    }

    public void transStateRouteOverview() {
        this.logger.trace("transStateRouteOverview()");
        this.getHsm().trans(this.stateRouteOverview);
    }

    public void transStateWayPointOverview() {
        this.logger.trace("transStateWayPointOverview()");
        this.getHsm().trans(this.stateWayPointOverview);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapViewerPerspectivesTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateMain);
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

