/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class NetworkingServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.networking.NetworkingService");
    private static int dynamicHandle = 0;
    private NetworkingServiceReply p_NetworkingServiceReply;

    public NetworkingServiceReplyService(NetworkingServiceReply networkingServiceReply) {
        super(new ServiceInstanceID("54bd523b-eece-4101-9c88-53bb869c6b64", NetworkingServiceReplyService.nextDynamicHandle(), "9d2b4f14-42b2-506b-aae0-1904af2be1f8", "asi.connectivity.networking.NetworkingService"));
        this.p_NetworkingServiceReply = networkingServiceReply;
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
                case 1: {
                    int n = iDeserializer.getEnum();
                    this.p_NetworkingServiceReply.updateRoamingState(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getEnum();
                    this.p_NetworkingServiceReply.updateOnlineState(n);
                    break;
                }
                case 3: {
                    int n = iDeserializer.getEnum();
                    this.p_NetworkingServiceReply.updateThrottlingState(n);
                    break;
                }
                case 2: {
                    String string = iDeserializer.getOptionalString();
                    this.p_NetworkingServiceReply.updateServiceIdentifier(string);
                    break;
                }
                case 4: {
                    int n = iDeserializer.getEnum();
                    this.p_NetworkingServiceReply.updateSimCardType(n);
                    break;
                }
                case 6: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    String string4 = iDeserializer.getOptionalString();
                    this.p_NetworkingServiceReply.updateSim(string, string2, string3, string4);
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

