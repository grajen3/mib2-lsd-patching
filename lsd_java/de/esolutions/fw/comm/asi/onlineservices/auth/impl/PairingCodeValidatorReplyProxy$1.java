/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth.impl;

import de.esolutions.fw.comm.asi.onlineservices.auth.impl.PairingCodeValidatorReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PairingCodeValidatorReplyProxy$1
implements ISerializable {
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ String val$pairingCode;
    private final /* synthetic */ String val$deviceID;
    private final /* synthetic */ int val$profileID;
    private final /* synthetic */ int val$clientData;
    private final /* synthetic */ PairingCodeValidatorReplyProxy this$0;

    PairingCodeValidatorReplyProxy$1(PairingCodeValidatorReplyProxy pairingCodeValidatorReplyProxy, boolean bl, String string, String string2, int n, int n2) {
        this.this$0 = pairingCodeValidatorReplyProxy;
        this.val$isValid = bl;
        this.val$pairingCode = string;
        this.val$deviceID = string2;
        this.val$profileID = n;
        this.val$clientData = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$isValid);
        iSerializer.putOptionalString(this.val$pairingCode);
        iSerializer.putOptionalString(this.val$deviceID);
        iSerializer.putInt32(this.val$profileID);
        iSerializer.putInt32(this.val$clientData);
    }
}

