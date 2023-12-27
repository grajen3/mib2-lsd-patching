/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.radio;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.radio.DSITunerAnnouncementReply;
import de.esolutions.fw.comm.dsi.radio.impl.DSITunerAnnouncementProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.radio.DSITunerAnnouncement;
import org.osgi.framework.BundleContext;

public class DSITunerAnnouncementProvider
extends AbstractProvider
implements DSITunerAnnouncement {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4};
    private DSITunerAnnouncementProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSITunerAnnouncement;

    public DSITunerAnnouncementProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$radio$DSITunerAnnouncement == null ? (class$org$dsi$ifc$radio$DSITunerAnnouncement = DSITunerAnnouncementProvider.class$("org.dsi.ifc.radio.DSITunerAnnouncement")) : class$org$dsi$ifc$radio$DSITunerAnnouncement).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSITunerAnnouncementProxy(this.instance, (DSITunerAnnouncementReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setFilter(int n) {
        try {
            this.proxy.setFilter(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abort(int n) {
        try {
            this.proxy.abort(n);
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

