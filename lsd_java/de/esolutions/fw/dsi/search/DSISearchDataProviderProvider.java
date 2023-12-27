/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.search;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.search.DSISearchDataProviderReply;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchDataProviderProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.RawDataSet;
import org.osgi.framework.BundleContext;

public class DSISearchDataProviderProvider
extends AbstractProvider
implements DSISearchDataProvider {
    private static final int[] attributeIDs = new int[0];
    private DSISearchDataProviderProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProvider;

    public DSISearchDataProviderProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$search$DSISearchDataProvider == null ? (class$org$dsi$ifc$search$DSISearchDataProvider = DSISearchDataProviderProvider.class$("org.dsi.ifc.search.DSISearchDataProvider")) : class$org$dsi$ifc$search$DSISearchDataProvider).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSISearchDataProviderProxy(this.instance, (DSISearchDataProviderReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void registerProviderSource(int n) {
        try {
            this.proxy.registerProviderSource(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        try {
            this.proxy.sourceDataAvailabilityChanged(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void invalidateAllData(int n) {
        try {
            this.proxy.invalidateAllData(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void storeDataSets(int n, DataSet[] dataSetArray, int n2) {
        try {
            this.proxy.storeDataSets(n, dataSetArray, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void storeRawDataSets(int n, RawDataSet[] rawDataSetArray, int n2) {
        try {
            this.proxy.storeRawDataSets(n, rawDataSetArray, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteDataSet(int n, long l) {
        try {
            this.proxy.deleteDataSet(n, l);
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

