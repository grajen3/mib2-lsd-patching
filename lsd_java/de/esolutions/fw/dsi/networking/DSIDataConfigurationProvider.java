/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.networking;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.networking.DSIDataConfigurationReply;
import de.esolutions.fw.comm.dsi.networking.impl.DSIDataConfigurationProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.DSIDataConfiguration;
import org.osgi.framework.BundleContext;

public class DSIDataConfigurationProvider
extends AbstractProvider
implements DSIDataConfiguration {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 6, 9, 12};
    private DSIDataConfigurationProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConfiguration;

    public DSIDataConfigurationProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$networking$DSIDataConfiguration == null ? (class$org$dsi$ifc$networking$DSIDataConfiguration = DSIDataConfigurationProvider.class$("org.dsi.ifc.networking.DSIDataConfiguration")) : class$org$dsi$ifc$networking$DSIDataConfiguration).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIDataConfigurationProxy(this.instance, (DSIDataConfigurationReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setDataProfile(CDataProfile cDataProfile) {
        try {
            this.proxy.setDataProfile(cDataProfile);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void automaticProfile(int n) {
        try {
            this.proxy.automaticProfile(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRoamingState(int n) {
        try {
            this.proxy.setRoamingState(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setConnectionMode(int n) {
        try {
            this.proxy.setConnectionMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRequestSetting(int n, int n2) {
        try {
            this.proxy.setRequestSetting(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void acceptDataRequest(int n, boolean bl) {
        try {
            this.proxy.acceptDataRequest(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetPacketCounter() {
        try {
            this.proxy.resetPacketCounter();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void restoreFactorySettings() {
        try {
            this.proxy.restoreFactorySettings();
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

