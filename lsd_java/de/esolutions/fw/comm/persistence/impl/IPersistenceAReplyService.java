/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.persistence.IPersistenceAReply;
import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class IPersistenceAReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.persistence.IPersistenceA");
    private static int dynamicHandle = 0;
    private IPersistenceAReply p_IPersistenceAReply;

    public IPersistenceAReplyService(IPersistenceAReply iPersistenceAReply) {
        super(new ServiceInstanceID("f4ac6df9-a35a-4f1c-a334-9c2890a41c09", IPersistenceAReplyService.nextDynamicHandle(), "21034d62-3469-5d3a-b904-de8a9709a4ed", "persistence.IPersistenceA"));
        this.p_IPersistenceAReply = iPersistenceAReply;
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
                case 74: {
                    long l = iDeserializer.getUInt32();
                    String string = iDeserializer.getOptionalString();
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.openResult(l, string, partitionHandle, n);
                    break;
                }
                case 73: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.openResult(string, string2, partitionHandle, n);
                    break;
                }
                case 54: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.closeResult(partitionHandle, n);
                    break;
                }
                case 83: {
                    long l = iDeserializer.getUInt32();
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.versionResult(l, string, n);
                    break;
                }
                case 82: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.versionResult(string, string3, n);
                    break;
                }
                case 76: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.purgeResult(l, n);
                    break;
                }
                case 75: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.purgeResult(string, n);
                    break;
                }
                case 52: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.beginTransactionResult(partitionHandle, n);
                    break;
                }
                case 57: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.endTransactionResult(partitionHandle, n);
                    break;
                }
                case 59: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.flushResult(partitionHandle, n);
                    break;
                }
                case 58: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.existsResult(partitionHandle, l, n);
                    break;
                }
                case 77: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.removeResult(partitionHandle, l, n);
                    break;
                }
                case 65: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    long l2 = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.getIntResult(partitionHandle, l, l2, n);
                    break;
                }
                case 67: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray2 = iDeserializer.getOptionalUInt32VarArray();
                    int[] nArray = iDeserializer.getOptionalEnumVarArray();
                    this.p_IPersistenceAReply.getIntsResult(partitionHandle, lArray, lArray2, nArray);
                    break;
                }
                case 69: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.getStringResult(partitionHandle, l, string, n);
                    break;
                }
                case 71: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int[] nArray = iDeserializer.getOptionalEnumVarArray();
                    this.p_IPersistenceAReply.getStringsResult(partitionHandle, lArray, stringArray, nArray);
                    break;
                }
                case 61: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    short[] sArray = iDeserializer.getOptionalUInt8VarArray();
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.getBlobResult(partitionHandle, l, sArray, n);
                    break;
                }
                case 63: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
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
                    this.p_IPersistenceAReply.getBlobsResult(partitionHandle, lArray, (short[][])object, nArray);
                    break;
                }
                case 78: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.setResult(partitionHandle, l, n);
                    break;
                }
                case 81: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    int[] nArray = iDeserializer.getOptionalEnumVarArray();
                    this.p_IPersistenceAReply.unsubscribeResult(partitionHandle, lArray, nArray);
                    break;
                }
                case 79: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int[] nArray = iDeserializer.getOptionalEnumVarArray();
                    this.p_IPersistenceAReply.stringValues(partitionHandle, lArray, stringArray, nArray);
                    break;
                }
                case 72: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray3 = iDeserializer.getOptionalUInt32VarArray();
                    int[] nArray = iDeserializer.getOptionalEnumVarArray();
                    this.p_IPersistenceAReply.intValues(partitionHandle, lArray, lArray3, nArray);
                    break;
                }
                case 53: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
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
                    this.p_IPersistenceAReply.blobValues(partitionHandle, lArray, (short[][])object, nArray);
                    break;
                }
                case 56: {
                    long l = iDeserializer.getUInt32();
                    String string = iDeserializer.getOptionalString();
                    String string4 = iDeserializer.getOptionalString();
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.convertResult(l, string, string4, partitionHandle, n);
                    break;
                }
                case 55: {
                    String string = iDeserializer.getOptionalString();
                    String string5 = iDeserializer.getOptionalString();
                    String string6 = iDeserializer.getOptionalString();
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_IPersistenceAReply.convertResult(string, string5, string6, partitionHandle, n);
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

