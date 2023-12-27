/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom.MapViewerRocketzoomDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom.MapViewerRocketzoomNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom.MapViewerRocketzoomNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom.MapViewerRocketzoomStateActive;
import de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom.MapViewerRocketzoomStateInactive;
import de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom.MapViewerRocketzoomStateInit;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public class MapViewerRocketzoomTargetHSM
extends AbstractResettableAslHsmTarget {
    protected final MapViewerRocketzoomDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerRocketzoomTargetHSM]");
    protected final MapViewerRocketzoomNotifierDSI notifierDSI;
    protected final MapViewerRocketzoomNotifierModel notifierModel;
    private final MapViewerRocketzoomStateInit stateInit;
    private final MapViewerRocketzoomStateActive stateRocketzoomActive;
    private final MapViewerRocketzoomStateInactive stateRocketzoomInactive;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public MapViewerRocketzoomTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapViewerRocketzoomDatapool();
        this.notifierDSI = new MapViewerRocketzoomNotifierDSI();
        this.notifierModel = new MapViewerRocketzoomNotifierModel();
        this.stateInit = new MapViewerRocketzoomStateInit(this, "stateInit", this.getWorkStateParent());
        this.stateRocketzoomActive = new MapViewerRocketzoomStateActive(this, "stateRocketzoomActive", (HsmState)this.stateInit);
        this.stateRocketzoomInactive = new MapViewerRocketzoomStateInactive(this, "stateRocketzoomInactive", (HsmState)this.stateInit);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    protected void transStateActive() {
        this.logger.trace("transStateActive()");
        this.getHsm().trans(this.stateRocketzoomActive);
    }

    protected void transStateInactive() {
        this.logger.trace("transStateInactive()");
        this.getHsm().trans(this.stateRocketzoomInactive);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapViewerRocketzoomTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateRocketzoomInactive);
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

