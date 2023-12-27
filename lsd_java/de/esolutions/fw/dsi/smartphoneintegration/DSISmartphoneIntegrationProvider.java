/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.smartphoneintegration;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.smartphoneintegration.DSISmartphoneIntegrationReply;
import de.esolutions.fw.comm.dsi.smartphoneintegration.impl.DSISmartphoneIntegrationProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration;
import org.osgi.framework.BundleContext;

public class DSISmartphoneIntegrationProvider
extends AbstractProvider
implements DSISmartphoneIntegration {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5};
    private DSISmartphoneIntegrationProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration;

    public DSISmartphoneIntegrationProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration = DSISmartphoneIntegrationProvider.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSISmartphoneIntegrationProxy(this.instance, (DSISmartphoneIntegrationReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void connectDevice(int n, int n2) {
        try {
            this.proxy.connectDevice(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void disconnectDevice(int n) {
        try {
            this.proxy.disconnectDevice(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestFactorySettings(int n) {
        try {
            this.proxy.requestFactorySettings(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAppConnectContextActive(boolean bl) {
        try {
            this.proxy.requestAppConnectContextActive(bl);
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

