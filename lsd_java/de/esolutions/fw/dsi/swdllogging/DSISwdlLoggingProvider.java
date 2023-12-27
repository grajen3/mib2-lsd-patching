/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.swdllogging;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swdllogging.DSISwdlLoggingReply;
import de.esolutions.fw.comm.dsi.swdllogging.impl.DSISwdlLoggingProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.swdllogging.DSISwdlLogging;
import org.osgi.framework.BundleContext;

public class DSISwdlLoggingProvider
extends AbstractProvider
implements DSISwdlLogging {
    private static final int[] attributeIDs = new int[0];
    private DSISwdlLoggingProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$swdllogging$DSISwdlLogging;

    public DSISwdlLoggingProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$swdllogging$DSISwdlLogging == null ? (class$org$dsi$ifc$swdllogging$DSISwdlLogging = DSISwdlLoggingProvider.class$("org.dsi.ifc.swdllogging.DSISwdlLogging")) : class$org$dsi$ifc$swdllogging$DSISwdlLogging).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSISwdlLoggingProxy(this.instance, (DSISwdlLoggingReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void getHistory() {
        try {
            this.proxy.getHistory();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUpdate(String string) {
        try {
            this.proxy.setUpdate(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void selectSubUpdate(int n) {
        try {
            this.proxy.selectSubUpdate(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getGeneralInformation() {
        try {
            this.proxy.getGeneralInformation();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getUnusualEvents() {
        try {
            this.proxy.getUnusualEvents();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getUnusualEvent(int n) {
        try {
            this.proxy.getUnusualEvent(n);
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

