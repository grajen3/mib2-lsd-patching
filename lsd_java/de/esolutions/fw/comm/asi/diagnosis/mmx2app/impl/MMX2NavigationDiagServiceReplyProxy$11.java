/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceReplyProxy$11
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ MMX2NavigationDiagServiceReplyProxy this$0;

    MMX2NavigationDiagServiceReplyProxy$11(MMX2NavigationDiagServiceReplyProxy mMX2NavigationDiagServiceReplyProxy, long l) {
        this.this$0 = mMX2NavigationDiagServiceReplyProxy;
        this.val$msg_id = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
    }
}

