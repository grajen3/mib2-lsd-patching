/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMasterControlReplyProxy$4
implements ISerializable {
    private final /* synthetic */ short[] val$RequestIDs;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMasterControlReplyProxy this$0;

    ASIHMISyncMasterControlReplyProxy$4(ASIHMISyncMasterControlReplyProxy aSIHMISyncMasterControlReplyProxy, short[] sArray, boolean bl) {
        this.this$0 = aSIHMISyncMasterControlReplyProxy;
        this.val$RequestIDs = sArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt16VarArray(this.val$RequestIDs);
        iSerializer.putBool(this.val$isValid);
    }
}

