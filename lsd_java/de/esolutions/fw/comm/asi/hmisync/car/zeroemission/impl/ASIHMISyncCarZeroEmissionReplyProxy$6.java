/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ZeroEmissionEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarZeroEmissionReplyProxy$6
implements ISerializable {
    private final /* synthetic */ ZeroEmissionEntry val$CurrentZeroEmissionValue;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarZeroEmissionReplyProxy this$0;

    ASIHMISyncCarZeroEmissionReplyProxy$6(ASIHMISyncCarZeroEmissionReplyProxy aSIHMISyncCarZeroEmissionReplyProxy, ZeroEmissionEntry zeroEmissionEntry, boolean bl) {
        this.this$0 = aSIHMISyncCarZeroEmissionReplyProxy;
        this.val$CurrentZeroEmissionValue = zeroEmissionEntry;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ZeroEmissionEntrySerializer.putOptionalZeroEmissionEntry(iSerializer, this.val$CurrentZeroEmissionValue);
        iSerializer.putBool(this.val$isValid);
    }
}

