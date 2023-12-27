/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingBluetoothBridgeReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class NetworkingBluetoothBridgeReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.networking.NetworkingBluetoothBridge");
    private static int dynamicHandle = 0;
    private NetworkingBluetoothBridgeReply p_NetworkingBluetoothBridgeReply;

    public NetworkingBluetoothBridgeReplyService(NetworkingBluetoothBridgeReply networkingBluetoothBridgeReply) {
        super(new ServiceInstanceID("455c3e9a-730d-4285-979c-61c4a9648fa2", NetworkingBluetoothBridgeReplyService.nextDynamicHandle(), "473aed0f-a08a-5fd6-ab32-16d904233133", "asi.connectivity.networking.NetworkingBluetoothBridge"));
        this.p_NetworkingBluetoothBridgeReply = networkingBluetoothBridgeReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 0: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getEnum();
                    int n2 = iDeserializer.getEnum();
                    this.p_NetworkingBluetoothBridgeReply.setConnectionState(l, n, n2);
                    break;
                }
                case 1: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getEnum();
                    boolean bl = iDeserializer.getBool();
                    this.p_NetworkingBluetoothBridgeReply.setProfileConnectable(l, n, bl);
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

