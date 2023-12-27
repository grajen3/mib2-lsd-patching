/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.connectedradio;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.connectedradio.DSIOnlineRadioReply;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIOnlineRadioProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.connectedradio.DSIOnlineRadio;
import org.dsi.ifc.connectedradio.RadioStation;
import org.osgi.framework.BundleContext;

public class DSIOnlineRadioProvider
extends AbstractProvider
implements DSIOnlineRadio {
    private static final int[] attributeIDs = new int[]{1};
    private DSIOnlineRadioProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$connectedradio$DSIOnlineRadio;

    public DSIOnlineRadioProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$connectedradio$DSIOnlineRadio == null ? (class$org$dsi$ifc$connectedradio$DSIOnlineRadio = DSIOnlineRadioProvider.class$("org.dsi.ifc.connectedradio.DSIOnlineRadio")) : class$org$dsi$ifc$connectedradio$DSIOnlineRadio).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIOnlineRadioProxy(this.instance, (DSIOnlineRadioReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void getRadioStationLogo(int n, RadioStation radioStation, int n2) {
        try {
            this.proxy.getRadioStationLogo(n, radioStation, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getStreamUrl(int n, RadioStation radioStation) {
        try {
            this.proxy.getStreamUrl(n, radioStation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getMetaInformation(int n, RadioStation radioStation) {
        try {
            this.proxy.getMetaInformation(n, radioStation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void downloadDatabase(int n) {
        try {
            this.proxy.downloadDatabase(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelDownloadDatabase(int n) {
        try {
            this.proxy.cancelDownloadDatabase(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileChange(int n) {
        try {
            this.proxy.profileChange(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileCopy(int n, int n2) {
        try {
            this.proxy.profileCopy(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileReset(int n) {
        try {
            this.proxy.profileReset(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileResetAll() {
        try {
            this.proxy.profileResetAll();
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

