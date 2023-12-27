/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.search.DSISearchDataProviderReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSISearchDataProviderReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.search.DSISearchDataProvider");
    private static int dynamicHandle = 0;
    private DSISearchDataProviderReply p_DSISearchDataProviderReply;

    public DSISearchDataProviderReplyService(DSISearchDataProviderReply dSISearchDataProviderReply) {
        super(new ServiceInstanceID("e807d634-9ea2-5397-904a-1df1e52b3d2c", DSISearchDataProviderReplyService.nextDynamicHandle(), "a3cc537e-0364-51f9-bde3-953f3ce486e9", "dsi.search.DSISearchDataProvider"));
        this.p_DSISearchDataProviderReply = dSISearchDataProviderReply;
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
                case 11: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSISearchDataProviderReply.registerProviderSourceResult(n, n2);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISearchDataProviderReply.activateProviderSource(n);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSISearchDataProviderReply.invalidateAllDataResult(n, n3);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSISearchDataProviderReply.provideData(n, n4, n5);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSISearchDataProviderReply.storeDataSetsResult(n, n6);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    this.p_DSISearchDataProviderReply.deleteDataSetResult(n, n7, l);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSISearchDataProviderReply.asyncException(n, string, n8);
                    break;
                }
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSISearchDataProviderReply.yyIndication(string, string2);
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

