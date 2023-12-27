/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.SFecImportStatus;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy;
import de.esolutions.fw.comm.asi.fec.impl.SFecImportStatusSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class FecManagerReplyProxy$3
implements ISerializable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ SFecImportStatus[] val$report;
    private final /* synthetic */ FecManagerReplyProxy this$0;

    FecManagerReplyProxy$3(FecManagerReplyProxy fecManagerReplyProxy, int n, SFecImportStatus[] sFecImportStatusArray) {
        this.this$0 = fecManagerReplyProxy;
        this.val$result = n;
        this.val$report = sFecImportStatusArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$result);
        SFecImportStatusSerializer.putOptionalSFecImportStatusVarArray(iSerializer, this.val$report);
    }
}

