/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.SFecDetails;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy;
import de.esolutions.fw.comm.asi.fec.impl.SFecDetailsSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class FecManagerReplyProxy$2
implements ISerializable {
    private final /* synthetic */ SFecDetails val$fecDetails;
    private final /* synthetic */ FecManagerReplyProxy this$0;

    FecManagerReplyProxy$2(FecManagerReplyProxy fecManagerReplyProxy, SFecDetails sFecDetails) {
        this.this$0 = fecManagerReplyProxy;
        this.val$fecDetails = sFecDetails;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SFecDetailsSerializer.putOptionalSFecDetails(iSerializer, this.val$fecDetails);
    }
}

