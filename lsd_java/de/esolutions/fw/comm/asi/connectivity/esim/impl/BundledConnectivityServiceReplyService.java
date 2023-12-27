/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.esim.impl;

import de.esolutions.fw.comm.asi.connectivity.esim.BundledConnectivityServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class BundledConnectivityServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.esim.BundledConnectivityService");
    private static int dynamicHandle = 0;
    private BundledConnectivityServiceReply p_BundledConnectivityServiceReply;

    public BundledConnectivityServiceReplyService(BundledConnectivityServiceReply bundledConnectivityServiceReply) {
        super(new ServiceInstanceID("f7eca295-e271-472f-bce3-6b7c569ceae6", BundledConnectivityServiceReplyService.nextDynamicHandle(), "1ae1aea9-f1d3-5c1f-8af6-5b7c05cd405d", "asi.connectivity.esim.BundledConnectivityService"));
        this.p_BundledConnectivityServiceReply = bundledConnectivityServiceReply;
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
                    int n = iDeserializer.getEnum();
                    this.p_BundledConnectivityServiceReply.updateSmsTriggerReceived(n);
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

