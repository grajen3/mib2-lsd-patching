/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncHeadUnitReplyProxy$12
implements ISerializable {
    private final /* synthetic */ int val$PressureUnit;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncHeadUnitReplyProxy this$0;

    ASIHMISyncHeadUnitReplyProxy$12(ASIHMISyncHeadUnitReplyProxy aSIHMISyncHeadUnitReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncHeadUnitReplyProxy;
        this.val$PressureUnit = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$PressureUnit);
        iSerializer.putBool(this.val$isValid);
    }
}

