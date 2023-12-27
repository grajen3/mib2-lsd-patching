/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarZeroEmissionReplyProxy$4
implements ISerializable {
    private final /* synthetic */ int val$ZEVisibilityState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarZeroEmissionReplyProxy this$0;

    ASIHMISyncCarZeroEmissionReplyProxy$4(ASIHMISyncCarZeroEmissionReplyProxy aSIHMISyncCarZeroEmissionReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncCarZeroEmissionReplyProxy;
        this.val$ZEVisibilityState = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$ZEVisibilityState);
        iSerializer.putBool(this.val$isValid);
    }
}

