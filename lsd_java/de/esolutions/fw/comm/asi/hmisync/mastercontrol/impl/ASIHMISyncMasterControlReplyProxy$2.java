/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMasterControlReplyProxy$2
implements ISerializable {
    private final /* synthetic */ int val$appContext;
    private final /* synthetic */ String val$param;
    private final /* synthetic */ ASIHMISyncMasterControlReplyProxy this$0;

    ASIHMISyncMasterControlReplyProxy$2(ASIHMISyncMasterControlReplyProxy aSIHMISyncMasterControlReplyProxy, int n, String string) {
        this.this$0 = aSIHMISyncMasterControlReplyProxy;
        this.val$appContext = n;
        this.val$param = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$appContext);
        iSerializer.putOptionalString(this.val$param);
    }
}

