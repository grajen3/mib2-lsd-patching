/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlinePicNavReply;
import de.esolutions.fw.comm.dsi.online.impl.PicNavSyncInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.online.PicNavSyncInfo;

public class DSIOnlinePicNavReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.online.DSIOnlinePicNav");
    private static int dynamicHandle = 0;
    private DSIOnlinePicNavReply p_DSIOnlinePicNavReply;

    public DSIOnlinePicNavReplyService(DSIOnlinePicNavReply dSIOnlinePicNavReply) {
        super(new ServiceInstanceID("62427d00-ba7b-5a5e-9d31-35938979b03c", DSIOnlinePicNavReplyService.nextDynamicHandle(), "8e99220c-4b18-5840-99fe-b790acdd6ba0", "dsi.online.DSIOnlinePicNav"));
        this.p_DSIOnlinePicNavReply = dSIOnlinePicNavReply;
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
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIOnlinePicNavReply.updateSyncStatus(n, n2);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    PicNavSyncInfo picNavSyncInfo = PicNavSyncInfoSerializer.getOptionalPicNavSyncInfo(iDeserializer);
                    this.p_DSIOnlinePicNavReply.synchronizeResult(n, picNavSyncInfo);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    PicNavSyncInfo picNavSyncInfo = PicNavSyncInfoSerializer.getOptionalPicNavSyncInfo(iDeserializer);
                    this.p_DSIOnlinePicNavReply.getPendingTransactionsResult(n, picNavSyncInfo);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlinePicNavReply.setActiveProfileResult(n);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIOnlinePicNavReply.asyncException(n, string, n3);
                    break;
                }
                case 16: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIOnlinePicNavReply.yyIndication(string, string2);
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

