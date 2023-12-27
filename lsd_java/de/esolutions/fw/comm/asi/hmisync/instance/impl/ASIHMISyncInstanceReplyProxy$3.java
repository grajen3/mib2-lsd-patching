/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncInstanceReplyProxy$3
implements ISerializable {
    private final /* synthetic */ short[] val$RequestIDs;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncInstanceReplyProxy this$0;

    ASIHMISyncInstanceReplyProxy$3(ASIHMISyncInstanceReplyProxy aSIHMISyncInstanceReplyProxy, short[] sArray, boolean bl) {
        this.this$0 = aSIHMISyncInstanceReplyProxy;
        this.val$RequestIDs = sArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt16VarArray(this.val$RequestIDs);
        iSerializer.putBool(this.val$isValid);
    }
}

