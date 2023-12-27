/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProviderS;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderReplyProxy;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sBoundingBoxSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class NCFSProviderService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.navigation.ncfs.NCFSProvider");
    private NCFSProviderS p_NCFSProvider;

    public NCFSProviderService(int n, NCFSProviderS nCFSProviderS) {
        super(new ServiceInstanceID("93230d7c-f001-4f4e-b59b-75d947a01065", n, "6e1126d6-ac37-5862-92a7-b77a9a12ac7d", "asi.navigation.ncfs.NCFSProvider"));
        this.p_NCFSProvider = nCFSProviderS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new NCFSProviderReplyProxy();
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
                    sBoundingBox sBoundingBox2 = sBoundingBoxSerializer.getOptionalsBoundingBox(iDeserializer);
                    this.p_NCFSProvider.requestVZORestrictions(sBoundingBox2, (NCFSProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 0: {
                    sBoundingBox sBoundingBox3 = sBoundingBoxSerializer.getOptionalsBoundingBox(iDeserializer);
                    this.p_NCFSProvider.requestLGI(sBoundingBox3, (NCFSProviderReplyProxy)iProxyFrontend);
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

