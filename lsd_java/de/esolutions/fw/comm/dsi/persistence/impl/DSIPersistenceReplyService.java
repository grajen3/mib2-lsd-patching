/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.persistence.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.persistence.DSIPersistenceReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIPersistenceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.persistence.DSIPersistence");
    private static int dynamicHandle = 0;
    private DSIPersistenceReply p_DSIPersistenceReply;

    public DSIPersistenceReplyService(DSIPersistenceReply dSIPersistenceReply) {
        super(new ServiceInstanceID("41cba447-eba6-5c69-b37a-27fd8427a88a", DSIPersistenceReplyService.nextDynamicHandle(), "b20e710c-fdb9-55ad-a946-afba7a636c2a", "dsi.persistence.DSIPersistence"));
        this.p_DSIPersistenceReply = dSIPersistenceReply;
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
                case 43: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.updateActiveSQLDatabaseMedium(n, n2);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.writeInt(n, l, n3);
                    break;
                }
                case 39: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.readInt(n, l, n4, n5);
                    break;
                }
                case 50: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.writeBuffer(n, l, n6);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.readBuffer(n, l, byArray, n7);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.writeString(n, l, n8);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    String string = iDeserializer.getOptionalString();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.readString(n, l, string, n9);
                    break;
                }
                case 49: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.writeArray(n, l, n10);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.readArray(n, l, nArray, n11);
                    break;
                }
                case 52: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.writeStringArray(n, l, n12);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.readStringArray(n, l, stringArray, n13);
                    break;
                }
                case 36: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIPersistenceReply.getVisibleSystemLanguages(string);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.flushSQLDatabase(n);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.beginTransaction(n, n14);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.endTransaction(n, n15);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int n16 = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.valueChangedInt(n, l, n16, n17);
                    break;
                }
                case 47: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    String string = iDeserializer.getOptionalString();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.valueChangedString(n, l, string, n18);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.valueChangedArray(n, l, nArray, n19);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n20 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.valueChangedStringArray(n, l, stringArray, n20);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    int n21 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.valueChangedBuffer(n, l, byArray, n21);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    int[] nArray2 = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSIPersistenceReply.unsubscribe(n, nArray, lArray, nArray2);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n22 = iDeserializer.getInt32();
                    this.p_DSIPersistenceReply.asyncException(n, string, n22);
                    break;
                }
                case 53: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIPersistenceReply.yyIndication(string, string2);
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

