/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.main;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mapinmap.main.MapInMapViewerDatapool;
import de.vw.mib.asl.internal.navigation.map.mapinmap.main.MapInMapViewerNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mapinmap.main.MapInMapViewerNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mapinmap.main.MapInMapViewerStateInit;
import de.vw.mib.asl.internal.navigation.map.mapinmap.main.MapInMapViewerStateWork;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public class MapInMapViewerTargetHsm
extends AbstractResettableAslHsmTarget {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerTargetHsm]");
    protected final MapInMapViewerNotifierDSI notifierDSI;
    protected final MapInMapViewerNotifierModel notifierModel;
    private final MapInMapViewerStateInit stateInit;
    protected final MapInMapViewerStateWork stateWork;
    protected MapInMapViewerDatapool datapool = new MapInMapViewerDatapool();
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public MapInMapViewerTargetHsm(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.notifierModel = new MapInMapViewerNotifierModel();
        this.notifierDSI = new MapInMapViewerNotifierDSI();
        this.stateWork = new MapInMapViewerStateWork(this, "stateWork", this.getWorkStateParent());
        this.stateInit = new MapInMapViewerStateInit(this, "stateInit", (HsmState)this.stateWork);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    protected void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateWork);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapInMapViewerTargetHsm.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 2)) {
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

