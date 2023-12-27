/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncInstanceReplyProxy$1
implements ISerializable {
    private final /* synthetic */ String val$asiId;
    private final /* synthetic */ String val$deviceId;
    private final /* synthetic */ int val$instanceId;
    private final /* synthetic */ int val$resultcode;
    private final /* synthetic */ ASIHMISyncInstanceReplyProxy this$0;

    ASIHMISyncInstanceReplyProxy$1(ASIHMISyncInstanceReplyProxy aSIHMISyncInstanceReplyProxy, String string, String string2, int n, int n2) {
        this.this$0 = aSIHMISyncInstanceReplyProxy;
        this.val$asiId = string;
        this.val$deviceId = string2;
        this.val$instanceId = n;
        this.val$resultcode = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$asiId);
        iSerializer.putOptionalString(this.val$deviceId);
        iSerializer.putInt32(this.val$instanceId);
        iSerializer.putInt32(this.val$resultcode);
    }
}

