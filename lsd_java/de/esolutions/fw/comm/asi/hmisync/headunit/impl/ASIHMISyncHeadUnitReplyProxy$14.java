/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncHeadUnitReplyProxy$14
implements ISerializable {
    private final /* synthetic */ int val$Region;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncHeadUnitReplyProxy this$0;

    ASIHMISyncHeadUnitReplyProxy$14(ASIHMISyncHeadUnitReplyProxy aSIHMISyncHeadUnitReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncHeadUnitReplyProxy;
        this.val$Region = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$Region);
        iSerializer.putBool(this.val$isValid);
    }
}

