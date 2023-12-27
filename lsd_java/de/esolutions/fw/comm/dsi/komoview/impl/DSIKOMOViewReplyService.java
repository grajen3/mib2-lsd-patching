/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komoview.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.komoview.DSIKOMOViewReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIKOMOViewReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.komoview.DSIKOMOView");
    private static int dynamicHandle = 0;
    private DSIKOMOViewReply p_DSIKOMOViewReply;

    public DSIKOMOViewReplyService(DSIKOMOViewReply dSIKOMOViewReply) {
        super(new ServiceInstanceID("413ce613-0a9a-54f6-93e9-bcc0513a92b5", DSIKOMOViewReplyService.nextDynamicHandle(), "7df44811-d014-5086-868d-506d5ebff276", "dsi.komoview.DSIKOMOView"));
        this.p_DSIKOMOViewReply = dSIKOMOViewReply;
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
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIKOMOViewReply.updateKomoViewEnabled(bl, n);
                    break;
                }
                case 11: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIKOMOViewReply.updateVisibility(bl, n);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIKOMOViewReply.komoViewResult(n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIKOMOViewReply.updateCurrentKomoViewType(n, n2);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIKOMOViewReply.asyncException(n, string, n3);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIKOMOViewReply.yyIndication(string, string2);
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

