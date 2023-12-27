/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.autozoom;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.autozoom.MapViewerAutoZoomDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.autozoom.MapViewerAutoZoomNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.autozoom.MapViewerAutoZoomNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mainmap.autozoom.MapViewerAutoZoomStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.autozoom.MapViewerAutoZoomStateWork;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public final class MapViewerAutoZoomTargetHSM
extends AbstractResettableAslHsmTarget {
    protected final MapViewerAutoZoomDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerAutoZoomTargetHSM]");
    protected final MapViewerAutoZoomNotifierDSI notifierDSI;
    protected final MapViewerAutoZoomNotifierModel notifierModel;
    private final AbstractHsmState stateInit;
    private final AbstractHsmState stateWork;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerZoomEngine;

    public MapViewerAutoZoomTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapViewerAutoZoomDatapool();
        this.notifierModel = new MapViewerAutoZoomNotifierModel();
        this.notifierDSI = new MapViewerAutoZoomNotifierDSI();
        this.stateInit = new MapViewerAutoZoomStateInit(this, this.hsm, "stateInit", this.getWorkStateParent());
        this.stateWork = new MapViewerAutoZoomStateWork(this, this.hsm, "stateWork", this.getWorkStateParent());
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    public void transStateInit() {
        this.logger.trace("transStateInit()");
        this.getHsm().trans(this.stateInit);
    }

    public void transStateWork() {
        this.logger.trace("transStateWork()");
        this.getHsm().trans(this.stateWork);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngine = MapViewerAutoZoomTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngine).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateWork);
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

