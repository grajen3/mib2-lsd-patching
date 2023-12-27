/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManager;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapViewerDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapViewerNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerNotifierModel;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerStateConfigureMapViewerNew;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerStateGoogleEarthRestart;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerStateGoogleEarthStart;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerStateGoogleEarthStop;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerStateInit;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerStateMain;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerStateSwitchSuspend;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerStateSwitchWakeup;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public class DSIMapViewerControlSwitchMapviewerTargetHSM
extends AbstractResettableAslHsmTarget {
    final DSIMapViewerControlSwitchMapViewerDataPool datapool;
    private final IExtLogger logger;
    final DSIMapViewerManager managerTarget;
    final DSIMapViewerControlSwitchMapViewerNotifierDSI notifierDSI;
    final DSIMapViewerControlSwitchMapviewerNotifierModel notifierModel;
    protected final DSIProxy proxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    private final DSIMapViewerControlSwitchMapviewerStateConfigureMapViewerNew stateConfigureMapViewerNew;
    private final DSIMapViewerControlSwitchMapviewerStateGoogleEarthRestart stateGoogleEarthRestart;
    private final DSIMapViewerControlSwitchMapviewerStateGoogleEarthStart stateGoogleEarthStart;
    private final DSIMapViewerControlSwitchMapviewerStateGoogleEarthStop stateGoogleEarthStop;
    private final DSIMapViewerControlSwitchMapviewerStateInit stateInit;
    private final DSIMapViewerControlSwitchMapviewerStateMain stateMain;
    private final DSIMapViewerControlSwitchMapviewerStateSwitchSuspend stateSwitchSuspend;
    private final DSIMapViewerControlSwitchMapviewerStateSwitchWakeup stateSwitchWakeup;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public DSIMapViewerControlSwitchMapviewerTargetHSM(GenericEvents genericEvents, int n, String string, DSIMapViewerManager dSIMapViewerManager, MapDataPool mapDataPool) {
        super(genericEvents, n, string);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlSwitchMapviewerTargetHSM]");
        this.notifierModel = new DSIMapViewerControlSwitchMapviewerNotifierModel();
        this.notifierDSI = new DSIMapViewerControlSwitchMapViewerNotifierDSI(this);
        this.managerTarget = dSIMapViewerManager;
        this.datapool = new DSIMapViewerControlSwitchMapViewerDataPool(mapDataPool);
        this.stateInit = new DSIMapViewerControlSwitchMapviewerStateInit(this, "stateInit", this.getWorkStateParent());
        this.stateMain = new DSIMapViewerControlSwitchMapviewerStateMain(this, "stateMain", this.getWorkStateParent());
        this.stateSwitchSuspend = new DSIMapViewerControlSwitchMapviewerStateSwitchSuspend(this, "stateSwitchSuspend", (HsmState)this.stateMain);
        this.stateSwitchWakeup = new DSIMapViewerControlSwitchMapviewerStateSwitchWakeup(this, "stateSwitchWakeup", (HsmState)this.stateMain);
        this.stateConfigureMapViewerNew = new DSIMapViewerControlSwitchMapviewerStateConfigureMapViewerNew(this, "stateConfigureMapViewerNew", (HsmState)this.stateMain);
        this.stateGoogleEarthRestart = new DSIMapViewerControlSwitchMapviewerStateGoogleEarthRestart(this, "stateGoogleEarthRestart", (HsmState)this.stateMain);
        this.stateGoogleEarthStart = new DSIMapViewerControlSwitchMapviewerStateGoogleEarthStart(this, "stateGoogleEarthStart", (HsmState)this.stateMain);
        this.stateGoogleEarthStop = new DSIMapViewerControlSwitchMapviewerStateGoogleEarthStop(this, "stateGoogleEarthStop", (HsmState)this.stateMain);
    }

    public DSIMapViewerControlSwitchMapViewerDataPool getDatapool() {
        return this.datapool;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    public void transStateConfigureMapViewerNew() {
        this.logger.trace("transStateConfigureMapViewerNew()");
        this.getHsm().trans(this.stateConfigureMapViewerNew);
    }

    public void transStateGoogleEarthRestart() {
        this.logger.trace("transStateGoogleEarthRestart()");
        this.getHsm().trans(this.stateGoogleEarthRestart);
    }

    public void transStateGoogleEarthStart() {
        this.logger.trace("transStateGoogleEarthStart()");
        this.getHsm().trans(this.stateGoogleEarthStart);
    }

    public void transStateGoogleEarthStop() {
        this.logger.trace("transStateGoogleEarthStop()");
        this.getHsm().trans(this.stateGoogleEarthStop);
    }

    public void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    public void transStateSwitchSuspend() {
        this.logger.trace("transStateSwitchSuspend()");
        this.getHsm().trans(this.stateSwitchSuspend);
    }

    public void transStateSwitchWakeup() {
        this.logger.trace("transStateSwitchWakeup()");
        this.getHsm().trans(this.stateSwitchWakeup);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = DSIMapViewerControlSwitchMapviewerTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("resetting values after DSI restart");
            }
            if (!this.getHsm().isActive(this.stateInit)) {
                this.resetHsmToState(this.stateMain);
            }
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

