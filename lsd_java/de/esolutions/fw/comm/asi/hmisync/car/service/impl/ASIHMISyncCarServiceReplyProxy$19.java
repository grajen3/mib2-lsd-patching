/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$19
implements ISerializable {
    private final /* synthetic */ int val$VehicleSpeedVisibility;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$19(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$VehicleSpeedVisibility = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$VehicleSpeedVisibility);
        iSerializer.putBool(this.val$isValid);
    }
}

