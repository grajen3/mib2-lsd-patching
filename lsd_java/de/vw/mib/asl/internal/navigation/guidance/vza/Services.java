/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.navigation.guidance.vza.HsmTargetVZA;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistance;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener;
import org.dsi.ifc.trafficregulation.DSITrafficRegulation;
import org.dsi.ifc.trafficregulation.DSITrafficRegulationListener;

public final class Services
implements DSIServiceStateListener {
    private DSITrafficRegulation dsiTrafficRegulation;
    private DSITrafficRegulationListener dsiTrafficRegulationListener;
    private DSICarDriverAssistance dsiCarDriverAssistance;
    private DSICarDriverAssistanceListener dsiCarDriverAssistanceListener;
    private HsmTargetVZA target;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulation;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener;

    public Services(HsmTargetVZA hsmTargetVZA) {
        this.target = hsmTargetVZA;
        ServiceManager.dsiServiceLocator.addServiceStateListener(this);
    }

    @Override
    public void registered(String string, int n) {
        if (this.target.isFirstStartupDone) {
            return;
        }
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[19]) {
            this.initDsiCarDriverAssistance();
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[145]) {
            this.initDsiTrafficRegulation();
        }
        if (this.dsiTrafficRegulation != null && this.dsiCarDriverAssistance != null) {
            this.target.isFirstStartupDone = true;
        }
    }

    public void initDsiTrafficRegulation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.setDsiTrafficRegulation((DSITrafficRegulation)dSIProxy.getService(this.target, class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = Services.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation));
        this.dsiTrafficRegulationListener = (DSITrafficRegulationListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener = Services.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulationListener")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener);
        this.dsiTrafficRegulation.setNotification(new int[]{3}, (DSIListener)this.dsiTrafficRegulationListener);
    }

    public void initDsiCarDriverAssistance() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.target.traceState("CAR_DRIVER_ASSISTANCE service registered");
        this.dsiCarDriverAssistance = (DSICarDriverAssistance)dSIProxy.getService(this.target, class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance = Services.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistance")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance);
        this.dsiCarDriverAssistanceListener = (DSICarDriverAssistanceListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener = Services.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener);
        this.dsiCarDriverAssistance.setNotification(new int[]{38, 39, 40, 35, 36}, (DSIListener)this.dsiCarDriverAssistanceListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("HsmTargetDestList tries to unregister from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.target.trace().append("DSIProxy was null!");
                return;
            }
            String string2 = string.intern();
            if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[19]) {
                this.unregisterDsiCarDriverAssistance(string, dSIProxy);
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[145]) {
                this.unregisterDsiTrafficRegulation(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiTrafficRegulation(String string, DSIProxy dSIProxy) {
        if (this.dsiTrafficRegulationListener != null) {
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener = Services.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulationListener")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener, this.dsiTrafficRegulationListener);
            this.dsiTrafficRegulationListener = null;
            this.traceUnregisterDone(string);
        }
        this.target.traceState("TRAFFIC_REGULATION service unregistered");
    }

    private void unregisterDsiCarDriverAssistance(String string, DSIProxy dSIProxy) {
        if (this.dsiCarDriverAssistanceListener != null) {
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener = Services.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener, this.dsiCarDriverAssistanceListener);
            this.dsiCarDriverAssistanceListener = null;
            this.traceUnregisterDone(string);
        }
        this.target.traceState("CAR_DRIVER_ASSISTANCE service unregistered");
    }

    private void traceUnregisterDone(String string) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("HsmTargetDestList unregistered from ").append(string).log();
        }
    }

    public DSITrafficRegulation getDsiTrafficRegulation() {
        return this.dsiTrafficRegulation;
    }

    private void setDsiTrafficRegulation(DSITrafficRegulation dSITrafficRegulation) {
        this.dsiTrafficRegulation = dSITrafficRegulation;
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

