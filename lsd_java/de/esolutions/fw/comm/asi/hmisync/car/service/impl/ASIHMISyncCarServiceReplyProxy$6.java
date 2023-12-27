/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.AdBlueInfo;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.AdBlueInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$6
implements ISerializable {
    private final /* synthetic */ AdBlueInfo val$AdBlueInfo;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$6(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, AdBlueInfo adBlueInfo, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$AdBlueInfo = adBlueInfo;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AdBlueInfoSerializer.putOptionalAdBlueInfo(iSerializer, this.val$AdBlueInfo);
        iSerializer.putBool(this.val$isValid);
    }
}

