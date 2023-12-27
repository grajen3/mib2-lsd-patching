/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncHeadUnitReplyProxy$8
implements ISerializable {
    private final /* synthetic */ String val$Language2;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncHeadUnitReplyProxy this$0;

    ASIHMISyncHeadUnitReplyProxy$8(ASIHMISyncHeadUnitReplyProxy aSIHMISyncHeadUnitReplyProxy, String string, boolean bl) {
        this.this$0 = aSIHMISyncHeadUnitReplyProxy;
        this.val$Language2 = string;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$Language2);
        iSerializer.putBool(this.val$isValid);
    }
}

