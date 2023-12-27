/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ClockTimeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncHeadUnitReplyProxy$5
implements ISerializable {
    private final /* synthetic */ ClockTime val$ClockTime;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncHeadUnitReplyProxy this$0;

    ASIHMISyncHeadUnitReplyProxy$5(ASIHMISyncHeadUnitReplyProxy aSIHMISyncHeadUnitReplyProxy, ClockTime clockTime, boolean bl) {
        this.this$0 = aSIHMISyncHeadUnitReplyProxy;
        this.val$ClockTime = clockTime;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ClockTimeSerializer.putOptionalClockTime(iSerializer, this.val$ClockTime);
        iSerializer.putBool(this.val$isValid);
    }
}

