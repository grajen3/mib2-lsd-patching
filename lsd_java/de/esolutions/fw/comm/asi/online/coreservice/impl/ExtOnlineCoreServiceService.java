/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.ExtOnlineCoreServiceS;
import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.RequestDescriptor;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.comm.asi.online.coreservice.impl.KeyValPairSerializer;
import de.esolutions.fw.comm.asi.online.coreservice.impl.RequestDescriptorSerializer;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ExtOnlineCoreServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.online.coreservice.ExtOnlineCoreService");
    private ExtOnlineCoreServiceS p_ExtOnlineCoreService;

    public ExtOnlineCoreServiceService(int n, ExtOnlineCoreServiceS extOnlineCoreServiceS) {
        super(new ServiceInstanceID("4e35da00-907d-11e2-9e96-0800200c9a66", n, "f93dd4b9-e569-54e1-89d7-98a3e771e233", "asi.online.coreservice.ExtOnlineCoreService"));
        this.p_ExtOnlineCoreService = extOnlineCoreServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ExtOnlineCoreServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 4: {
                    String string = iDeserializer.getOptionalString();
                    this.p_ExtOnlineCoreService.init(string, (ExtOnlineCoreServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 10: {
                    RequestDescriptor requestDescriptor = RequestDescriptorSerializer.getOptionalRequestDescriptor(iDeserializer);
                    int n = iDeserializer.getInt32();
                    KeyValPair[] keyValPairArray = KeyValPairSerializer.getOptionalKeyValPairVarArray(iDeserializer);
                    KeyValPair[] keyValPairArray2 = KeyValPairSerializer.getOptionalKeyValPairVarArray(iDeserializer);
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    this.p_ExtOnlineCoreService.onlineRequest(requestDescriptor, n, keyValPairArray, keyValPairArray2, byArray, (ExtOnlineCoreServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 14: {
                    this.p_ExtOnlineCoreService.requestUpdateKeyStore((ExtOnlineCoreServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 15: {
                    int[] nArray = iDeserializer.getOptionalEnumVarArray();
                    this.p_ExtOnlineCoreService.registerForCredentialUpdates(nArray, (ExtOnlineCoreServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 16: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_ExtOnlineCoreService.registerForLicenseUpdates(stringArray, (ExtOnlineCoreServiceReplyProxy)iProxyFrontend);
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

