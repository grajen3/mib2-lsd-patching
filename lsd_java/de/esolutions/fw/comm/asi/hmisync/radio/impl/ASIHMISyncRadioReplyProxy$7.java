/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.StationInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncRadioReplyProxy$7
implements ISerializable {
    private final /* synthetic */ StationInfo[] val$RadioStationList;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncRadioReplyProxy this$0;

    ASIHMISyncRadioReplyProxy$7(ASIHMISyncRadioReplyProxy aSIHMISyncRadioReplyProxy, StationInfo[] stationInfoArray, boolean bl) {
        this.this$0 = aSIHMISyncRadioReplyProxy;
        this.val$RadioStationList = stationInfoArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        StationInfoSerializer.putOptionalStationInfoVarArray(iSerializer, this.val$RadioStationList);
        iSerializer.putBool(this.val$isValid);
    }
}

