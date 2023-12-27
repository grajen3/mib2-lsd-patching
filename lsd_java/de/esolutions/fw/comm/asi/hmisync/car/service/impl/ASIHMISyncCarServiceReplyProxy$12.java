/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$12
implements ISerializable {
    private final /* synthetic */ String val$VinData;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$12(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, String string, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$VinData = string;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$VinData);
        iSerializer.putBool(this.val$isValid);
    }
}

