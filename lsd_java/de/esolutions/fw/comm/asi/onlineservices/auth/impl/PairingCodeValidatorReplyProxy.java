/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth.impl;

import de.esolutions.fw.comm.asi.onlineservices.auth.PairingCodeValidatorReply;
import de.esolutions.fw.comm.asi.onlineservices.auth.impl.PairingCodeValidatorReplyProxy$1;
import de.esolutions.fw.comm.asi.onlineservices.auth.impl.PairingCodeValidatorReplyProxy$2;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class PairingCodeValidatorReplyProxy
implements PairingCodeValidatorReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.onlineservices.auth.PairingCodeValidator");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public PairingCodeValidatorReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("66f43e33-18c7-4244-bb8e-c0ecce462f56", -1, "2097acb3-6a38-515a-af63-e947eb363c44", "asi.onlineservices.auth.PairingCodeValidator");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void validatePairingCodeResult(boolean bl, String string, String string2, int n, int n2) {
        PairingCodeValidatorReplyProxy$1 pairingCodeValidatorReplyProxy$1 = new PairingCodeValidatorReplyProxy$1(this, bl, string, string2, n, n2);
        this.proxy.remoteCallMethod((short)5, pairingCodeValidatorReplyProxy$1);
    }

    @Override
    public void resetPairingCode(String string, String string2) {
        PairingCodeValidatorReplyProxy$2 pairingCodeValidatorReplyProxy$2 = new PairingCodeValidatorReplyProxy$2(this, string, string2);
        this.proxy.remoteCallMethod((short)0, pairingCodeValidatorReplyProxy$2);
    }
}

