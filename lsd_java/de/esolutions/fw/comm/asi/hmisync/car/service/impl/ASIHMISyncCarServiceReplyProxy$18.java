/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$18
implements ISerializable {
    private final /* synthetic */ int val$TireSystem;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$18(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$TireSystem = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$TireSystem);
        iSerializer.putBool(this.val$isValid);
    }
}

