/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.StationInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncTVReplyProxy$4
implements ISerializable {
    private final /* synthetic */ StationInfo[] val$StationInfo;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncTVReplyProxy this$0;

    ASIHMISyncTVReplyProxy$4(ASIHMISyncTVReplyProxy aSIHMISyncTVReplyProxy, StationInfo[] stationInfoArray, boolean bl) {
        this.this$0 = aSIHMISyncTVReplyProxy;
        this.val$StationInfo = stationInfoArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        StationInfoSerializer.putOptionalStationInfoVarArray(iSerializer, this.val$StationInfo);
        iSerializer.putBool(this.val$isValid);
    }
}

