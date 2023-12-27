/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$11
implements ISerializable {
    private final /* synthetic */ int val$SIAServiceDataVisibilityState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$11(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$SIAServiceDataVisibilityState = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$SIAServiceDataVisibilityState);
        iSerializer.putBool(this.val$isValid);
    }
}

