/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.AttributesReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class AttributesReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.persistence.Attributes");
    private static int dynamicHandle = 0;
    private AttributesReply p_AttributesReply;

    public AttributesReplyService(AttributesReply attributesReply) {
        super(new ServiceInstanceID("f423654f-fed2-59d3-be18-59e9a9b2d05f", AttributesReplyService.nextDynamicHandle(), "e5e426dc-4f2a-56e5-9b1b-8beaf406be7a", "asi.persistence.Attributes"));
        this.p_AttributesReply = attributesReply;
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
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray2 = iDeserializer.getOptionalUInt32VarArray();
                    int[] nArray = iDeserializer.getOptionalEnumVarArray();
                    this.p_AttributesReply.unsubscribeResults(lArray, lArray2, nArray);
                    break;
                }
                case 6: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray3 = iDeserializer.getOptionalUInt32VarArray();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int[] nArray = iDeserializer.getOptionalEnumVarArray();
                    this.p_AttributesReply.stringValues(lArray, lArray3, stringArray, nArray);
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray4 = iDeserializer.getOptionalUInt32VarArray();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int[] nArray2 = iDeserializer.getOptionalEnumVarArray();
                    this.p_AttributesReply.intValues(lArray, lArray4, nArray, nArray2);
                    break;
                }
                case 0: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray5 = iDeserializer.getOptionalUInt32VarArray();
                    boolean bl = !iDeserializer.getBool();
                    Object object = null;
                    if (bl) {
                        long l = iDeserializer.getUInt32();
                        object = new short[(int)l][];
                        int n = 0;
                        while ((long)n < l) {
                            object[n] = iDeserializer.getOptionalUInt8VarArray();
                            ++n;
                        }
                    }
                    int[] nArray = iDeserializer.getOptionalEnumVarArray();
                    this.p_AttributesReply.blobValues(lArray, lArray5, (short[][])object, nArray);
                    break;
                }
                case 4: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray6 = iDeserializer.getOptionalUInt32VarArray();
                    int[] nArray = iDeserializer.getOptionalEnumVarArray();
                    this.p_AttributesReply.putResults(lArray, lArray6, nArray);
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

