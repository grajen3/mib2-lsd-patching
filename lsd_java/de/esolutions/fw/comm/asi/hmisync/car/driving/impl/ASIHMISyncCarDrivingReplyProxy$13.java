/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarDrivingReplyProxy$13
implements ISerializable {
    private final /* synthetic */ int val$SuspensionControlCurrentLevel;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarDrivingReplyProxy this$0;

    ASIHMISyncCarDrivingReplyProxy$13(ASIHMISyncCarDrivingReplyProxy aSIHMISyncCarDrivingReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncCarDrivingReplyProxy;
        this.val$SuspensionControlCurrentLevel = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$SuspensionControlCurrentLevel);
        iSerializer.putBool(this.val$isValid);
    }
}

