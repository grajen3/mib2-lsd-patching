/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.WavebandInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.WavebandInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncRadioReplyProxy$10
implements ISerializable {
    private final /* synthetic */ WavebandInfo[] val$Wavebands;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncRadioReplyProxy this$0;

    ASIHMISyncRadioReplyProxy$10(ASIHMISyncRadioReplyProxy aSIHMISyncRadioReplyProxy, WavebandInfo[] wavebandInfoArray, boolean bl) {
        this.this$0 = aSIHMISyncRadioReplyProxy;
        this.val$Wavebands = wavebandInfoArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        WavebandInfoSerializer.putOptionalWavebandInfoVarArray(iSerializer, this.val$Wavebands);
        iSerializer.putBool(this.val$isValid);
    }
}

