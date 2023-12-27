/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.KeySetSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncTVReplyProxy$8
implements ISerializable {
    private final /* synthetic */ KeySet[] val$PanelKeySet;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncTVReplyProxy this$0;

    ASIHMISyncTVReplyProxy$8(ASIHMISyncTVReplyProxy aSIHMISyncTVReplyProxy, KeySet[] keySetArray, boolean bl) {
        this.this$0 = aSIHMISyncTVReplyProxy;
        this.val$PanelKeySet = keySetArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        KeySetSerializer.putOptionalKeySetVarArray(iSerializer, this.val$PanelKeySet);
        iSerializer.putBool(this.val$isValid);
    }
}

