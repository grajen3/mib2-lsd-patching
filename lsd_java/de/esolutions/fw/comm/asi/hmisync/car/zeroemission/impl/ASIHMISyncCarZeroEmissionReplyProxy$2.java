/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarZeroEmissionReplyProxy$2
implements ISerializable {
    private final /* synthetic */ short[] val$RequestIDs;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarZeroEmissionReplyProxy this$0;

    ASIHMISyncCarZeroEmissionReplyProxy$2(ASIHMISyncCarZeroEmissionReplyProxy aSIHMISyncCarZeroEmissionReplyProxy, short[] sArray, boolean bl) {
        this.this$0 = aSIHMISyncCarZeroEmissionReplyProxy;
        this.val$RequestIDs = sArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt16VarArray(this.val$RequestIDs);
        iSerializer.putBool(this.val$isValid);
    }
}

