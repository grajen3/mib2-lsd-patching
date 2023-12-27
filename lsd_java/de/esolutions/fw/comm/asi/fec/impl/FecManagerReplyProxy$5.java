/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.SFecHistory;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy;
import de.esolutions.fw.comm.asi.fec.impl.SFecHistorySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class FecManagerReplyProxy$5
implements ISerializable {
    private final /* synthetic */ SFecHistory[] val$history;
    private final /* synthetic */ FecManagerReplyProxy this$0;

    FecManagerReplyProxy$5(FecManagerReplyProxy fecManagerReplyProxy, SFecHistory[] sFecHistoryArray) {
        this.this$0 = fecManagerReplyProxy;
        this.val$history = sFecHistoryArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SFecHistorySerializer.putOptionalSFecHistoryVarArray(iSerializer, this.val$history);
    }
}

