/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures.MapInMapViewerTouchgesturesDatapool;
import de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures.MapInMapViewerTouchgesturesNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures.MapInMapViewerTouchgesturesNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures.MapInMapViewerTouchgesturesStateInit;
import de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures.MapInMapViewerTouchgesturesStateMain;
import de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures.MapInMapViewerTouchgesturesStateTwoFingerZoom;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapInMapViewerTouchgesturesTarget
extends AbstractASLHsmTarget {
    protected final MapInMapViewerTouchgesturesDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapTouchgesturesTarget]");
    protected final MapInMapViewerTouchgesturesNotifierDSI notifierDSI;
    protected final MapInMapViewerTouchgesturesNotifierModel notifierModel;
    private final MapInMapViewerTouchgesturesStateInit stateInit;
    private final MapInMapViewerTouchgesturesStateMain stateMain;
    private final MapInMapViewerTouchgesturesStateTwoFingerZoom stateTwoFingerZoom;

    public MapInMapViewerTouchgesturesTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapInMapViewerTouchgesturesDatapool();
        this.notifierDSI = new MapInMapViewerTouchgesturesNotifierDSI();
        this.notifierModel = new MapInMapViewerTouchgesturesNotifierModel();
        this.stateInit = new MapInMapViewerTouchgesturesStateInit(this, "stateInit", this.getWorkStateParent());
        this.stateMain = new MapInMapViewerTouchgesturesStateMain(this, "stateMain", this.getWorkStateParent());
        this.stateTwoFingerZoom = new MapInMapViewerTouchgesturesStateTwoFingerZoom(this, "stateTwoFingerZoom", (HsmState)this.stateMain);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    protected void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    protected void transStateTwoFingerZoom() {
        this.logger.trace("transStateTwoFingerZoom()");
        this.getHsm().trans(this.stateTwoFingerZoom);
    }
}

