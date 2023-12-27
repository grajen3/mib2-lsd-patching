/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.picturestore;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.picturestore.DSIPictureViewerReply;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureViewerProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureViewer;
import org.osgi.framework.BundleContext;

public class DSIPictureViewerProvider
extends AbstractProvider
implements DSIPictureViewer {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5};
    private DSIPictureViewerProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$picturestore$DSIPictureViewer;

    public DSIPictureViewerProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$picturestore$DSIPictureViewer == null ? (class$org$dsi$ifc$picturestore$DSIPictureViewer = DSIPictureViewerProvider.class$("org.dsi.ifc.picturestore.DSIPictureViewer")) : class$org$dsi$ifc$picturestore$DSIPictureViewer).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIPictureViewerProxy(this.instance, (DSIPictureViewerReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void initializeViewer(int n, int n2) {
        try {
            this.proxy.initializeViewer(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deinitializeViewer() {
        try {
            this.proxy.deinitializeViewer();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSelectionMode(int n) {
        try {
            this.proxy.setSelectionMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startRendering() {
        try {
            this.proxy.startRendering();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void stopRendering() {
        try {
            this.proxy.stopRendering();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setScrollMode(int n) {
        try {
            this.proxy.setScrollMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void scrollTicks(long l) {
        try {
            this.proxy.scrollTicks(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void moveFocus(long l, int n) {
        try {
            this.proxy.moveFocus(l, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getPictureInfo(long l) {
        try {
            this.proxy.getPictureInfo(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void changeFolder(long l) {
        try {
            this.proxy.changeFolder(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void togglePictureSelection(long l) {
        try {
            this.proxy.togglePictureSelection(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void toggleAllPicturesSelection() {
        try {
            this.proxy.toggleAllPicturesSelection();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearAllPicturesSelection() {
        try {
            this.proxy.clearAllPicturesSelection();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void triggerAnimation(int n, long l) {
        try {
            this.proxy.triggerAnimation(n, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFilterSetId(int n) {
        try {
            this.proxy.setFilterSetId(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void moveFocusByResourceLocator(ResourceLocator resourceLocator, int n) {
        try {
            this.proxy.moveFocusByResourceLocator(resourceLocator, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSortingDirection(int n) {
        try {
            this.proxy.setSortingDirection(n);
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

