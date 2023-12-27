/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncNavigationReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ ASIHMISyncNavigationReplyProxy this$0;

    ASIHMISyncNavigationReplyProxy$1(ASIHMISyncNavigationReplyProxy aSIHMISyncNavigationReplyProxy, int n) {
        this.this$0 = aSIHMISyncNavigationReplyProxy;
        this.val$resultCode = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$resultCode);
    }
}

