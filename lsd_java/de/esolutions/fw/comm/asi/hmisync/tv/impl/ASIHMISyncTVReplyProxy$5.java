/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ActiveStationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ActiveStationInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncTVReplyProxy$5
implements ISerializable {
    private final /* synthetic */ ActiveStationInfo val$ActiveStationInfo;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncTVReplyProxy this$0;

    ASIHMISyncTVReplyProxy$5(ASIHMISyncTVReplyProxy aSIHMISyncTVReplyProxy, ActiveStationInfo activeStationInfo, boolean bl) {
        this.this$0 = aSIHMISyncTVReplyProxy;
        this.val$ActiveStationInfo = activeStationInfo;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ActiveStationInfoSerializer.putOptionalActiveStationInfo(iSerializer, this.val$ActiveStationInfo);
        iSerializer.putBool(this.val$isValid);
    }
}

