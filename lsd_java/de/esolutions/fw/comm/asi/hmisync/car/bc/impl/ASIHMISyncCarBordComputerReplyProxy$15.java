/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.impl.IntBaseTypeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarBordComputerReplyProxy$15
implements ISerializable {
    private final /* synthetic */ IntBaseType val$BCCurrentRange2;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarBordComputerReplyProxy this$0;

    ASIHMISyncCarBordComputerReplyProxy$15(ASIHMISyncCarBordComputerReplyProxy aSIHMISyncCarBordComputerReplyProxy, IntBaseType intBaseType, boolean bl) {
        this.this$0 = aSIHMISyncCarBordComputerReplyProxy;
        this.val$BCCurrentRange2 = intBaseType;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        IntBaseTypeSerializer.putOptionalIntBaseType(iSerializer, this.val$BCCurrentRange2);
        iSerializer.putBool(this.val$isValid);
    }
}

