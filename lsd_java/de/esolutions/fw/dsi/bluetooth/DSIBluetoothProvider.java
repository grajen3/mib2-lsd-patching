/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.bluetooth;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.bluetooth.DSIBluetoothReply;
import de.esolutions.fw.comm.dsi.bluetooth.impl.DSIBluetoothProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.osgi.framework.BundleContext;

public class DSIBluetoothProvider
extends AbstractProvider
implements DSIBluetooth {
    private static final int[] attributeIDs = new int[]{1, 3, 4, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17};
    private DSIBluetoothProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;

    public DSIBluetoothProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = DSIBluetoothProvider.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIBluetoothProxy(this.instance, (DSIBluetoothReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void abortConnectService(String string) {
        try {
            this.proxy.abortConnectService(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortInquiry() {
        try {
            this.proxy.abortInquiry();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAcceptIncomingServiceRequest(String string, int n, boolean bl) {
        try {
            this.proxy.requestAcceptIncomingServiceRequest(string, n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestConnectService(String string, int n, int n2) {
        try {
            this.proxy.requestConnectService(string, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestConnectServiceToInstance(String string, int n, int n2) {
        try {
            this.proxy.requestConnectServiceToInstance(string, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDisconnectService(String string, int n) {
        try {
            this.proxy.requestDisconnectService(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestGetServices(String string) {
        try {
            this.proxy.requestGetServices(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestInquiry(int n, int n2, int n3) {
        try {
            this.proxy.requestInquiry(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestPasskeyResponse(String string, String string2, int n) {
        try {
            this.proxy.requestPasskeyResponse(string, string2, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestReconnectSuspend(boolean bl) {
        try {
            this.proxy.requestReconnectSuspend(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestRemoveAuthentication(String string) {
        try {
            this.proxy.requestRemoveAuthentication(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestRestoreFactorySettings() {
        try {
            this.proxy.requestRestoreFactorySettings();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetA2DPUserSetting(boolean bl) {
        try {
            this.proxy.requestSetA2DPUserSetting(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSwitchBTState(int n) {
        try {
            this.proxy.requestSwitchBTState(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAccessibleMode(int n) {
        try {
            this.proxy.setAccessibleMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUserFriendlyName(String string) {
        try {
            this.proxy.setUserFriendlyName(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetPriorizedDeviceReconnect(boolean bl, String string) {
        try {
            this.proxy.requestSetPriorizedDeviceReconnect(bl, string);
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

