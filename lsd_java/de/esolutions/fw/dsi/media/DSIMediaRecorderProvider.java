/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIMediaRecorderReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMediaRecorderProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.media.DSIMediaRecorder;
import org.osgi.framework.BundleContext;

public class DSIMediaRecorderProvider
extends AbstractProvider
implements DSIMediaRecorder {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private DSIMediaRecorderProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRecorder;

    public DSIMediaRecorderProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$media$DSIMediaRecorder == null ? (class$org$dsi$ifc$media$DSIMediaRecorder = DSIMediaRecorderProvider.class$("org.dsi.ifc.media.DSIMediaRecorder")) : class$org$dsi$ifc$media$DSIMediaRecorder).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMediaRecorderProxy(this.instance, (DSIMediaRecorderReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setActiveMedia(long l, long l2) {
        try {
            this.proxy.setActiveMedia(l, l2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSelection(int n) {
        try {
            this.proxy.setSelection(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startImport(boolean bl) {
        try {
            this.proxy.startImport(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortImport() {
        try {
            this.proxy.abortImport();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startDelete() {
        try {
            this.proxy.startDelete();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortDelete() {
        try {
            this.proxy.abortDelete();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTargetMedia(long l, long l2) {
        try {
            this.proxy.setTargetMedia(l, l2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEncodingQuality(int n) {
        try {
            this.proxy.setEncodingQuality(n);
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

