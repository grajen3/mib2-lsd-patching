/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecManagerS;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class FecManagerService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.fec.FecManager");
    private FecManagerS p_FecManager;

    public FecManagerService(int n, FecManagerS fecManagerS) {
        super(new ServiceInstanceID("45510f6a-fda8-4182-ac03-c70430ff8124", n, "cdb4bb17-6d68-5184-9e61-9c8a35474104", "asi.fec.FecManager"));
        this.p_FecManager = fecManagerS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new FecManagerReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 0: {
                    String string = iDeserializer.getOptionalString();
                    short[] sArray = iDeserializer.getOptionalUInt8VarArray();
                    short[] sArray2 = iDeserializer.getOptionalUInt8VarArray();
                    this.p_FecManager.checkDataSignature(string, sArray, sArray2, (FecManagerReplyProxy)iProxyFrontend);
                    break;
                }
                case 14: {
                    long l = iDeserializer.getUInt32();
                    long l2 = iDeserializer.getUInt32();
                    this.p_FecManager.fecDetails(l, l2, (FecManagerReplyProxy)iProxyFrontend);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    this.p_FecManager.importFecs(n, (FecManagerReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    this.p_FecManager.exportCCD(n, (FecManagerReplyProxy)iProxyFrontend);
                    break;
                }
                case 10: {
                    this.p_FecManager.getHistory((FecManagerReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    this.p_FecManager.encryptFile(string, string2, byArray, (FecManagerReplyProxy)iProxyFrontend);
                    break;
                }
                case 3: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    this.p_FecManager.decryptFile(string, string3, byArray, (FecManagerReplyProxy)iProxyFrontend);
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

