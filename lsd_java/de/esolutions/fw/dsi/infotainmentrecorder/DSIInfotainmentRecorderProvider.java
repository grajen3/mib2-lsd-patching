/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.infotainmentrecorder;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.infotainmentrecorder.DSIInfotainmentRecorderReply;
import de.esolutions.fw.comm.dsi.infotainmentrecorder.impl.DSIInfotainmentRecorderProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder;
import org.osgi.framework.BundleContext;

public class DSIInfotainmentRecorderProvider
extends AbstractProvider
implements DSIInfotainmentRecorder {
    private static final int[] attributeIDs = new int[]{1};
    private DSIInfotainmentRecorderProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder;

    public DSIInfotainmentRecorderProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder == null ? (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder = DSIInfotainmentRecorderProvider.class$("org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder")) : class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIInfotainmentRecorderProxy(this.instance, (DSIInfotainmentRecorderReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void logPanelName(String string) {
        try {
            this.proxy.logPanelName(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void logKeyEvent(int n, int n2, int n3) {
        try {
            this.proxy.logKeyEvent(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void backupTrigger(int n) {
        try {
            this.proxy.backupTrigger(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableTrigger(boolean bl, int n) {
        try {
            this.proxy.enableTrigger(bl, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void logInit() {
        try {
            this.proxy.logInit();
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

