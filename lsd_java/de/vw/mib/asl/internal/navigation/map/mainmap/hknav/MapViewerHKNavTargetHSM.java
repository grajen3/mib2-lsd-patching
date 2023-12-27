/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.hknav;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.hknav.MapViewerHKNavDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.hknav.MapViewerHKNavNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.hknav.MapViewerHKNavStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.hknav.MapViewerHKNavStateMain;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public final class MapViewerHKNavTargetHSM
extends AbstractResettableAslHsmTarget {
    protected final MapViewerHKNavDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerHKNavTargetHSM]");
    protected final MapViewerHKNavNotifierDSI notifierDSI;
    private final AbstractHsmState stateInit;
    private final AbstractHsmState stateMain;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public MapViewerHKNavTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapViewerHKNavDatapool();
        this.notifierDSI = new MapViewerHKNavNotifierDSI();
        this.stateMain = new MapViewerHKNavStateMain(this, this.hsm, "stateMain", this.getWorkStateParent());
        this.stateInit = new MapViewerHKNavStateInit(this, this.hsm, "stateInit", this.stateMain);
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

    public void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapViewerHKNavTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
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

