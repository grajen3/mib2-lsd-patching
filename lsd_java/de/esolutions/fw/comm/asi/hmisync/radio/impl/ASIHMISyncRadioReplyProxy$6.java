/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncRadioReplyProxy$6
implements ISerializable {
    private final /* synthetic */ int val$ActiveBand;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncRadioReplyProxy this$0;

    ASIHMISyncRadioReplyProxy$6(ASIHMISyncRadioReplyProxy aSIHMISyncRadioReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncRadioReplyProxy;
        this.val$ActiveBand = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$ActiveBand);
        iSerializer.putBool(this.val$isValid);
    }
}

