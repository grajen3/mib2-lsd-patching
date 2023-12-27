/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.persistence.IPersistenceAReply;
import de.esolutions.fw.comm.persistence.IPersistenceAS;
import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class IPersistenceAService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.persistence.IPersistenceA");
    private IPersistenceAS p_IPersistenceA;

    public IPersistenceAService(int n, IPersistenceAS iPersistenceAS) {
        super(new ServiceInstanceID("03171582-f255-4991-b8ae-83f90521c08b", n, "6e1d32e0-f75b-5b13-8215-fd985747e793", "persistence.IPersistenceA"));
        this.p_IPersistenceA = iPersistenceAS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new IPersistenceAReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 25: {
                    long l = iDeserializer.getUInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_IPersistenceA.open(l, string, (IPersistenceAReply)((IPersistenceAReplyProxy)iProxyFrontend));
                    break;
                }
                case 24: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_IPersistenceA.open(string, string2, (IPersistenceAReply)((IPersistenceAReplyProxy)iProxyFrontend));
                    break;
                }
                case 3: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    this.p_IPersistenceA.close(partitionHandle, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 44: {
                    long l = iDeserializer.getUInt32();
                    this.p_IPersistenceA.version(l, (IPersistenceAReply)((IPersistenceAReplyProxy)iProxyFrontend));
                    break;
                }
                case 43: {
                    String string = iDeserializer.getOptionalString();
                    this.p_IPersistenceA.version(string, (IPersistenceAReply)((IPersistenceAReplyProxy)iProxyFrontend));
                    break;
                }
                case 29: {
                    long l = iDeserializer.getUInt32();
                    this.p_IPersistenceA.purge(l, (IPersistenceAReply)((IPersistenceAReplyProxy)iProxyFrontend));
                    break;
                }
                case 28: {
                    String string = iDeserializer.getOptionalString();
                    this.p_IPersistenceA.purge(string, (IPersistenceAReply)((IPersistenceAReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    this.p_IPersistenceA.beginTransaction(partitionHandle, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 51: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_IPersistenceA.endTransaction(partitionHandle, bl, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    this.p_IPersistenceA.endTransaction(partitionHandle, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 9: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    this.p_IPersistenceA.flush(partitionHandle, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    this.p_IPersistenceA.exists(partitionHandle, l, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 32: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    this.p_IPersistenceA.remove(partitionHandle, l, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 35: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    long l2 = iDeserializer.getUInt32();
                    this.p_IPersistenceA.setInt(partitionHandle, l, l2, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 64: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getInt32();
                    this.p_IPersistenceA.getInt(partitionHandle, l, n, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 15: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    this.p_IPersistenceA.getInt(partitionHandle, l, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 66: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_IPersistenceA.getInts(partitionHandle, lArray, n, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 17: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_IPersistenceA.getInts(partitionHandle, lArray, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 37: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_IPersistenceA.setString(partitionHandle, l, string, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 68: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getInt32();
                    this.p_IPersistenceA.getString(partitionHandle, l, n, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 19: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    this.p_IPersistenceA.getString(partitionHandle, l, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 70: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_IPersistenceA.getStrings(partitionHandle, lArray, n, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 21: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_IPersistenceA.getStrings(partitionHandle, lArray, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 34: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    short[] sArray = iDeserializer.getOptionalUInt8VarArray();
                    this.p_IPersistenceA.setBlob(partitionHandle, l, sArray, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 60: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getInt32();
                    this.p_IPersistenceA.getBlob(partitionHandle, l, n, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 11: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long l = iDeserializer.getUInt32();
                    this.p_IPersistenceA.getBlob(partitionHandle, l, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 62: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_IPersistenceA.getBlobs(partitionHandle, lArray, n, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 13: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_IPersistenceA.getBlobs(partitionHandle, lArray, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 80: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_IPersistenceA.subscribe(partitionHandle, lArray, n, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 39: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_IPersistenceA.subscribe(partitionHandle, lArray, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 40: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_IPersistenceA.unsubscribe(partitionHandle, lArray, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 41: {
                    PartitionHandle partitionHandle = PartitionHandleSerializer.getOptionalPartitionHandle(iDeserializer);
                    this.p_IPersistenceA.unsubscribeAll(partitionHandle, (IPersistenceAReplyProxy)iProxyFrontend);
                    break;
                }
                case 48: {
                    long l = iDeserializer.getUInt32();
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_IPersistenceA.convert(l, string, string3, (IPersistenceAReply)((IPersistenceAReplyProxy)iProxyFrontend));
                    break;
                }
                case 47: {
                    String string = iDeserializer.getOptionalString();
                    String string4 = iDeserializer.getOptionalString();
                    String string5 = iDeserializer.getOptionalString();
                    this.p_IPersistenceA.convert(string, string4, string5, (IPersistenceAReply)((IPersistenceAReplyProxy)iProxyFrontend));
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

