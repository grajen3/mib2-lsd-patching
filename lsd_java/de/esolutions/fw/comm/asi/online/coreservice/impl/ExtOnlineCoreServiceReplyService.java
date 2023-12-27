/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.ExtOnlineCoreServiceReply;
import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.License;
import de.esolutions.fw.comm.asi.online.coreservice.Result;
import de.esolutions.fw.comm.asi.online.coreservice.impl.KeyValPairSerializer;
import de.esolutions.fw.comm.asi.online.coreservice.impl.LicenseSerializer;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ResultSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ExtOnlineCoreServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.online.coreservice.ExtOnlineCoreService");
    private static int dynamicHandle = 0;
    private ExtOnlineCoreServiceReply p_ExtOnlineCoreServiceReply;

    public ExtOnlineCoreServiceReplyService(ExtOnlineCoreServiceReply extOnlineCoreServiceReply) {
        super(new ServiceInstanceID("5bb8eff1-90a0-11e2-9e96-0800200c9a66", ExtOnlineCoreServiceReplyService.nextDynamicHandle(), "e8f13a10-b3e8-5e7b-94a2-7726966f3488", "asi.online.coreservice.ExtOnlineCoreService"));
        this.p_ExtOnlineCoreServiceReply = extOnlineCoreServiceReply;
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
                case 5: {
                    int n = iDeserializer.getEnum();
                    this.p_ExtOnlineCoreServiceReply.initResponse(n);
                    break;
                }
                case 2: {
                    this.p_ExtOnlineCoreServiceReply.enableApplication();
                    break;
                }
                case 1: {
                    this.p_ExtOnlineCoreServiceReply.disableApplication();
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    KeyValPair[] keyValPairArray = KeyValPairSerializer.getOptionalKeyValPairVarArray(iDeserializer);
                    this.p_ExtOnlineCoreServiceReply.onlineResponse(n, keyValPairArray);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    this.p_ExtOnlineCoreServiceReply.dataResponse(n, byArray);
                    break;
                }
                case 3: {
                    int n = iDeserializer.getInt32();
                    Result result = ResultSerializer.getOptionalResult(iDeserializer);
                    this.p_ExtOnlineCoreServiceReply.finalResponse(n, result);
                    break;
                }
                case 13: {
                    this.p_ExtOnlineCoreServiceReply.keyStoreChanged();
                    break;
                }
                case 17: {
                    int n = iDeserializer.getEnum();
                    int n2 = iDeserializer.getEnum();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_ExtOnlineCoreServiceReply.updateCredentials(n, n2, string, string2, string3);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getEnum();
                    License[] licenseArray = LicenseSerializer.getOptionalLicenseVarArray(iDeserializer);
                    this.p_ExtOnlineCoreServiceReply.updateLicense(n, licenseArray);
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

