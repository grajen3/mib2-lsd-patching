/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingBluetoothBridge;
import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingBluetoothBridgeC;
import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingBluetoothBridgeReply;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingBluetoothBridgeReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class NetworkingBluetoothBridgeProxy
implements NetworkingBluetoothBridge,
NetworkingBluetoothBridgeC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.networking.NetworkingBluetoothBridge");
    private Proxy proxy;

    public NetworkingBluetoothBridgeProxy(int n, NetworkingBluetoothBridgeReply networkingBluetoothBridgeReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("84999d2f-6355-49bf-999e-a37b736ddb7d", n, "60332ceb-879d-5ce3-bc4c-038270cbca3c", "asi.connectivity.networking.NetworkingBluetoothBridge");
        NetworkingBluetoothBridgeReplyService networkingBluetoothBridgeReplyService = new NetworkingBluetoothBridgeReplyService(networkingBluetoothBridgeReply);
        this.proxy = new Proxy(serviceInstanceID, networkingBluetoothBridgeReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateConnectionState(long l, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putEnum(n);
            genericSerializable.putEnum(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void updateBluetoothAddress(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }
}

