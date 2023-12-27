/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.CurrentStationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncRadioReplyProxy$8
implements ISerializable {
    private final /* synthetic */ CurrentStation val$ActiveStation;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncRadioReplyProxy this$0;

    ASIHMISyncRadioReplyProxy$8(ASIHMISyncRadioReplyProxy aSIHMISyncRadioReplyProxy, CurrentStation currentStation, boolean bl) {
        this.this$0 = aSIHMISyncRadioReplyProxy;
        this.val$ActiveStation = currentStation;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CurrentStationSerializer.putOptionalCurrentStation(iSerializer, this.val$ActiveStation);
        iSerializer.putBool(this.val$isValid);
    }
}

