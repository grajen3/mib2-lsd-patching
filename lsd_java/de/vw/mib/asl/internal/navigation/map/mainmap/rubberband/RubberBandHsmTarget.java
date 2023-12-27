/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rubberband;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandStateActive;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandStateCancel;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandStateDragMap;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandStateInactive;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandStatePressed;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberbandStateDragRoute;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberbandStateMain;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public class RubberBandHsmTarget
extends AbstractResettableAslHsmTarget {
    final RubberBandDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[RubberBandHsmTarget]");
    final RubberBandNotifierDSI notifierDSI;
    final RubberBandNotifierModel notifierModel;
    private final RubberBandStatePressed statePressed;
    private final RubberBandStateDragMap stateDragMap;
    private final RubberbandStateDragRoute stateDragRoute;
    private final RubberBandStateInit stateInit;
    private final RubberbandStateMain stateMain;
    private final RubberBandStateActive stateRubberBandActive;
    private final RubberBandStateInactive stateRubberBandInactive;
    private final RubberBandStateCancel stateCancel;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public RubberBandHsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new RubberBandDatapool();
        this.notifierDSI = new RubberBandNotifierDSI();
        this.notifierModel = new RubberBandNotifierModel();
        this.stateMain = new RubberbandStateMain(this, "stateMain", this.getWorkStateParent());
        this.stateInit = new RubberBandStateInit(this, "stateInit", (HsmState)this.stateMain);
        this.stateRubberBandInactive = new RubberBandStateInactive(this, "stateInactive", (HsmState)this.stateMain);
        this.stateRubberBandActive = new RubberBandStateActive(this, "stateActive", (HsmState)this.stateMain);
        this.statePressed = new RubberBandStatePressed(this, "statePressed", (HsmState)this.stateRubberBandActive);
        this.stateDragRoute = new RubberbandStateDragRoute(this, "stateDragRoute", (HsmState)this.stateRubberBandActive);
        this.stateDragMap = new RubberBandStateDragMap(this, "stateDragMap", (HsmState)this.stateRubberBandActive);
        this.stateCancel = new RubberBandStateCancel(this, "stateCancel", (HsmState)this.stateRubberBandInactive);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    public void transStatePressed() {
        this.logger.trace("transStatePressed()");
        this.getHsm().trans(this.statePressed);
    }

    public void transStateDragMap() {
        this.logger.trace("transStateDragMap()");
        this.getHsm().trans(this.stateDragMap);
    }

    public void transStateDragRoute() {
        this.logger.trace("transStateDragRoute()");
        this.getHsm().trans(this.stateDragRoute);
    }

    public void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    public void transStateRubberBandActive() {
        this.logger.trace("transStateRubberBandActive()");
        this.getHsm().trans(this.stateRubberBandActive);
    }

    public void transStateRubberBandInactive() {
        this.logger.trace("transStateRubberBandInactive()");
        this.getHsm().trans(this.stateRubberBandInactive);
    }

    public void transStateCancel() {
        this.logger.trace("transStateCancel()");
        this.getHsm().trans(this.stateCancel);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = RubberBandHsmTarget.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0) || this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = RubberBandHsmTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateRubberBandInactive);
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

