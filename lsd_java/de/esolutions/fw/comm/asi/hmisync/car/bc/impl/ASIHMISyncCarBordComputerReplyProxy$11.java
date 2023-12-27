/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.impl.FloatBaseTypeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarBordComputerReplyProxy$11
implements ISerializable {
    private final /* synthetic */ FloatBaseType val$BCLongTermAverageConsumption2;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarBordComputerReplyProxy this$0;

    ASIHMISyncCarBordComputerReplyProxy$11(ASIHMISyncCarBordComputerReplyProxy aSIHMISyncCarBordComputerReplyProxy, FloatBaseType floatBaseType, boolean bl) {
        this.this$0 = aSIHMISyncCarBordComputerReplyProxy;
        this.val$BCLongTermAverageConsumption2 = floatBaseType;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        FloatBaseTypeSerializer.putOptionalFloatBaseType(iSerializer, this.val$BCLongTermAverageConsumption2);
        iSerializer.putBool(this.val$isValid);
    }
}

