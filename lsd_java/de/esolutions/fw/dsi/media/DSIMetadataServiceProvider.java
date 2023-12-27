/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIMetadataServiceReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMetadataServiceProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.media.CoverartInfo;
import org.dsi.ifc.media.DSIMetadataService;
import org.osgi.framework.BundleContext;

public class DSIMetadataServiceProvider
extends AbstractProvider
implements DSIMetadataService {
    private static final int[] attributeIDs = new int[]{1};
    private DSIMetadataServiceProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMetadataService;

    public DSIMetadataServiceProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$media$DSIMetadataService == null ? (class$org$dsi$ifc$media$DSIMetadataService = DSIMetadataServiceProvider.class$("org.dsi.ifc.media.DSIMetadataService")) : class$org$dsi$ifc$media$DSIMetadataService).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMetadataServiceProxy(this.instance, (DSIMetadataServiceReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestCoverArt(int n, CoverartInfo coverartInfo) {
        try {
            this.proxy.requestCoverArt(n, coverartInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void disableOnlineLookup() {
        try {
            this.proxy.disableOnlineLookup();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableOnlineLookup() {
        try {
            this.proxy.enableOnlineLookup();
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

