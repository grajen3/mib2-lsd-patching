/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.WlanDevice;
import de.esolutions.fw.comm.asi.connectivity.networking.WlanServiceReply;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.WlanDeviceSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class WlanServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.networking.WlanService");
    private static int dynamicHandle = 0;
    private WlanServiceReply p_WlanServiceReply;

    public WlanServiceReplyService(WlanServiceReply wlanServiceReply) {
        super(new ServiceInstanceID("24fd4522-b997-4cd5-b2f8-890d6c224eb0", WlanServiceReplyService.nextDynamicHandle(), "7475049f-9ea8-5f56-ab00-5c258cd1be7f", "asi.connectivity.networking.WlanService"));
        this.p_WlanServiceReply = wlanServiceReply;
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
                case 2: {
                    boolean bl = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    this.p_WlanServiceReply.updateWlanReady(bl, string);
                    break;
                }
                case 3: {
                    WlanDevice wlanDevice = WlanDeviceSerializer.getOptionalWlanDevice(iDeserializer);
                    this.p_WlanServiceReply.updateWLANDevice(wlanDevice);
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

