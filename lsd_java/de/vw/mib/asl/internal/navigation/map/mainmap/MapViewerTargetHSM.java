/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerStateMain;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerStateMapScaleContinuousIn;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerStateMapScaleContinuousOut;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public final class MapViewerTargetHSM
extends AbstractResettableAslHsmTarget {
    protected final MapViewerDatapool datapool;
    protected final MapViewerDatapoolShared datapoolShared;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerTargetHSM]");
    protected final MapViewerNotifierDSI notifierDSI;
    protected final MapViewerNotifierModel notifierModel;
    private final AbstractHsmState stateInit;
    private final AbstractHsmState stateWork;
    private MapViewerStateMapScaleContinuousIn stateMapScaleContinuousIn;
    private MapViewerStateMapScaleContinuousOut stateMapScaleContinuousOut;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public MapViewerTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapViewerDatapool();
        this.datapoolShared = MapViewerDatapoolShared.getInstance();
        this.notifierModel = new MapViewerNotifierModel();
        this.notifierDSI = new MapViewerNotifierDSI();
        this.stateInit = new MapViewerStateInit(this, this.hsm, "stateInit", this.getWorkStateParent());
        this.stateWork = new MapViewerStateMain(this, this.hsm, "stateMain", this.getWorkStateParent());
        this.stateMapScaleContinuousIn = new MapViewerStateMapScaleContinuousIn(this, "stateMapScaleContinuousIn", (HsmState)this.stateWork);
        this.stateMapScaleContinuousOut = new MapViewerStateMapScaleContinuousOut(this, "stateMapScaleContinuousOut", (HsmState)this.stateWork);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    public void transStateWork() {
        this.logger.trace("transStateWork()");
        this.getHsm().trans(this.stateWork);
    }

    void transStateMapScaleContinuousIn() {
        this.logger.trace("transStateMapScale()");
        this.getHsm().trans(this.stateMapScaleContinuousIn);
    }

    void transStateMapScaleContinuousOut() {
        this.logger.trace("transStateMapScaleContinuous()");
        this.getHsm().trans(this.stateMapScaleContinuousOut);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapViewerTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
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

