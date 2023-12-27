/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncHeadUnitReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$code;
    private final /* synthetic */ String val$isoCode;
    private final /* synthetic */ ASIHMISyncHeadUnitReplyProxy this$0;

    ASIHMISyncHeadUnitReplyProxy$1(ASIHMISyncHeadUnitReplyProxy aSIHMISyncHeadUnitReplyProxy, int n, String string) {
        this.this$0 = aSIHMISyncHeadUnitReplyProxy;
        this.val$code = n;
        this.val$isoCode = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$code);
        iSerializer.putOptionalString(this.val$isoCode);
    }
}

