/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchStateAtAbt;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchStateAtKombi;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchStateRestart;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchStateWork;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public class MapViewerMapSwitchTargetHSM
extends AbstractResettableAslHsmTarget {
    public static final int NEXT_SWITCH_TO_ABT;
    public static final int NEXT_SWITCH_TO_KOMBI;
    public static final int NEXT_SWITCH_NONE;
    protected final MapViewerMapSwitchDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerMapSwitchTargetHSM]");
    protected final MapViewerMapSwitchNotifierDSI notifierDSI;
    protected final MapViewerMapSwitchNotifierModel notifierModel;
    private final MapViewerMapSwitchStateInit stateInit;
    private MapViewerMapSwitchStateRestart stateRestart;
    private final MapViewerMapSwitchStateWork stateWork;
    private MapViewerMapSwitchStateAtKombi stateAtKombi;
    private MapViewerMapSwitchStateAtAbt stateAtAbt;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public MapViewerMapSwitchTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapViewerMapSwitchDatapool();
        this.notifierDSI = new MapViewerMapSwitchNotifierDSI();
        this.notifierModel = new MapViewerMapSwitchNotifierModel();
        this.stateInit = new MapViewerMapSwitchStateInit(this, this.hsm, "stateInit", this.getWorkStateParent());
        this.stateRestart = new MapViewerMapSwitchStateRestart(this, this.hsm, "stateRestart", this.getWorkStateParent());
        this.stateWork = new MapViewerMapSwitchStateWork(this, this.hsm, "stateWork", this.getWorkStateParent());
        this.stateAtKombi = new MapViewerMapSwitchStateAtKombi(this, this.hsm, "stateAtKombi", this.stateWork);
        this.stateAtAbt = new MapViewerMapSwitchStateAtAbt(this, this.hsm, "stateAtAbt", this.stateWork);
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

    public void transStateAtKombi() {
        this.logger.trace("transStateAtKombi()");
        this.getHsm().trans(this.stateAtKombi);
    }

    public void transStateAtAbt() {
        this.logger.trace("transStateAtAbt()");
        this.getHsm().trans(this.stateAtAbt);
    }

    public HsmState getStateAtKombi() {
        return this.stateAtKombi;
    }

    public HsmState getStateAtAbt() {
        return this.stateAtAbt;
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapViewerMapSwitchTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateRestart);
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

