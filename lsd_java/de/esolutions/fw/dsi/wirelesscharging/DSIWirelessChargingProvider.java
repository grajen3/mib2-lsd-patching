/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.wirelesscharging;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.wirelesscharging.DSIWirelessChargingReply;
import de.esolutions.fw.comm.dsi.wirelesscharging.impl.DSIWirelessChargingProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.wirelesscharging.DSIWirelessCharging;
import org.osgi.framework.BundleContext;

public class DSIWirelessChargingProvider
extends AbstractProvider
implements DSIWirelessCharging {
    private static final int[] attributeIDs = new int[]{1, 2};
    private DSIWirelessChargingProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging;

    public DSIWirelessChargingProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging == null ? (class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging = DSIWirelessChargingProvider.class$("org.dsi.ifc.wirelesscharging.DSIWirelessCharging")) : class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIWirelessChargingProxy(this.instance, (DSIWirelessChargingReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setWLCState(int n) {
        try {
            this.proxy.setWLCState(n);
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

