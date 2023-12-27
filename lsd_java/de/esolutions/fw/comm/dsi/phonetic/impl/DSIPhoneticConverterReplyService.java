/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.phonetic.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.phonetic.DSIPhoneticConverterReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIPhoneticConverterReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.phonetic.DSIPhoneticConverter");
    private static int dynamicHandle = 0;
    private DSIPhoneticConverterReply p_DSIPhoneticConverterReply;

    public DSIPhoneticConverterReplyService(DSIPhoneticConverterReply dSIPhoneticConverterReply) {
        super(new ServiceInstanceID("2830ffad-3726-5f2c-8fb8-4730a2dbf5e6", DSIPhoneticConverterReplyService.nextDynamicHandle(), "830cce88-feab-5c78-a8ed-3525b9be8eaa", "dsi.phonetic.DSIPhoneticConverter"));
        this.p_DSIPhoneticConverterReply = dSIPhoneticConverterReply;
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
                case 5: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    String string4 = iDeserializer.getOptionalString();
                    this.p_DSIPhoneticConverterReply.hanziToPinYinResult(string, string2, string3, string4);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    String string5 = iDeserializer.getOptionalString();
                    String string6 = iDeserializer.getOptionalString();
                    String string7 = iDeserializer.getOptionalString();
                    this.p_DSIPhoneticConverterReply.hanziToZhuYinResult(string, string5, string6, string7);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIPhoneticConverterReply.asyncException(n, string, n2);
                    break;
                }
                case 9: {
                    String string = iDeserializer.getOptionalString();
                    String string8 = iDeserializer.getOptionalString();
                    this.p_DSIPhoneticConverterReply.yyIndication(string, string8);
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

