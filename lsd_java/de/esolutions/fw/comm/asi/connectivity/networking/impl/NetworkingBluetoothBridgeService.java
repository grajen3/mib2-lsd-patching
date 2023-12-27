/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingBluetoothBridgeS;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingBluetoothBridgeReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class NetworkingBluetoothBridgeService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.networking.NetworkingBluetoothBridge");
    private NetworkingBluetoothBridgeS p_NetworkingBluetoothBridge;

    public NetworkingBluetoothBridgeService(int n, NetworkingBluetoothBridgeS networkingBluetoothBridgeS) {
        super(new ServiceInstanceID("84999d2f-6355-49bf-999e-a37b736ddb7d", n, "60332ceb-879d-5ce3-bc4c-038270cbca3c", "asi.connectivity.networking.NetworkingBluetoothBridge"));
        this.p_NetworkingBluetoothBridge = networkingBluetoothBridgeS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new NetworkingBluetoothBridgeReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 3: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getEnum();
                    int n2 = iDeserializer.getEnum();
                    this.p_NetworkingBluetoothBridge.updateConnectionState(l, n, n2, (NetworkingBluetoothBridgeReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getInt64();
                    this.p_NetworkingBluetoothBridge.updateBluetoothAddress(l, (NetworkingBluetoothBridgeReplyProxy)iProxyFrontend);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

