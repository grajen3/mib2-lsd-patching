/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.google.earth;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.setup.google.earth.GoogleEarthSetupDatapool;
import de.vw.mib.asl.internal.navigation.map.setup.google.earth.GoogleEarthSetupNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.setup.google.earth.GoogleEarthSetupNotifierModel;
import de.vw.mib.asl.internal.navigation.map.setup.google.earth.GoogleEarthSetupStateInit;
import de.vw.mib.asl.internal.navigation.map.setup.google.earth.GoogleEarthSetupStateRestart;
import de.vw.mib.asl.internal.navigation.map.setup.google.earth.GoogleEarthSetupStateWork;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public class GoogleEarthSetupTargetHSM
extends AbstractResettableAslHsmTarget {
    final GoogleEarthSetupDatapool datapool;
    private final IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GoogleEarthSetupTargetHSM]");
    final GoogleEarthSetupNotifierDSI notifierDSI;
    final GoogleEarthSetupNotifierModel notifierModel;
    private final GoogleEarthSetupStateInit stateInit;
    private final GoogleEarthSetupStateWork stateWork;
    private GoogleEarthSetupStateRestart stateRestart;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public GoogleEarthSetupTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new GoogleEarthSetupDatapool();
        this.notifierDSI = new GoogleEarthSetupNotifierDSI();
        this.notifierModel = new GoogleEarthSetupNotifierModel();
        this.stateWork = new GoogleEarthSetupStateWork(this, this.getHsm(), "stateWork", this.getWorkStateParent());
        this.stateInit = new GoogleEarthSetupStateInit(this, this.getHsm(), "stateInit", this.stateWork);
        this.stateRestart = new GoogleEarthSetupStateRestart(this, this.getHsm(), "stateRestart", this.stateWork);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    void transStateInit() {
        this.LOGGER.trace("transStateInit()");
        this.getHsm().trans(this.stateInit);
    }

    void transStateWork() {
        this.LOGGER.trace("transStateWork()");
        this.getHsm().trans(this.stateWork);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = GoogleEarthSetupTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 1)) {
            if (this.LOGGER.isTraceEnabled()) {
                this.LOGGER.trace("resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateRestart);
        } else if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.trace("no reset necessary because restarted DSI(s) is/are not used in target");
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

