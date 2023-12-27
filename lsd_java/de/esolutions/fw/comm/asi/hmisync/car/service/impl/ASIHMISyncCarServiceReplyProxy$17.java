/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$17
implements ISerializable {
    private final /* synthetic */ int val$TireDisplayDataVisibilityState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$17(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$TireDisplayDataVisibilityState = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$TireDisplayDataVisibilityState);
        iSerializer.putBool(this.val$isValid);
    }
}

