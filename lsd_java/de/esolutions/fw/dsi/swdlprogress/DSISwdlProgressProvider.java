/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.swdlprogress;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swdlprogress.DSISwdlProgressReply;
import de.esolutions.fw.comm.dsi.swdlprogress.impl.DSISwdlProgressProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.swdlprogress.DSISwdlProgress;
import org.osgi.framework.BundleContext;

public class DSISwdlProgressProvider
extends AbstractProvider
implements DSISwdlProgress {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6};
    private DSISwdlProgressProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$swdlprogress$DSISwdlProgress;

    public DSISwdlProgressProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$swdlprogress$DSISwdlProgress == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgress = DSISwdlProgressProvider.class$("org.dsi.ifc.swdlprogress.DSISwdlProgress")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgress).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSISwdlProgressProxy(this.instance, (DSISwdlProgressReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void getProgressDetails(String string) {
        try {
            this.proxy.getProgressDetails(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void handleUserSelection(int n, String string, int n2) {
        try {
            this.proxy.handleUserSelection(n, string, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void handleMediumSelection(int n, String string, byte by, int n2) {
        try {
            this.proxy.handleMediumSelection(n, string, by, n2);
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

