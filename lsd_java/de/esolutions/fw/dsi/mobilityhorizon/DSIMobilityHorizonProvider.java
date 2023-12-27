/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.mobilityhorizon;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.mobilityhorizon.DSIMobilityHorizonReply;
import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.DSIMobilityHorizonProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;
import org.osgi.framework.BundleContext;

public class DSIMobilityHorizonProvider
extends AbstractProvider
implements DSIMobilityHorizon {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4};
    private DSIMobilityHorizonProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon;

    public DSIMobilityHorizonProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon == null ? (class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon = DSIMobilityHorizonProvider.class$("org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon")) : class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMobilityHorizonProxy(this.instance, (DSIMobilityHorizonReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setConsumptionInfo(ConsumptionInfo[] consumptionInfoArray) {
        try {
            this.proxy.setConsumptionInfo(consumptionInfoArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray) {
        try {
            this.proxy.setLocations(mobilityHorizonLocationArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setConsideredLocationTypes(int[] nArray) {
        try {
            this.proxy.setConsideredLocationTypes(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDriveTrainMode(int n) {
        try {
            this.proxy.setDriveTrainMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestLocationRangeLevel(int n) {
        try {
            this.proxy.requestLocationRangeLevel(n);
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

