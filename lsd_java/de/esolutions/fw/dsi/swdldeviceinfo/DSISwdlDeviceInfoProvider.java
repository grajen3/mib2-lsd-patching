/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.swdldeviceinfo;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swdldeviceinfo.DSISwdlDeviceInfoReply;
import de.esolutions.fw.comm.dsi.swdldeviceinfo.impl.DSISwdlDeviceInfoProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo;
import org.osgi.framework.BundleContext;

public class DSISwdlDeviceInfoProvider
extends AbstractProvider
implements DSISwdlDeviceInfo {
    private static final int[] attributeIDs = new int[]{1};
    private DSISwdlDeviceInfoProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo;

    public DSISwdlDeviceInfoProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo = DSISwdlDeviceInfoProvider.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSISwdlDeviceInfoProxy(this.instance, (DSISwdlDeviceInfoReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setAccessType(int n) {
        try {
            this.proxy.setAccessType(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getDevices() {
        try {
            this.proxy.getDevices();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getModules(int n) {
        try {
            this.proxy.getModules(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getLanguages(int n) {
        try {
            this.proxy.getLanguages(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getErrors(int n) {
        try {
            this.proxy.getErrors(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void isDataModule(int n, int n2) {
        try {
            this.proxy.isDataModule(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void isNoExclusiveBoloUpdate(int n, int n2) {
        try {
            this.proxy.isNoExclusiveBoloUpdate(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getVersions(int n, int n2) {
        try {
            this.proxy.getVersions(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getTargetVersions(int n, int n2) {
        try {
            this.proxy.getTargetVersions(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getAdditionalInfo(int n, int n2) {
        try {
            this.proxy.getAdditionalInfo(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void toggleSelection(int n, int n2, short s) {
        try {
            this.proxy.toggleSelection(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getFileNames(int n, int n2) {
        try {
            this.proxy.getFileNames(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getFileDetails(int n, int n2, short s) {
        try {
            this.proxy.getFileDetails(n, n2, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getInfoFilePath(int n) {
        try {
            this.proxy.getInfoFilePath(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDeviceSelection(int n, int n2) {
        try {
            this.proxy.setDeviceSelection(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getNumberOfPopups() {
        try {
            this.proxy.getNumberOfPopups();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getPopup(int n) {
        try {
            this.proxy.getPopup(n);
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

