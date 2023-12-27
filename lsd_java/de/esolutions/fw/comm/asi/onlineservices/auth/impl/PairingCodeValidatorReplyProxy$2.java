/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth.impl;

import de.esolutions.fw.comm.asi.onlineservices.auth.impl.PairingCodeValidatorReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PairingCodeValidatorReplyProxy$2
implements ISerializable {
    private final /* synthetic */ String val$pairingCode;
    private final /* synthetic */ String val$deviceID;
    private final /* synthetic */ PairingCodeValidatorReplyProxy this$0;

    PairingCodeValidatorReplyProxy$2(PairingCodeValidatorReplyProxy pairingCodeValidatorReplyProxy, String string, String string2) {
        this.this$0 = pairingCodeValidatorReplyProxy;
        this.val$pairingCode = string;
        this.val$deviceID = string2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$pairingCode);
        iSerializer.putOptionalString(this.val$deviceID);
    }
}

