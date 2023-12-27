/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.SdisAuthentication;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SdisAuthenticationService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.networking.SdisAuthentication");
    private SdisAuthentication p_SdisAuthentication;

    public SdisAuthenticationService(int n, SdisAuthentication sdisAuthentication) {
        super(new ServiceInstanceID("4403e802-2d1f-11e4-8e5e-9b52416440fb", n, "a7fca16c-045c-5224-a8af-1013489e690d", "asi.connectivity.networking.SdisAuthentication"));
        this.p_SdisAuthentication = sdisAuthentication;
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
                    this.p_SdisAuthentication.sdisAuthenticationSuccessful(string);
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

