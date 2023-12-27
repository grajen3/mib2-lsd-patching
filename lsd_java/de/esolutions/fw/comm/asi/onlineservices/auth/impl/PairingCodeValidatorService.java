/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth.impl;

import de.esolutions.fw.comm.asi.onlineservices.auth.PairingCodeValidatorS;
import de.esolutions.fw.comm.asi.onlineservices.auth.impl.PairingCodeValidatorReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class PairingCodeValidatorService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.onlineservices.auth.PairingCodeValidator");
    private PairingCodeValidatorS p_PairingCodeValidator;

    public PairingCodeValidatorService(int n, PairingCodeValidatorS pairingCodeValidatorS) {
        super(new ServiceInstanceID("1ed249e3-a1c9-4d6a-baf5-58aa429f469a", n, "d5dd51c9-4f45-5f2e-aeb1-0dd926af9544", "asi.onlineservices.auth.PairingCodeValidator"));
        this.p_PairingCodeValidator = pairingCodeValidatorS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new PairingCodeValidatorReplyProxy();
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
                    String string2 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_PairingCodeValidator.validatePairingCode(string, string2, n, n2, (PairingCodeValidatorReplyProxy)iProxyFrontend);
                    break;
                }
                case 3: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_PairingCodeValidator.updateActiveProfile(n, string, string3, (PairingCodeValidatorReplyProxy)iProxyFrontend);
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

