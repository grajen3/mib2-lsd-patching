/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.trafficregulation;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.trafficregulation.DSITrafficRegulationReply;
import de.esolutions.fw.comm.dsi.trafficregulation.impl.DSITrafficRegulationProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.trafficregulation.DSITrafficRegulation;
import org.osgi.framework.BundleContext;

public class DSITrafficRegulationProvider
extends AbstractProvider
implements DSITrafficRegulation {
    private static final int[] attributeIDs = new int[]{2, 3, 4, 5};
    private DSITrafficRegulationProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulation;

    public DSITrafficRegulationProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = DSITrafficRegulationProvider.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSITrafficRegulationProxy(this.instance, (DSITrafficRegulationReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setSpeedLimitWarning(boolean bl, boolean bl2, int n) {
        try {
            this.proxy.setSpeedLimitWarning(bl, bl2, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestRoadClassSpeedInfoForCountry(String string) {
        try {
            this.proxy.requestRoadClassSpeedInfoForCountry(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTrailerStatus(boolean bl) {
        try {
            this.proxy.setTrailerStatus(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWarningStatus(int n, boolean bl, boolean bl2, int n2) {
        try {
            this.proxy.setWarningStatus(n, bl, bl2, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
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

