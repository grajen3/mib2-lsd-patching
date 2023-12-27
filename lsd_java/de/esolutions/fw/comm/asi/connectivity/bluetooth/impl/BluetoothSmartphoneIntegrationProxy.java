/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothSmartphoneIntegration;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothSmartphoneIntegrationC;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothSmartphoneIntegrationReply;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class BluetoothSmartphoneIntegrationProxy
implements BluetoothSmartphoneIntegration,
BluetoothSmartphoneIntegrationC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.bluetooth.BluetoothSmartphoneIntegration");
    private Proxy proxy;

    public BluetoothSmartphoneIntegrationProxy(int n, BluetoothSmartphoneIntegrationReply bluetoothSmartphoneIntegrationReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("abec271c-8352-4a6b-a4a5-a36dfd6f8f02", n, "63fedff0-a108-5360-bab1-6cc1456a6d8f", "asi.connectivity.bluetooth.BluetoothSmartphoneIntegration");
        BluetoothSmartphoneIntegrationReplyService bluetoothSmartphoneIntegrationReplyService = new BluetoothSmartphoneIntegrationReplyService(bluetoothSmartphoneIntegrationReply);
        this.proxy = new Proxy(serviceInstanceID, bluetoothSmartphoneIntegrationReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateSmartphoneMode(int n, String[] stringArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putEnum(n);
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void requestLocalBluetoothAddress() {
        this.proxy.remoteCallMethod((short)3, null);
    }

    @Override
    public void requestPrepareConnect(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }
}

