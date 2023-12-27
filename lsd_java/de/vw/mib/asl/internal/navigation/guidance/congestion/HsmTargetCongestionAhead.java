/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.congestion;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.guidance.congestion.DSINotifier;
import de.vw.mib.asl.internal.navigation.guidance.congestion.ModelNotifier;
import de.vw.mib.asl.internal.navigation.guidance.congestion.Services;
import de.vw.mib.asl.internal.navigation.guidance.congestion.StateWork;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;

public class HsmTargetCongestionAhead
extends AbstractResettableAslHsmTarget {
    public final StateWork stateWork;
    Services services;
    long blockingId;
    int blockingLength;
    EventGeneric deleteCongestionEvent;
    boolean isNaviCoreAvailableToSetBlocks;
    ModelNotifier modelNotifier;
    DSINotifier dsiNotifier;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSIBlocking;

    @Override
    public void trace(String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public void traceState(AbstractHsmState abstractHsmState, String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(".");
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    protected void initDSI() {
        if (this.services == null) {
            this.services = new Services(this);
            this.dsiNotifier = new DSINotifier(this.services.dsiBlocking);
        }
    }

    public HsmTargetCongestionAhead(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.stateWork = new StateWork(this, this.hsm, "stateWork", this.getWorkStateParent());
        this.blockingId = -1L;
        this.blockingLength = 0;
        this.isNaviCoreAvailableToSetBlocks = false;
        this.modelNotifier = new ModelNotifier();
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetCongestionAhead.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = HsmTargetCongestionAhead.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking).getName(), 0);
        if (bl || bl2) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetCongestionAhead: resetting values after DSI restart");
            }
            if (bl) {
                this.initLocalVariablesDsiNavigation();
                this.services.initDsiNavigation();
            }
            if (bl2) {
                this.initLocalVariablesDsiBlocking();
                this.services.initDsiBlocking();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetCongestionAhead: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariablesDsiNavigation() {
        if (this.blockingId >= 0L) {
            this.deleteCongestionEvent = null;
            this.services.dsiBlocking.deleteBlock(new long[]{this.blockingId});
        }
    }

    private void initLocalVariablesDsiBlocking() {
        this.blockingId = -1L;
        this.blockingLength = 0;
        this.isNaviCoreAvailableToSetBlocks = false;
        this.deleteCongestionEvent = null;
        this.modelNotifier.notifyCongestionAheadLength(this.blockingLength);
        this.modelNotifier.notifyCongestionAheadLengthKmValue(0);
        this.modelNotifier.notifyCongestionDefined(false);
        this.modelNotifier.notifyNaviCoreReadyForBlock(false);
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

