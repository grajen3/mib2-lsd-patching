/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.displaymanagement;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.displaymanagement.DSIDisplayManagementReply;
import de.esolutions.fw.comm.dsi.displaymanagement.impl.DSIDisplayManagementProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.displaymanagement.DisplayContext;
import org.dsi.ifc.global.ResourceLocator;
import org.osgi.framework.BundleContext;

public class DSIDisplayManagementProvider
extends AbstractProvider
implements DSIDisplayManagement {
    private static final int[] attributeIDs = new int[0];
    private DSIDisplayManagementProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;

    public DSIDisplayManagementProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = DSIDisplayManagementProvider.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIDisplayManagementProxy(this.instance, (DSIDisplayManagementReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void declareContexts(DisplayContext[] displayContextArray) {
        try {
            this.proxy.declareContexts(displayContextArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void switchContext(int n, int n2, int n3) {
        try {
            this.proxy.switchContext(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setOpacity(int n, int n2, int n3) {
        try {
            this.proxy.setOpacity(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void fadeToOpacity(int n, int n2, int n3, int n4) {
        try {
            this.proxy.fadeToOpacity(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPosition(int n, int n2, int n3, int n4) {
        try {
            this.proxy.setPosition(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getExtents(int n) {
        try {
            this.proxy.getExtents(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void takeScreenshot(int n, String string) {
        try {
            this.proxy.takeScreenshot(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void lockDisplay(int n) {
        try {
            this.proxy.lockDisplay(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void unlockDisplay(int n) {
        try {
            this.proxy.unlockDisplay(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void switchDisplayPower(int n, int n2) {
        try {
            this.proxy.switchDisplayPower(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getDisplayPower(int n) {
        try {
            this.proxy.getDisplayPower(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDisplayBrightness(int n, int n2) {
        try {
            this.proxy.setDisplayBrightness(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getDisplayBrightness(int n) {
        try {
            this.proxy.getDisplayBrightness(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBrightness(int n, int n2) {
        try {
            this.proxy.setBrightness(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getBrightness(int n) {
        try {
            this.proxy.getBrightness(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setContrast(int n, int n2) {
        try {
            this.proxy.setContrast(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getContrast(int n) {
        try {
            this.proxy.getContrast(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setColor(int n, int n2) {
        try {
            this.proxy.setColor(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getColor(int n) {
        try {
            this.proxy.getColor(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTint(int n, int n2) {
        try {
            this.proxy.setTint(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getTint(int n) {
        try {
            this.proxy.getTint(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        try {
            this.proxy.setCropping(n, n2, n3, n4, n5, n6, n7, n8, n9, n10);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getDisplayableInfo(int n, int n2) {
        try {
            this.proxy.getDisplayableInfo(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDimension(int n, int n2, int n3, int n4) {
        try {
            this.proxy.setDimension(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setScaleMode(int n, int n2, int n3) {
        try {
            this.proxy.setScaleMode(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void takeScreenshotOnExternalStorage(int n, String string) {
        try {
            this.proxy.takeScreenshotOnExternalStorage(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDisplayType(int n, int n2) {
        try {
            this.proxy.setDisplayType(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getDisplayType(int n) {
        try {
            this.proxy.getDisplayType(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUpdateRate(int n, int n2) {
        try {
            this.proxy.setUpdateRate(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getUpdateRate(int n) {
        try {
            this.proxy.getUpdateRate(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startComponent(int n, int n2, int n3) {
        try {
            this.proxy.startComponent(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void stopComponent(int n, int n2, int n3) {
        try {
            this.proxy.stopComponent(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void createImageDisplayable(ResourceLocator resourceLocator, int n) {
        try {
            this.proxy.createImageDisplayable(resourceLocator, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestUpdateImageDisplayable(ResourceLocator resourceLocator, int n) {
        try {
            this.proxy.requestUpdateImageDisplayable(resourceLocator, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void destroyImageDisplayable(int n) {
        try {
            this.proxy.destroyImageDisplayable(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void initAnnotations(int n) {
        try {
            this.proxy.initAnnotations(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAnnotationData(int n, int n2, String string) {
        try {
            this.proxy.setAnnotationData(n, n2, string);
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

