/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth.impl;

import de.esolutions.fw.comm.asi.onlineservices.auth.PairingCodeValidator;
import de.esolutions.fw.comm.asi.onlineservices.auth.PairingCodeValidatorC;
import de.esolutions.fw.comm.asi.onlineservices.auth.PairingCodeValidatorReply;
import de.esolutions.fw.comm.asi.onlineservices.auth.impl.PairingCodeValidatorReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class PairingCodeValidatorProxy
implements PairingCodeValidator,
PairingCodeValidatorC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.onlineservices.auth.PairingCodeValidator");
    private Proxy proxy;

    public PairingCodeValidatorProxy(int n, PairingCodeValidatorReply pairingCodeValidatorReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("1ed249e3-a1c9-4d6a-baf5-58aa429f469a", n, "d5dd51c9-4f45-5f2e-aeb1-0dd926af9544", "asi.onlineservices.auth.PairingCodeValidator");
        PairingCodeValidatorReplyService pairingCodeValidatorReplyService = new PairingCodeValidatorReplyService(pairingCodeValidatorReply);
        this.proxy = new Proxy(serviceInstanceID, pairingCodeValidatorReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void validatePairingCode(String string, String string2, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void updateActiveProfile(int n, String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }
}

