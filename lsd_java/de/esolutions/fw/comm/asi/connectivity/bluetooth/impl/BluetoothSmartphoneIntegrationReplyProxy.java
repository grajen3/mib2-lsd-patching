/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothSmartphoneIntegrationReply;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy$1;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy$2;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy$3;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy$4;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy$5;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy$6;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class BluetoothSmartphoneIntegrationReplyProxy
implements BluetoothSmartphoneIntegrationReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.bluetooth.BluetoothSmartphoneIntegration");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public BluetoothSmartphoneIntegrationReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("e89f426d-df36-46c9-b54d-712527c0309a", -1, "fa60e661-b204-58e6-937d-484b8a10b0e4", "asi.connectivity.bluetooth.BluetoothSmartphoneIntegration");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseLocalBluetoothAddress(String string) {
        BluetoothSmartphoneIntegrationReplyProxy$1 bluetoothSmartphoneIntegrationReplyProxy$1 = new BluetoothSmartphoneIntegrationReplyProxy$1(this, string);
        this.proxy.remoteCallMethod((short)5, bluetoothSmartphoneIntegrationReplyProxy$1);
    }

    @Override
    public void updateSpiBtState(int n) {
        BluetoothSmartphoneIntegrationReplyProxy$2 bluetoothSmartphoneIntegrationReplyProxy$2 = new BluetoothSmartphoneIntegrationReplyProxy$2(this, n);
        this.proxy.remoteCallMethod((short)10, bluetoothSmartphoneIntegrationReplyProxy$2);
    }

    @Override
    public void responsePrepareConnect(String string, boolean bl, boolean bl2) {
        BluetoothSmartphoneIntegrationReplyProxy$3 bluetoothSmartphoneIntegrationReplyProxy$3 = new BluetoothSmartphoneIntegrationReplyProxy$3(this, string, bl, bl2);
        this.proxy.remoteCallMethod((short)6, bluetoothSmartphoneIntegrationReplyProxy$3);
    }

    @Override
    public void reportSharedSecret(String string, String string2) {
        BluetoothSmartphoneIntegrationReplyProxy$4 bluetoothSmartphoneIntegrationReplyProxy$4 = new BluetoothSmartphoneIntegrationReplyProxy$4(this, string, string2);
        this.proxy.remoteCallMethod((short)2, bluetoothSmartphoneIntegrationReplyProxy$4);
    }

    @Override
    public void reportParingSuccess(String string, boolean bl) {
        BluetoothSmartphoneIntegrationReplyProxy$5 bluetoothSmartphoneIntegrationReplyProxy$5 = new BluetoothSmartphoneIntegrationReplyProxy$5(this, string, bl);
        this.proxy.remoteCallMethod((short)1, bluetoothSmartphoneIntegrationReplyProxy$5);
    }

    @Override
    public void reportConnectionEstablished(String string, boolean bl) {
        BluetoothSmartphoneIntegrationReplyProxy$6 bluetoothSmartphoneIntegrationReplyProxy$6 = new BluetoothSmartphoneIntegrationReplyProxy$6(this, string, bl);
        this.proxy.remoteCallMethod((short)0, bluetoothSmartphoneIntegrationReplyProxy$6);
    }
}

