/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncRadioReplyProxy$5
implements ISerializable {
    private final /* synthetic */ int[] val$BandList;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncRadioReplyProxy this$0;

    ASIHMISyncRadioReplyProxy$5(ASIHMISyncRadioReplyProxy aSIHMISyncRadioReplyProxy, int[] nArray, boolean bl) {
        this.this$0 = aSIHMISyncRadioReplyProxy;
        this.val$BandList = nArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt32VarArray(this.val$BandList);
        iSerializer.putBool(this.val$isValid);
    }
}

