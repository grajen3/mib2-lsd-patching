/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncHeadUnitReplyProxy$15
implements ISerializable {
    private final /* synthetic */ int[] val$ExtCarConfiguration;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncHeadUnitReplyProxy this$0;

    ASIHMISyncHeadUnitReplyProxy$15(ASIHMISyncHeadUnitReplyProxy aSIHMISyncHeadUnitReplyProxy, int[] nArray, boolean bl) {
        this.this$0 = aSIHMISyncHeadUnitReplyProxy;
        this.val$ExtCarConfiguration = nArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt32VarArray(this.val$ExtCarConfiguration);
        iSerializer.putBool(this.val$isValid);
    }
}

