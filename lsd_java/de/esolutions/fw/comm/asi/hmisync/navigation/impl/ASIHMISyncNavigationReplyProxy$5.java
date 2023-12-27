/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncNavigationReplyProxy$5
implements ISerializable {
    private final /* synthetic */ boolean val$RouteGuidanceActive;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncNavigationReplyProxy this$0;

    ASIHMISyncNavigationReplyProxy$5(ASIHMISyncNavigationReplyProxy aSIHMISyncNavigationReplyProxy, boolean bl, boolean bl2) {
        this.this$0 = aSIHMISyncNavigationReplyProxy;
        this.val$RouteGuidanceActive = bl;
        this.val$isValid = bl2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$RouteGuidanceActive);
        iSerializer.putBool(this.val$isValid);
    }
}

