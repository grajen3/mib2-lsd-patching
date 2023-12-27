/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMasterControlReplyProxy$7
implements ISerializable {
    private final /* synthetic */ String val$VIN;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMasterControlReplyProxy this$0;

    ASIHMISyncMasterControlReplyProxy$7(ASIHMISyncMasterControlReplyProxy aSIHMISyncMasterControlReplyProxy, String string, boolean bl) {
        this.this$0 = aSIHMISyncMasterControlReplyProxy;
        this.val$VIN = string;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$VIN);
        iSerializer.putBool(this.val$isValid);
    }
}

