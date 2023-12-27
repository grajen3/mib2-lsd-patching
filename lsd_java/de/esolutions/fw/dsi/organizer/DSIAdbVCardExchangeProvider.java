/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbVCardExchangeReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbVCardExchangeProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.DSIAdbVCardExchange;
import org.osgi.framework.BundleContext;

public class DSIAdbVCardExchangeProvider
extends AbstractProvider
implements DSIAdbVCardExchange {
    private static final int[] attributeIDs = new int[]{4, 5};
    private DSIAdbVCardExchangeProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbVCardExchange;

    public DSIAdbVCardExchangeProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$organizer$DSIAdbVCardExchange == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchange = DSIAdbVCardExchangeProvider.class$("org.dsi.ifc.organizer.DSIAdbVCardExchange")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchange).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIAdbVCardExchangeProxy(this.instance, (DSIAdbVCardExchangeReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void importVCard(ResourceLocator[] resourceLocatorArray, int n) {
        try {
            this.proxy.importVCard(resourceLocatorArray, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void exportVCard(int n, String string, long[] lArray, int n2) {
        try {
            this.proxy.exportVCard(n, string, lArray, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void exportSpellerVCard(int n, int n2, String string, long[] lArray, int n3) {
        try {
            this.proxy.exportSpellerVCard(n, n2, string, lArray, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void createVCard(int n, long[] lArray, int n2) {
        try {
            this.proxy.createVCard(n, lArray, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void parseVCard(String string) {
        try {
            this.proxy.parseVCard(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAbort(int n) {
        try {
            this.proxy.requestAbort(n);
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

