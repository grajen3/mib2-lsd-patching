/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarDrivingReplyProxy$15
implements ISerializable {
    private final /* synthetic */ int[] val$SuspensionVisibilityState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarDrivingReplyProxy this$0;

    ASIHMISyncCarDrivingReplyProxy$15(ASIHMISyncCarDrivingReplyProxy aSIHMISyncCarDrivingReplyProxy, int[] nArray, boolean bl) {
        this.this$0 = aSIHMISyncCarDrivingReplyProxy;
        this.val$SuspensionVisibilityState = nArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt32VarArray(this.val$SuspensionVisibilityState);
        iSerializer.putBool(this.val$isValid);
    }
}

