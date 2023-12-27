/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.impl.IntBaseTypeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarBordComputerReplyProxy$13
implements ISerializable {
    private final /* synthetic */ IntBaseType val$BCCurrentRange1;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarBordComputerReplyProxy this$0;

    ASIHMISyncCarBordComputerReplyProxy$13(ASIHMISyncCarBordComputerReplyProxy aSIHMISyncCarBordComputerReplyProxy, IntBaseType intBaseType, boolean bl) {
        this.this$0 = aSIHMISyncCarBordComputerReplyProxy;
        this.val$BCCurrentRange1 = intBaseType;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        IntBaseTypeSerializer.putOptionalIntBaseType(iSerializer, this.val$BCCurrentRange1);
        iSerializer.putBool(this.val$isValid);
    }
}

