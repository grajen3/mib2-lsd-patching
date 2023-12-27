/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.OilLevelDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$4
implements ISerializable {
    private final /* synthetic */ OilLevelData val$OilLevelData;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$4(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, OilLevelData oilLevelData, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$OilLevelData = oilLevelData;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        OilLevelDataSerializer.putOptionalOilLevelData(iSerializer, this.val$OilLevelData);
        iSerializer.putBool(this.val$isValid);
    }
}

