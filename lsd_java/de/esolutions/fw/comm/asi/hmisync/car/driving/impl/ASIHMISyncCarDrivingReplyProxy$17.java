/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarDrivingReplyProxy$17
implements ISerializable {
    private final /* synthetic */ int val$DriveSelectActiveProfileVisibilityState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarDrivingReplyProxy this$0;

    ASIHMISyncCarDrivingReplyProxy$17(ASIHMISyncCarDrivingReplyProxy aSIHMISyncCarDrivingReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncCarDrivingReplyProxy;
        this.val$DriveSelectActiveProfileVisibilityState = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$DriveSelectActiveProfileVisibilityState);
        iSerializer.putBool(this.val$isValid);
    }
}

