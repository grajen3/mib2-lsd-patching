/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.ClockDate;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ClockDateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncHeadUnitReplyProxy$6
implements ISerializable {
    private final /* synthetic */ ClockDate val$ClockDate;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncHeadUnitReplyProxy this$0;

    ASIHMISyncHeadUnitReplyProxy$6(ASIHMISyncHeadUnitReplyProxy aSIHMISyncHeadUnitReplyProxy, ClockDate clockDate, boolean bl) {
        this.this$0 = aSIHMISyncHeadUnitReplyProxy;
        this.val$ClockDate = clockDate;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ClockDateSerializer.putOptionalClockDate(iSerializer, this.val$ClockDate);
        iSerializer.putBool(this.val$isValid);
    }
}

