/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.SIAOilInspectionSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$8
implements ISerializable {
    private final /* synthetic */ SIAOilInspection val$SIAOilInspection;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$8(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, SIAOilInspection sIAOilInspection, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$SIAOilInspection = sIAOilInspection;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SIAOilInspectionSerializer.putOptionalSIAOilInspection(iSerializer, this.val$SIAOilInspection);
        iSerializer.putBool(this.val$isValid);
    }
}

