/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.Attributes;
import de.esolutions.fw.comm.asi.persistence.AttributesC;
import de.esolutions.fw.comm.asi.persistence.AttributesReply;
import de.esolutions.fw.comm.asi.persistence.impl.AttributesReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class AttributesProxy
implements Attributes,
AttributesC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.persistence.Attributes");
    private Proxy proxy;

    public AttributesProxy(int n, AttributesReply attributesReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("a58995e5-3a88-5f1a-9a3c-1786b9a38589", n, "8a7ea0fe-3e4b-5398-9204-ca052de05566", "asi.persistence.Attributes");
        AttributesReplyService attributesReplyService = new AttributesReplyService(attributesReply);
        this.proxy = new Proxy(serviceInstanceID, attributesReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void subscribe(long[] lArray, long[] lArray2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
            genericSerializable.putOptionalUInt32VarArray(lArray2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void unsubscribe(long[] lArray, long[] lArray2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
            genericSerializable.putOptionalUInt32VarArray(lArray2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void unsubscribeAll() {
        this.proxy.remoteCallMethod((short)9, null);
    }

    @Override
    public void putInts(long[] lArray, long[] lArray2, int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
            genericSerializable.putOptionalUInt32VarArray(lArray2);
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void putStrings(long[] lArray, long[] lArray2, String[] stringArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
            genericSerializable.putOptionalUInt32VarArray(lArray2);
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void putBlobs(long[] lArray, long[] lArray2, short[][] sArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
            genericSerializable.putOptionalUInt32VarArray(lArray2);
            boolean bl = sArray != null;
            genericSerializable.putBool(!bl);
            if (bl) {
                genericSerializable.putUInt32(sArray.length);
                for (int i2 = 0; i2 < sArray.length; ++i2) {
                    genericSerializable.putOptionalUInt8VarArray(sArray[i2]);
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }
}

