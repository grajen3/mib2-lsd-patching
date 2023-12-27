/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$6
implements ISerializable {
    private final /* synthetic */ short[] val$RequestIDs;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$6(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, short[] sArray, boolean bl) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$RequestIDs = sArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt16VarArray(this.val$RequestIDs);
        iSerializer.putBool(this.val$isValid);
    }
}

