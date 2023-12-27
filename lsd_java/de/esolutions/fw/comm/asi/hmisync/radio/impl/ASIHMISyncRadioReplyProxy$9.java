/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncRadioReplyProxy$9
implements ISerializable {
    private final /* synthetic */ int val$SeekStatus;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncRadioReplyProxy this$0;

    ASIHMISyncRadioReplyProxy$9(ASIHMISyncRadioReplyProxy aSIHMISyncRadioReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncRadioReplyProxy;
        this.val$SeekStatus = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$SeekStatus);
        iSerializer.putBool(this.val$isValid);
    }
}

