/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.CurrentStationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncRadioReplyProxy$1
implements ISerializable {
    private final /* synthetic */ CurrentStation[] val$stationDetails;
    private final /* synthetic */ ASIHMISyncRadioReplyProxy this$0;

    ASIHMISyncRadioReplyProxy$1(ASIHMISyncRadioReplyProxy aSIHMISyncRadioReplyProxy, CurrentStation[] currentStationArray) {
        this.this$0 = aSIHMISyncRadioReplyProxy;
        this.val$stationDetails = currentStationArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CurrentStationSerializer.putOptionalCurrentStationVarArray(iSerializer, this.val$stationDetails);
    }
}

