/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncInstanceReplyProxy$2
implements ISerializable {
    private final /* synthetic */ String val$ASIVersion;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncInstanceReplyProxy this$0;

    ASIHMISyncInstanceReplyProxy$2(ASIHMISyncInstanceReplyProxy aSIHMISyncInstanceReplyProxy, String string, boolean bl) {
        this.this$0 = aSIHMISyncInstanceReplyProxy;
        this.val$ASIVersion = string;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$ASIVersion);
        iSerializer.putBool(this.val$isValid);
    }
}

