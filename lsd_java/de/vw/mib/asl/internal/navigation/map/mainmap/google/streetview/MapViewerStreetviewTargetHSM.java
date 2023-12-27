/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerStreetViewCtrlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewStateMain;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewStateStreetView;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewStateStreetViewInvisible;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewStateTwoFingerZoom;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.map.Rect;

public final class MapViewerStreetviewTargetHSM
extends AbstractResettableAslHsmTarget {
    protected final MapViewerStreetviewDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerStreetviewTargetHSM]");
    protected final MapViewerStreetviewNotifierDSI notifierDSI;
    protected final MapViewerStreetviewNotifierModel notifierModel;
    private final AbstractHsmState stateInit;
    private final AbstractHsmState stateMain;
    private final AbstractHsmState stateStreetView;
    private final AbstractHsmState stateStreetViewInvisible;
    private final AbstractHsmState stateStreeViewTwoFingerZoom;
    protected static final Rect SCREEN_VIEW_PORT = new Rect(0, 0, 800, 480);
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public MapViewerStreetviewTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapViewerStreetviewDatapool();
        this.notifierModel = new MapViewerStreetviewNotifierModel();
        this.notifierDSI = new MapViewerStreetviewNotifierDSI();
        this.stateMain = new MapViewerStreetviewStateMain(this, this.hsm, "stateMain", this.getWorkStateParent());
        this.stateInit = new MapViewerStreetviewStateInit(this, this.hsm, "stateInit", this.stateMain);
        this.stateStreetView = new MapViewerStreetviewStateStreetView(this, this.getHsm(), "stateStreetView", this.stateMain);
        this.stateStreetViewInvisible = new MapViewerStreetviewStateStreetViewInvisible(this, this.getHsm(), "stateStreetViewInvisible", this.stateMain);
        this.stateStreeViewTwoFingerZoom = new MapViewerStreetviewStateTwoFingerZoom(this, this.getHsm(), "", this.stateStreetView);
    }

    private int calculateZoomListIndexNewStreetView(int n) {
        int n2 = this.datapool.getZoomListIndex();
        int n3 = n2 + n;
        if (n3 > this.datapool.getZoomListIndexMin()) {
            n3 = this.datapool.getZoomListIndexMin();
        } else if (n3 < this.datapool.getZoomListIndexMax()) {
            n3 = this.datapool.getZoomListIndexMax();
        }
        return n3;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    public void presetZoomLevelAndIndexStreetView() {
        int n = this.datapool.getZoomListIndex();
        int n2 = this.datapool.getZoomListIndexMax();
        int n3 = this.datapool.getZoomListIndexMin();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("presetZoomLevelAndIndexStreetView(").append(n).append(", max=").append(n2).append(", min=").append(n3).append(")").log();
        }
        if (n == n3) {
            this.notifierModel.notifyStreetViewZoomListIndexMaximumReachedFalse();
            this.notifierModel.notifyStreetViewZoomListIndexMinimumReachedTrue();
        } else if (n < n3 && n > n2) {
            this.notifierModel.notifyStreetViewZoomListIndexMinimumReachedFalse();
            this.notifierModel.notifyStreetViewZoomListIndexMaximumReachedFalse();
        } else if (n == n2) {
            this.notifierModel.notifyStreetViewZoomListIndexMinimumReachedFalse();
            this.notifierModel.notifyStreetViewZoomListIndexMaximumReachedTrue();
        }
        this.notifierModel.notifyStreetViewZoomListIndexChanged(n);
    }

    void handleDataConnectionAvailable(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDataConnectionAvailable( dataConnectionAvailable = ").append(bl).append(" )").log();
        }
        this.datapool.setDataConnectionAvailable(bl);
        if (this.datapool.isStreetViewAvailable() && this.datapool.isStreetviewLicenceOK()) {
            if (bl) {
                this.notifierModel.notifyStreetViewAvailable();
            } else {
                this.notifierModel.notifyStreetViewNotAvailable();
            }
        }
    }

    public void streetViewZoomIn() {
        int n;
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        int n2 = this.calculateZoomListIndexNewStreetView(1);
        if (n2 == (n = this.datapool.getZoomListIndex())) {
            return;
        }
        float[] fArray = this.datapool.getZoomList();
        this.datapool.setZoomListIndex(n2);
        this.datapool.setZoomLevel(fArray[n2]);
        this.presetZoomLevelAndIndexStreetView();
        this.notifierDSI.streetViewSetZoomIndex(n2);
    }

    public void streetViewZoomOut() {
        int n;
        if (!DSIMapViewerStreetViewCtrlFactoryVW.getStreetViewCtrlDataPool().isServiceAvailable()) {
            return;
        }
        int n2 = this.calculateZoomListIndexNewStreetView(-1);
        if (n2 == (n = this.datapool.getZoomListIndex())) {
            return;
        }
        float[] fArray = this.datapool.getZoomList();
        this.datapool.setZoomListIndex(n2);
        this.datapool.setZoomLevel(fArray[n2]);
        this.presetZoomLevelAndIndexStreetView();
        this.notifierDSI.streetViewSetZoomIndex(n2);
    }

    public void transStateInit() {
        this.logger.trace("transStateStreetViewInit()");
        this.getHsm().trans(this.stateInit);
    }

    public void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    public void transStateStreetView() {
        this.logger.trace("transStateStreetView()");
        this.getHsm().trans(this.stateStreetView);
    }

    public void transStateStreetViewInvisible() {
        this.logger.trace("transStateStreetViewInvisible()");
        this.getHsm().trans(this.stateStreetViewInvisible);
    }

    public void transStateStreetViewTwoFingerZoom() {
        this.logger.trace("transStateStreetViewTwoFingerZoom()");
        this.getHsm().trans(this.stateStreeViewTwoFingerZoom);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapViewerStreetviewTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("no restart neccessary");
            }
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

