/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.infotainmentrecorder.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.infotainmentrecorder.DSIInfotainmentRecorderReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIInfotainmentRecorderReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.infotainmentrecorder.DSIInfotainmentRecorder");
    private static int dynamicHandle = 0;
    private DSIInfotainmentRecorderReply p_DSIInfotainmentRecorderReply;

    public DSIInfotainmentRecorderReplyService(DSIInfotainmentRecorderReply dSIInfotainmentRecorderReply) {
        super(new ServiceInstanceID("b7c0adff-d9c2-57cd-9bc6-fcd6ec0a9162", DSIInfotainmentRecorderReplyService.nextDynamicHandle(), "c3f2ee01-f399-56d7-9269-5fc24f1e45db", "dsi.infotainmentrecorder.DSIInfotainmentRecorder"));
        this.p_DSIInfotainmentRecorderReply = dSIInfotainmentRecorderReply;
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
                case 12: {
                    boolean[] blArray = iDeserializer.getOptionalBoolVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIInfotainmentRecorderReply.updateEnabledTriggers(blArray, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIInfotainmentRecorderReply.asyncException(n, string, n2);
                    break;
                }
                case 13: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIInfotainmentRecorderReply.yyIndication(string, string2);
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

