/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecClient;
import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.comm.asi.fec.impl.SFecStateSerializer;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class FecClientService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.fec.FecClient");
    private FecClient p_FecClient;

    public FecClientService(int n, FecClient fecClient) {
        super(new ServiceInstanceID("ff733e4d-6e39-49b8-b354-ee9c22f6cfc9", n, "41fc1271-3ffd-552d-a498-7d1f105d825a", "asi.fec.FecClient"));
        this.p_FecClient = fecClient;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 1: {
                    SFecState[] sFecStateArray = SFecStateSerializer.getOptionalSFecStateVarArray(iDeserializer);
                    this.p_FecClient.updateFECs(sFecStateArray);
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

