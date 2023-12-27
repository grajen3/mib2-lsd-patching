/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesDataPool;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesStateMain;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesStateOneFingerClickInMap;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesStateOneFingerClickInMapNew;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesStateOneFingerDrag;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesStateTwoFingerZoom;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public final class MapViewerTouchgesturesTargetHSM
extends AbstractResettableAslHsmTarget {
    protected final MapViewerTouchgesturesDataPool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerTouchgesturesTargetHSM]");
    protected final MapViewerTouchgesturesNotifierDSI notifierDSI;
    protected final MapViewerTouchgesturesNotifierModel notifierModel = new MapViewerTouchgesturesNotifierModel();
    private final MapViewerTouchgesturesStateInit stateInit;
    private final MapViewerTouchgesturesStateMain stateMain;
    private final MapViewerTouchgesturesStateOneFingerClickInMap stateOneFingerClickInMap;
    private final MapViewerTouchgesturesStateOneFingerClickInMapNew stateOneFingerClickInMapNew;
    private final MapViewerTouchgesturesStateOneFingerDrag stateOneFingerDrag;
    private final MapViewerTouchgesturesStateTwoFingerZoom stateTwoFingerZoom;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public MapViewerTouchgesturesTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapViewerTouchgesturesDataPool();
        this.notifierDSI = new MapViewerTouchgesturesNotifierDSI();
        this.stateInit = new MapViewerTouchgesturesStateInit(this, this.hsm, "stateInit", this.getWorkStateParent());
        this.stateMain = new MapViewerTouchgesturesStateMain(this, this.hsm, "stateMain", this.getWorkStateParent());
        this.stateOneFingerClickInMap = new MapViewerTouchgesturesStateOneFingerClickInMap(this, this.hsm, "stateOneFingerClickInMap", this.stateMain);
        this.stateOneFingerClickInMapNew = new MapViewerTouchgesturesStateOneFingerClickInMapNew(this, this.hsm, "stateOneFingerClickInMapNew", this.stateMain);
        this.stateOneFingerDrag = new MapViewerTouchgesturesStateOneFingerDrag(this, this.hsm, "stateOneFingerDrag", this.stateMain);
        this.stateTwoFingerZoom = new MapViewerTouchgesturesStateTwoFingerZoom(this, this.hsm, "stateTwoFingerZoom", this.stateMain);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    public void sendHMIEventNaviClickedIcon() {
        this.logger.trace("sendEventNaviClickedIcon()");
        this.sendHMIEvent(94);
    }

    void transStateInit() {
        this.logger.trace("transStateInit()");
        this.getHsm().trans(this.stateInit);
    }

    void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    void transStateOneFingerClickInMap() {
        this.logger.trace("transStateOneFingerClickInMapNew()");
        this.getHsm().trans(this.stateOneFingerClickInMapNew);
    }

    void transStateOneFingerDrag() {
        this.logger.trace("transStateOneFingerDrag()");
        this.getHsm().trans(this.stateOneFingerDrag);
    }

    void transStateTwoFingerZoom() {
        this.logger.trace("transStateTwoFingerZoom()");
        this.getHsm().trans(this.stateTwoFingerZoom);
    }

    public MapViewerTouchgesturesStateOneFingerClickInMap getStateOneFingerClickInMap() {
        return this.stateOneFingerClickInMap;
    }

    protected void backupLocationType() {
        this.logger.trace("backupLocationType()");
        this.datapool.setLocationType(1);
    }

    protected void backupZoomLevel() {
        if (this.datapool.isAutoZoomMainMap() || this.isValidPerspectiveForAutozoom()) {
            this.logger.trace("backupZoomLevel()");
            this.datapool.setMainMapZoomLevel((int)this.datapool.getZoomLevel());
            this.datapool.setOverviewMapZoomLevel((int)this.datapool.getZoomLevel());
        }
    }

    protected boolean isValidPerspectiveForAutozoom() {
        this.logger.trace("isValidPerspectiveForAutozoom()");
        if (this.datapool.isPerspective25DCarUp()) {
            return true;
        }
        if (this.datapool.isPerspective2DCarUp()) {
            return true;
        }
        if (this.datapool.isPerspective2DNorthUp()) {
            return true;
        }
        if (this.datapool.isPerspective3DCarUp()) {
            return true;
        }
        return this.datapool.isPerspective3DDTM();
    }

    protected boolean isValidPerspectiveForMapMoved() {
        this.logger.trace("isValidPerspectiveForMapMoved()");
        if (this.datapool.isPerspective25DCarUp()) {
            return true;
        }
        if (this.datapool.isPerspective2DCarUp()) {
            return true;
        }
        if (this.datapool.isPerspective2DNorthUp()) {
            return true;
        }
        if (this.datapool.isPerspective3DCarUp()) {
            return true;
        }
        if (this.datapool.isPerspective3DDTM()) {
            return true;
        }
        if (this.datapool.isPerspectiveCountryOverview()) {
            return true;
        }
        if (this.datapool.isPerspectiveDestinationZoom()) {
            return true;
        }
        if (this.datapool.isPerspectiveOverviewZoom()) {
            return true;
        }
        return this.datapool.isPerspectiveMobilityHorizon();
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapViewerTouchgesturesTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
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

