/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.TireDisplayData;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.TireDisplayDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$16
implements ISerializable {
    private final /* synthetic */ TireDisplayData val$TireDisplayData;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$16(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, TireDisplayData tireDisplayData, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$TireDisplayData = tireDisplayData;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        TireDisplayDataSerializer.putOptionalTireDisplayData(iSerializer, this.val$TireDisplayData);
        iSerializer.putBool(this.val$isValid);
    }
}

