/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ZeroEmissionEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarZeroEmissionReplyProxy$5
implements ISerializable {
    private final /* synthetic */ ZeroEmissionEntry[] val$ZeroEmissionValues;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarZeroEmissionReplyProxy this$0;

    ASIHMISyncCarZeroEmissionReplyProxy$5(ASIHMISyncCarZeroEmissionReplyProxy aSIHMISyncCarZeroEmissionReplyProxy, ZeroEmissionEntry[] zeroEmissionEntryArray, boolean bl) {
        this.this$0 = aSIHMISyncCarZeroEmissionReplyProxy;
        this.val$ZeroEmissionValues = zeroEmissionEntryArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ZeroEmissionEntrySerializer.putOptionalZeroEmissionEntryVarArray(iSerializer, this.val$ZeroEmissionValues);
        iSerializer.putBool(this.val$isValid);
    }
}

