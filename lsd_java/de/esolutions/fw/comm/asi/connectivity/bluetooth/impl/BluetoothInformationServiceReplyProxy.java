/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothDevice;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothInformationServiceReply;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothInformationServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothInformationServiceReplyProxy$2;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class BluetoothInformationServiceReplyProxy
implements BluetoothInformationServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.bluetooth.BluetoothInformationService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public BluetoothInformationServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("0d9b5586-8f24-4a93-8c53-d5cdaef1e111", -1, "4a7a95f3-5ac7-5d3b-b84d-85008994e7bf", "asi.connectivity.bluetooth.BluetoothInformationService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateBluetoothState(int n) {
        BluetoothInformationServiceReplyProxy$1 bluetoothInformationServiceReplyProxy$1 = new BluetoothInformationServiceReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)2, bluetoothInformationServiceReplyProxy$1);
    }

    @Override
    public void updateBluetoothDevices(BluetoothDevice[] bluetoothDeviceArray) {
        BluetoothInformationServiceReplyProxy$2 bluetoothInformationServiceReplyProxy$2 = new BluetoothInformationServiceReplyProxy$2(this, bluetoothDeviceArray);
        this.proxy.remoteCallMethod((short)1, bluetoothInformationServiceReplyProxy$2);
    }
}

