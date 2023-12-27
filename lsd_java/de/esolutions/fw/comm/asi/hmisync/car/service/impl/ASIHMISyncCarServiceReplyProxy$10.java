/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.SIAServiceDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$10
implements ISerializable {
    private final /* synthetic */ SIAServiceData val$SIAServiceData;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$10(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, SIAServiceData sIAServiceData, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$SIAServiceData = sIAServiceData;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SIAServiceDataSerializer.putOptionalSIAServiceData(iSerializer, this.val$SIAServiceData);
        iSerializer.putBool(this.val$isValid);
    }
}

