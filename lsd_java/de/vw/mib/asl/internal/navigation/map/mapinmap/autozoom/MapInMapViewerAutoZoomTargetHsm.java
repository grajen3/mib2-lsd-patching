/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom.MapInMapViewerAutoZoomDatapool;
import de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom.MapInMapViewerAutoZoomNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom.MapInMapViewerAutoZoomNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom.MapInMapViewerAutoZoomStateInit;
import de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom.MapInMapViewerAutoZoomStateWork;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapInMapViewerAutoZoomTargetHsm
extends AbstractASLHsmTarget {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerAutoZoomTargetHsm]");
    protected final MapInMapViewerAutoZoomNotifierDSI notifierDSI;
    protected final MapInMapViewerAutoZoomNotifierModel notifierModel;
    private final MapInMapViewerAutoZoomStateInit stateInit;
    protected final MapInMapViewerAutoZoomStateWork stateWork;
    protected MapInMapViewerAutoZoomDatapool datapool = new MapInMapViewerAutoZoomDatapool();

    public MapInMapViewerAutoZoomTargetHsm(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.notifierModel = new MapInMapViewerAutoZoomNotifierModel();
        this.notifierDSI = new MapInMapViewerAutoZoomNotifierDSI();
        this.stateWork = new MapInMapViewerAutoZoomStateWork(this, "stateWork", this.getWorkStateParent());
        this.stateInit = new MapInMapViewerAutoZoomStateInit(this, "stateInit", (HsmState)this.stateWork);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    protected void transStateWork() {
        this.logger.trace("transStateWork()");
        this.getHsm().trans(this.stateWork);
    }
}

