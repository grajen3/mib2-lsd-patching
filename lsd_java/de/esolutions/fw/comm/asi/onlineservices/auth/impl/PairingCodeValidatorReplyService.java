/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth.impl;

import de.esolutions.fw.comm.asi.onlineservices.auth.PairingCodeValidatorReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class PairingCodeValidatorReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.onlineservices.auth.PairingCodeValidator");
    private static int dynamicHandle = 0;
    private PairingCodeValidatorReply p_PairingCodeValidatorReply;

    public PairingCodeValidatorReplyService(PairingCodeValidatorReply pairingCodeValidatorReply) {
        super(new ServiceInstanceID("66f43e33-18c7-4244-bb8e-c0ecce462f56", PairingCodeValidatorReplyService.nextDynamicHandle(), "2097acb3-6a38-515a-af63-e947eb363c44", "asi.onlineservices.auth.PairingCodeValidator"));
        this.p_PairingCodeValidatorReply = pairingCodeValidatorReply;
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
                    boolean bl = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_PairingCodeValidatorReply.validatePairingCodeResult(bl, string, string2, n, n2);
                    break;
                }
                case 0: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_PairingCodeValidatorReply.resetPairingCode(string, string3);
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

