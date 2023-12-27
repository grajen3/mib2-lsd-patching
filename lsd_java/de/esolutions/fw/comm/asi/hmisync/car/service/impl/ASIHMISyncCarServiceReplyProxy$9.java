/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$9
implements ISerializable {
    private final /* synthetic */ int[] val$SIAOilInspectionVisibilityState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$9(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, int[] nArray, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$SIAOilInspectionVisibilityState = nArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt32VarArray(this.val$SIAOilInspectionVisibilityState);
        iSerializer.putBool(this.val$isValid);
    }
}

