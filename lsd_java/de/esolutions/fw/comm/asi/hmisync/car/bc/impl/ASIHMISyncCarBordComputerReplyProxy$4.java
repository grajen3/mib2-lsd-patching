/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarBordComputerReplyProxy$4
implements ISerializable {
    private final /* synthetic */ int val$BCShortTermAverageConsumption1Visibility;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarBordComputerReplyProxy this$0;

    ASIHMISyncCarBordComputerReplyProxy$4(ASIHMISyncCarBordComputerReplyProxy aSIHMISyncCarBordComputerReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncCarBordComputerReplyProxy;
        this.val$BCShortTermAverageConsumption1Visibility = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$BCShortTermAverageConsumption1Visibility);
        iSerializer.putBool(this.val$isValid);
    }
}

