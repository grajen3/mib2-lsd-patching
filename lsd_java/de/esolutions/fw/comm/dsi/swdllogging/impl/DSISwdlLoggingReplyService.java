/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdllogging.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swdllogging.DSISwdlLoggingReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSISwdlLoggingReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.swdllogging.DSISwdlLogging");
    private static int dynamicHandle = 0;
    private DSISwdlLoggingReply p_DSISwdlLoggingReply;

    public DSISwdlLoggingReplyService(DSISwdlLoggingReply dSISwdlLoggingReply) {
        super(new ServiceInstanceID("d4701228-4c5f-56da-b0bf-05699002e833", DSISwdlLoggingReplyService.nextDynamicHandle(), "b02bd6b4-bef1-5aba-9811-dee9d4328506", "dsi.swdllogging.DSISwdlLogging"));
        this.p_DSISwdlLoggingReply = dSISwdlLoggingReply;
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
                case 7: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSISwdlLoggingReply.getHistory(stringArray, nArray);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlLoggingReply.setUpdate(n);
                    break;
                }
                case 20: {
                    boolean bl = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    boolean bl2 = iDeserializer.getBool();
                    String string3 = iDeserializer.getOptionalString();
                    String string4 = iDeserializer.getOptionalString();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    boolean bl3 = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int[] nArray2 = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSISwdlLoggingReply.getGeneralInformation(bl, string, string2, bl2, string3, string4, nArray, bl3, n, nArray2);
                    break;
                }
                case 11: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_DSISwdlLoggingReply.getUnusualEvents(nArray, stringArray);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string5 = iDeserializer.getOptionalString();
                    String string6 = iDeserializer.getOptionalString();
                    byte by = iDeserializer.getInt8();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSISwdlLoggingReply.getUnusualEvent(n, string, string5, string6, by, n2);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSISwdlLoggingReply.asyncException(n, string, n3);
                    break;
                }
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    String string7 = iDeserializer.getOptionalString();
                    this.p_DSISwdlLoggingReply.yyIndication(string, string7);
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

