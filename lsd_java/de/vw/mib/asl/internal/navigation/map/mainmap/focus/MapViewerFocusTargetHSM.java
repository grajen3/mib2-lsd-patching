/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.focus;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.focus.MapViewerFocusDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.focus.MapViewerFocusNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.focus.MapViewerFocusNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mainmap.focus.MapViewerFocusStateCCPZoom;
import de.vw.mib.asl.internal.navigation.map.mainmap.focus.MapViewerFocusStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.focus.MapViewerFocusStateMain;
import de.vw.mib.asl.internal.navigation.map.mainmap.focus.MapViewerFocusStateSurroundingZoom;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public final class MapViewerFocusTargetHSM
extends AbstractResettableAslHsmTarget {
    protected final MapViewerFocusDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerFocusTargetHSM]");
    protected final MapViewerFocusNotifierDSI notifierDSI;
    protected final MapViewerFocusNotifierModel notifierModel;
    private final AbstractHsmState stateCCPZoom;
    private final AbstractHsmState stateInit;
    private final AbstractHsmState stateMain;
    private final AbstractHsmState stateSurroundingZoom;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public MapViewerFocusTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapViewerFocusDatapool();
        this.notifierModel = new MapViewerFocusNotifierModel();
        this.notifierDSI = new MapViewerFocusNotifierDSI();
        this.stateInit = new MapViewerFocusStateInit(this, this.hsm, "stateInit", this.getWorkStateParent());
        this.stateMain = new MapViewerFocusStateMain(this, this.hsm, "stateMain", this.getWorkStateParent());
        this.stateCCPZoom = new MapViewerFocusStateCCPZoom(this, this.hsm, "stateCCPZoom", this.stateMain);
        this.stateSurroundingZoom = new MapViewerFocusStateSurroundingZoom(this, this.hsm, "stateSurroundingZoom", this.stateMain);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    public void transStateCCPZoom() {
        this.logger.trace("transStateCCPZoom()");
        this.getHsm().trans(this.stateCCPZoom);
    }

    public void transStateInit() {
        this.logger.trace("transStateInit()");
        this.getHsm().trans(this.stateInit);
    }

    public void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    public void transStateSurroundingZoom() {
        this.logger.trace("transStateSurroundingZoom()");
        this.getHsm().trans(this.stateSurroundingZoom);
    }

    public void zoomByAutozoom() {
        this.logger.trace("zoomByAutozoom()");
        int n = this.datapool.getAutoZoomRecommendedZoomLast();
        this.datapool.setMainMapZoomLevel(n);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainZoomLevelChanged(n);
    }

    public void zoomByManualPersistedZoomLevel() {
        this.logger.trace("zoomByManualZoomLevel()");
        int n = this.datapool.getMainMapZoomLevel();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainZoomLevelChanged(n);
    }

    public void zoomByManualOverviewZoomLevel() {
        this.logger.trace("zoomByManualZoomLevel()");
        int n = this.datapool.getOverviewMapZoomLevel();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainZoomLevelChanged(n);
    }

    public boolean isPerspectiveOverviewType() {
        return this.datapool.isPerspectiveCountryOverview() || this.datapool.isPerspectiveDestinationZoom() || this.datapool.isPerspectiveFinalDestinationZoom() || this.datapool.isPerspectiveMobilityHorizon() || this.datapool.isPerspectiveOverviewZoom();
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapViewerFocusTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
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

