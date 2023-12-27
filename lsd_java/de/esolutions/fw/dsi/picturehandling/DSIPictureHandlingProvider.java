/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.picturehandling;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.picturehandling.DSIPictureHandlingReply;
import de.esolutions.fw.comm.dsi.picturehandling.impl.DSIPictureHandlingProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturehandling.DSIPictureHandling;
import org.osgi.framework.BundleContext;

public class DSIPictureHandlingProvider
extends AbstractProvider
implements DSIPictureHandling {
    private static final int[] attributeIDs = new int[0];
    private DSIPictureHandlingProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$picturehandling$DSIPictureHandling;

    public DSIPictureHandlingProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$picturehandling$DSIPictureHandling == null ? (class$org$dsi$ifc$picturehandling$DSIPictureHandling = DSIPictureHandlingProvider.class$("org.dsi.ifc.picturehandling.DSIPictureHandling")) : class$org$dsi$ifc$picturehandling$DSIPictureHandling).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIPictureHandlingProxy(this.instance, (DSIPictureHandlingReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setPictureConfig(int n, int n2, int n3) {
        try {
            this.proxy.setPictureConfig(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestPictures(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        try {
            this.proxy.requestPictures(n, resourceLocatorArray, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelPicture(int n) {
        try {
            this.proxy.cancelPicture(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void freePicture(ResourceLocator resourceLocator) {
        try {
            this.proxy.freePicture(resourceLocator);
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

