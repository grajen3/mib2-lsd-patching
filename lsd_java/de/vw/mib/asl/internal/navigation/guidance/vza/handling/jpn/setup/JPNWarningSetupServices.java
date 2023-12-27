/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupHsmTarget;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.trafficregulation.DSITrafficRegulation;
import org.dsi.ifc.trafficregulation.DSITrafficRegulationListener;

public final class JPNWarningSetupServices
implements DSIServiceStateListener {
    private DSITrafficRegulation dsiTrafficRegulation;
    private DSITrafficRegulationListener dsiTrafficRegulationListener;
    private JPNWarningSetupHsmTarget target;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulation;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener;

    public JPNWarningSetupServices(JPNWarningSetupHsmTarget jPNWarningSetupHsmTarget) {
        this.target = jPNWarningSetupHsmTarget;
        ServiceManager.dsiServiceLocator.addServiceStateListener(this);
    }

    @Override
    public void registered(String string, int n) {
        if (this.target.isFirstStartupDone) {
            return;
        }
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[145]) {
            this.target.traceState(new StringBuffer().append("TRAFFIC_REGULATION service registered").append(string2).toString());
            this.initDsiTrafficRegulationListener();
        }
        if (this.dsiTrafficRegulation != null) {
            this.target.isFirstStartupDone = true;
        }
    }

    void initDsiTrafficRegulationListener() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.setDsiTrafficRegulation((DSITrafficRegulation)dSIProxy.getService(this.target, class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = JPNWarningSetupServices.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation));
        this.dsiTrafficRegulationListener = (DSITrafficRegulationListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener = JPNWarningSetupServices.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulationListener")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener);
        this.getDsiTrafficRegulation().setNotification(new int[]{3}, (DSIListener)this.dsiTrafficRegulationListener);
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
            if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[145]) {
                this.unregisterDsiTrafficRegulation(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiTrafficRegulation(String string, DSIProxy dSIProxy) {
        if (this.dsiTrafficRegulationListener != null) {
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener = JPNWarningSetupServices.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulationListener")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener, this.dsiTrafficRegulationListener);
            this.dsiTrafficRegulationListener = null;
            this.traceUnregisterDone(string);
        }
        this.target.traceState("TRAFFIC_REGULATION service unregistered");
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

