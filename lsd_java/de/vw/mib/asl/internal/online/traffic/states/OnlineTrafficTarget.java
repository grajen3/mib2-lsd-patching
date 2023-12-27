/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.traffic.states;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.online.traffic.OnlineTrafficManager;
import de.vw.mib.asl.internal.online.traffic.states.OnlineTrafficStateActive;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;

public class OnlineTrafficTarget
extends AbstractASLHsmTarget
implements DSIServiceStateListener {
    private HsmState _stateActive;
    private final String _classname;
    final int[] OBSERVED_EVENTS = new int[]{513622272};
    final int[] DSI_ATTR = new int[0];

    public OnlineTrafficTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this._classname = "OnlineTrafficTarget";
        this._stateActive = new OnlineTrafficStateActive(this, this.hsm, "StateActive", this.getWorkStateParent());
        OnlineTrafficManager.setOnlineTrafficTarget(this);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(195)) break;
                this.startup();
                break;
            }
            case 107: {
                this.shutdown();
                break;
            }
        }
        super.gotEvent(eventGeneric);
    }

    private void initializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append("OnlineTrafficTarget").append(".initializeDSI()").log();
        }
    }

    private void deInitializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append("OnlineTrafficTarget").append(".deInitializeDSI()").log();
        }
    }

    public void startup() {
        if (this.isTraceEnabled()) {
            this.trace().append("OnlineTrafficTarget").append(".startup()").log();
        }
        this.addObservers(this.OBSERVED_EVENTS);
    }

    public void shutdown() {
        if (this.isTraceEnabled()) {
            this.trace().append("OnlineTrafficTarget").append(".startdown()").log();
        }
        this.removeObservers(this.OBSERVED_EVENTS);
        this.deInitializeDSI();
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    protected HsmState getDefaultState() {
        return this._stateActive;
    }

    @Override
    public int getDefaultTargetId() {
        return 879629824;
    }

    public HsmState getStateActive() {
        if (this._stateActive == null) {
            this._stateActive = new OnlineTrafficStateActive(this, this.hsm, "StateActive", this.getWorkStateParent());
        }
        return this._stateActive;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append("OnlineTrafficTarget").append(".registered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[92]) {
            this.initializeDSI();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append("OnlineTrafficTarget").append(".unregistered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[92]) {
            this.deInitializeDSI();
        }
    }
}

