/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecAppMMX;
import de.esolutions.fw.comm.asi.fec.FecAppMMXC;
import de.esolutions.fw.comm.asi.fec.FecAppMMXReply;
import de.esolutions.fw.comm.asi.fec.impl.FecAppMMXReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class FecAppMMXProxy
implements FecAppMMX,
FecAppMMXC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.fec.FecAppMMX");
    private Proxy proxy;

    public FecAppMMXProxy(int n, FecAppMMXReply fecAppMMXReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("374197ca-caef-403f-a993-7e171899db9d", n, "44bd5e8c-c0a5-58f5-b4e5-8c4bb4689d0e", "asi.fec.FecAppMMX");
        FecAppMMXReplyService fecAppMMXReplyService = new FecAppMMXReplyService(fecAppMMXReply);
        this.proxy = new Proxy(serviceInstanceID, fecAppMMXReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void registerForFec(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void checkPkgSignature(String string, short[] sArray, short[] sArray2) {
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
}

