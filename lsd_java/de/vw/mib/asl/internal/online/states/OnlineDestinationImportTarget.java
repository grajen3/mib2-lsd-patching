/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.states;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.online.OnlineDestinationImportManager;
import de.vw.mib.asl.internal.online.states.OnlineDestinationImportStateActive;
import de.vw.mib.asl.internal.online.states.OnlineDestinationImportStateNotActive;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIDestinationImport;

public class OnlineDestinationImportTarget
extends AbstractASLHsmTarget
implements DSIServiceStateListener {
    private HsmState _stateActive;
    private HsmState _stateNotActive;
    private DSIDestinationImport _dsiDestinationImport = null;
    private DSIListener _dsiDestinationImportListener = null;
    private final String _classname = super.getClass().getName();
    private boolean _destinationImportFullyStarted;
    final int[] OBSERVED_EVENTS = new int[]{685118272, 155076864};
    final int[] DSI_ATTR = new int[0];
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIDestinationImport;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIDestinationImportListener;

    public OnlineDestinationImportTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this._stateNotActive = new OnlineDestinationImportStateNotActive(this, this.hsm, "OnlineDestinationImportStateNotActive", this.getWorkStateParent());
        OnlineDestinationImportManager.setOnlineDestinationImportTarget(this);
    }

    private void initializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".initializeDSI()").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this._dsiDestinationImport = (DSIDestinationImport)dSIProxy.getService(this, class$org$dsi$ifc$online$DSIDestinationImport == null ? (class$org$dsi$ifc$online$DSIDestinationImport = OnlineDestinationImportTarget.class$("org.dsi.ifc.online.DSIDestinationImport")) : class$org$dsi$ifc$online$DSIDestinationImport);
        this._dsiDestinationImportListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$online$DSIDestinationImportListener == null ? (class$org$dsi$ifc$online$DSIDestinationImportListener = OnlineDestinationImportTarget.class$("org.dsi.ifc.online.DSIDestinationImportListener")) : class$org$dsi$ifc$online$DSIDestinationImportListener);
        if (this._dsiDestinationImportListener != null) {
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$online$DSIDestinationImportListener == null ? (class$org$dsi$ifc$online$DSIDestinationImportListener = OnlineDestinationImportTarget.class$("org.dsi.ifc.online.DSIDestinationImportListener")) : class$org$dsi$ifc$online$DSIDestinationImportListener, this._dsiDestinationImportListener);
        } else {
            this.warn().append(this._classname).append(".initializeDSI() Invalid DSIDestinationImportListener").log();
        }
        if (this._dsiDestinationImport != null) {
            this._dsiDestinationImport.setNotification(this.DSI_ATTR, this._dsiDestinationImportListener);
        } else {
            this.warn().append(this._classname).append(".initializeDSI() Invalid DSIDestinationImport").log();
        }
    }

    private void deInitializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".deInitializeDSI()").log();
        }
        this._dsiDestinationImport = null;
        this._dsiDestinationImportListener = null;
    }

    private void startup() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".startup()").log();
        }
        this.addObservers(this.OBSERVED_EVENTS);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$online$DSIDestinationImport == null ? (class$org$dsi$ifc$online$DSIDestinationImport = OnlineDestinationImportTarget.class$("org.dsi.ifc.online.DSIDestinationImport")) : class$org$dsi$ifc$online$DSIDestinationImport, this);
        OnlineDestinationImportManager.getNaviServices();
    }

    private void shutdown() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".shutdown()").log();
        }
        ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$online$DSIDestinationImport == null ? (class$org$dsi$ifc$online$DSIDestinationImport = OnlineDestinationImportTarget.class$("org.dsi.ifc.online.DSIDestinationImport")) : class$org$dsi$ifc$online$DSIDestinationImport, this);
        this.removeObservers(this.OBSERVED_EVENTS);
        this.deInitializeDSI();
    }

    public DSIDestinationImport getDSIDestinationImport() {
        if (this._dsiDestinationImport == null) {
            this.warn().append(this._classname).append(".getDSIDestinationImport() Invalid DSI instance").log();
        }
        return this._dsiDestinationImport;
    }

    public boolean isDestinationImportFullyStarted() {
        return this._destinationImportFullyStarted;
    }

    public HsmState getNonActiveState() {
        if (this._stateNotActive == null) {
            this._stateNotActive = new OnlineDestinationImportStateNotActive(this, this.hsm, "OnlineDestinationImportStateNotActive", this.getWorkStateParent());
        }
        return this._stateNotActive;
    }

    public HsmState getActiveState() {
        if (this._stateActive == null) {
            this._stateActive = new OnlineDestinationImportStateActive(this, this.hsm, "OnlineDestinationImportStateActive", this._stateNotActive);
        }
        return this._stateActive;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_ON)").log();
                }
                this.startup();
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_OFF)").log();
                }
                this.shutdown();
                break;
            }
        }
        super.gotEvent(eventGeneric);
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
        return this._stateNotActive;
    }

    @Override
    public int getDefaultTargetId() {
        return 829298176;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".registered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[88]) {
            this.initializeDSI();
            this._destinationImportFullyStarted = true;
        }
    }

    @Override
    public void unregistered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".unregistered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[88]) {
            this.deInitializeDSI();
            this._destinationImportFullyStarted = false;
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

