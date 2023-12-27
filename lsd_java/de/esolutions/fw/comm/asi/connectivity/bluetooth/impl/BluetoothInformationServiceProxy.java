/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothInformationService;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothInformationServiceC;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothInformationServiceReply;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothInformationServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class BluetoothInformationServiceProxy
implements BluetoothInformationService,
BluetoothInformationServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.bluetooth.BluetoothInformationService");
    private Proxy proxy;

    public BluetoothInformationServiceProxy(int n, BluetoothInformationServiceReply bluetoothInformationServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("133c937f-bbad-4723-a502-4020cab96d54", n, "392292c0-0162-518b-a406-7ae6e893e978", "asi.connectivity.bluetooth.BluetoothInformationService");
        BluetoothInformationServiceReplyService bluetoothInformationServiceReplyService = new BluetoothInformationServiceReplyService(bluetoothInformationServiceReply);
        this.proxy = new Proxy(serviceInstanceID, bluetoothInformationServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }
}

