/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tmc;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.tmc.DSITmcReply;
import de.esolutions.fw.comm.dsi.tmc.impl.DSITmcProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.tmc.DSITmc;
import org.osgi.framework.BundleContext;

public class DSITmcProvider
extends AbstractProvider
implements DSITmc {
    private static final int[] attributeIDs = new int[]{1, 2, 5, 6, 7, 8, 11, 12, 13, 14, 15, 16};
    private DSITmcProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmc;

    public DSITmcProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = DSITmcProvider.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSITmcProxy(this.instance, (DSITmcReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestTmcWindow(int n, int n2, int n3, int[] nArray, int n4) {
        try {
            this.proxy.requestTmcWindow(n, n2, n3, nArray, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMessageFilter(int n, int n2) {
        try {
            this.proxy.setMessageFilter(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getMessageIdsForListElement(long l) {
        try {
            this.proxy.getMessageIdsForListElement(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getBoundingRectangleForTrafficMessages(long[] lArray) {
        try {
            this.proxy.getBoundingRectangleForTrafficMessages(lArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableAreaWarnings(boolean bl) {
        try {
            this.proxy.enableAreaWarnings(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableTrafficFlowStatistics(boolean bl) {
        try {
            this.proxy.enableTrafficFlowStatistics(bl);
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

