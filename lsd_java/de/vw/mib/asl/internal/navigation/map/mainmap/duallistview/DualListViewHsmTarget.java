/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.duallistview;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewNotifierModel;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewStateActive;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewStateInactive;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewStateMapDragged;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public class DualListViewHsmTarget
extends AbstractResettableAslHsmTarget {
    final DualListViewDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DualListViewHsmTarget]");
    final DualListViewNotifierDSI notifierDSI;
    final DualListViewNotifierModel notifierModel;
    private final DualListViewStateInit stateInit;
    private final DualListViewStateActive stateActiveDLV;
    private final DualListViewStateInactive stateInactiveDLV;
    private final DualListViewStateMapDragged stateDragged;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public DualListViewHsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new DualListViewDatapool();
        this.notifierDSI = new DualListViewNotifierDSI();
        this.notifierModel = new DualListViewNotifierModel();
        this.stateInit = new DualListViewStateInit(this, "stateInit", this.getWorkStateParent());
        this.stateInactiveDLV = new DualListViewStateInactive(this, "stateInactiveDLV", this.getWorkStateParent());
        this.stateActiveDLV = new DualListViewStateActive(this, "stateActiveDLV", this.getWorkStateParent());
        this.stateDragged = new DualListViewStateMapDragged(this, "stateDragged", (HsmState)this.stateActiveDLV);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    protected void sendEventGoToLocation(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("sendEventGoToLocation(content=").append(n).append(")").log();
        }
        MapConfiguration mapConfiguration = new MapConfiguration(null, 29, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(n, mapConfiguration);
    }

    protected void transStateActive() {
        this.logger.trace("transStateActive()");
        this.getHsm().trans(this.stateActiveDLV);
    }

    protected void transStateDragged() {
        this.logger.trace("transStateDragged()");
        this.getHsm().trans(this.stateDragged);
    }

    protected void transStateInactive() {
        this.logger.trace("transStateInactive()");
        this.getHsm().trans(this.stateInactiveDLV);
    }

    protected void transStateInit() {
        this.logger.trace("transStateInit()");
        this.getHsm().trans(this.stateInit);
    }

    protected void updateDraggedXandY(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(1);
        int n2 = eventGeneric.getInt(2);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateDraggedXandY(").append("x=").append(n).append(", y=").append(n2).append(")").log();
        }
        this.datapool.setDraggedX(n);
        this.datapool.setDraggedY(n2);
    }

    protected void updateSelectedXandY(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(1);
        int n2 = eventGeneric.getInt(2);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateSelectedXandY(").append("x=").append(n).append(", y=").append(n2).append(")").log();
        }
        this.datapool.setSelectedX(n);
        this.datapool.setSelectedY(n2);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = DualListViewHsmTarget.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateInactiveDLV);
            this.initLocalVariables();
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace("no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.datapool.setContent(255);
        this.datapool.setDragged(false);
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

