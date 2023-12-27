/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.exlap.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.exlap.DSIExlapReply;
import de.esolutions.fw.comm.dsi.exlap.impl.ServiceSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.exlap.Service;

public class DSIExlapReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.exlap.DSIExlap");
    private static int dynamicHandle = 0;
    private DSIExlapReply p_DSIExlapReply;

    public DSIExlapReplyService(DSIExlapReply dSIExlapReply) {
        super(new ServiceInstanceID("80b0cedf-8e37-5df0-9bdc-e342cb6313d5", DSIExlapReplyService.nextDynamicHandle(), "32f55de8-52f0-5d6a-bd2b-055b8f821146", "dsi.exlap.DSIExlap"));
        this.p_DSIExlapReply = dSIExlapReply;
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
                case 10: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIExlapReply.startResult(n);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIExlapReply.stopResult(n);
                    break;
                }
                case 15: {
                    Service[] serviceArray = ServiceSerializer.getOptionalServiceVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIExlapReply.updateAvailableServices(serviceArray, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIExlapReply.asyncException(n, string, n2);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIExlapReply.yyIndication(string, string2);
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

