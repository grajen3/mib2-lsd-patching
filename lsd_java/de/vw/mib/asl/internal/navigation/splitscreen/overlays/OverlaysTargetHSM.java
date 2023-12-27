/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.overlays;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysDatapool;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysNotifierDSI;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysNotifierInternalAPI;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysNotifierModel;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysStateInit;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysStateWork;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysTurnListHandler;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public class OverlaysTargetHSM
extends AbstractResettableAslHsmTarget {
    private final OverlaysStateWork stateWork;
    private final OverlaysStateInit stateInit;
    protected final OverlaysDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[OverlaysTargetHSM]");
    protected final OverlaysNotifierModel notifierModel;
    protected final OverlaysNotifierDSI notifierDSI;
    protected final OverlaysTurnListHandler overlaysTurnListHandler;
    protected final OverlaysNotifierInternalAPI notifierOverlaysInternalAPI;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverView;

    public OverlaysTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new OverlaysDatapool();
        this.notifierModel = new OverlaysNotifierModel();
        this.notifierDSI = new OverlaysNotifierDSI(this);
        this.stateInit = new OverlaysStateInit(this, "stateInit", this.getWorkStateParent());
        this.stateWork = new OverlaysStateWork(this, "stateWork", this.getWorkStateParent());
        this.overlaysTurnListHandler = new OverlaysTurnListHandler();
        this.notifierOverlaysInternalAPI = new OverlaysNotifierInternalAPI();
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

    public void registerDSI() {
        this.notifierDSI.registerDSI();
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.wasDsiNavigationResettet(hashMap);
        boolean bl2 = this.wasDsiMapViewerResettet(hashMap);
        if (bl || bl2) {
            if (this.logger.isTraceEnabled()) {
                this.trace("OverlaysTargetHSM: resetting values after DSI restart");
            }
            if (bl2) {
                this.notifierDSI.initDsiMapManeuverView();
            }
            if (bl) {
                this.notifierDSI.initDsiNavigation();
            }
            this.restoreValidState();
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace("OverlaysTargetHSM: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void restoreValidState() {
        block2: {
            this.stateInit.initMotorwayInfo();
            this.stateInit.initModel();
            try {
                this.getHsm().trans(this.stateWork);
                this.getHsm().activateTransition();
            }
            catch (Exception exception) {
                if (!this.logger.isTraceEnabled()) break block2;
                this.logger.trace("Exception in reset()");
            }
        }
    }

    private boolean wasDsiNavigationResettet(HashMap hashMap) {
        return this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = OverlaysTargetHSM.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
    }

    private boolean wasDsiMapViewerResettet(HashMap hashMap) {
        return this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = OverlaysTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName(), 0);
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

