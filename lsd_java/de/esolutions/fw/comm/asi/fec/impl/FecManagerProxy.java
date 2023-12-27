/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecManager;
import de.esolutions.fw.comm.asi.fec.FecManagerC;
import de.esolutions.fw.comm.asi.fec.FecManagerReply;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class FecManagerProxy
implements FecManager,
FecManagerC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.fec.FecManager");
    private Proxy proxy;

    public FecManagerProxy(int n, FecManagerReply fecManagerReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("45510f6a-fda8-4182-ac03-c70430ff8124", n, "cdb4bb17-6d68-5184-9e61-9c8a35474104", "asi.fec.FecManager");
        FecManagerReplyService fecManagerReplyService = new FecManagerReplyService(fecManagerReply);
        this.proxy = new Proxy(serviceInstanceID, fecManagerReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void checkDataSignature(String string, short[] sArray, short[] sArray2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalUInt8VarArray(sArray);
            genericSerializable.putOptionalUInt8VarArray(sArray2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)0, genericSerializable);
    }

    @Override
    public void fecDetails(long l, long l2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putUInt32(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void importFecs(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void exportCCD(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void getHistory() {
        this.proxy.remoteCallMethod((short)10, null);
    }

    @Override
    public void encryptFile(String string, String string2, byte[] byArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putOptionalInt8VarArray(byArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void decryptFile(String string, String string2, byte[] byArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putOptionalInt8VarArray(byArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }
}

