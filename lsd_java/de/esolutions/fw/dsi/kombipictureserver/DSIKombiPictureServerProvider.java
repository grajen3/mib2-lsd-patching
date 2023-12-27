/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombipictureserver;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombipictureserver.DSIKombiPictureServerReply;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;
import org.osgi.framework.BundleContext;

public class DSIKombiPictureServerProvider
extends AbstractProvider
implements DSIKombiPictureServer {
    private static final int[] attributeIDs = new int[0];
    private DSIKombiPictureServerProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer;

    public DSIKombiPictureServerProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer = DSIKombiPictureServerProvider.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServer")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIKombiPictureServerProxy(this.instance, (DSIKombiPictureServerReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setKombiHmiReady() {
        try {
            this.proxy.setKombiHmiReady();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseCoverArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        try {
            this.proxy.responseCoverArt(l, n, n2, n3, resourceLocator);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseStationArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        try {
            this.proxy.responseStationArt(l, n, n2, n3, resourceLocator);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator) {
        try {
            this.proxy.responseActiveCallPicture(n, n2, resourceLocator);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseActiveCallPictureInstance(int n, int n2, int n3, ResourceLocator resourceLocator) {
        try {
            this.proxy.responseActiveCallPictureInstance(n, n2, n3, resourceLocator);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseDynamicIcon(int n, int n2, boolean bl, ResourceLocator resourceLocator) {
        try {
            this.proxy.responseDynamicIcon(n, n2, bl, resourceLocator);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseAdbContactPicture(long l, int n, int n2, ResourceLocator resourceLocator) {
        try {
            this.proxy.responseAdbContactPicture(l, n, n2, resourceLocator);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseInternalAddressID(long l, int n, int n2) {
        try {
            this.proxy.responseInternalAddressID(l, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responsePictureServerAbilities(int n) {
        try {
            this.proxy.responsePictureServerAbilities(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responsePictureStream(int n, short s, short s2, int n2, int n3, byte[] byArray) {
        try {
            this.proxy.responsePictureStream(n, s, s2, n2, n3, byArray);
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

