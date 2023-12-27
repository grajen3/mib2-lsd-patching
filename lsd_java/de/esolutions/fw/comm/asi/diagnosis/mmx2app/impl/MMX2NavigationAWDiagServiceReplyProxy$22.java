/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceReplyProxy$22
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ int val$action;
    private final /* synthetic */ MMX2NavigationAWDiagServiceReplyProxy this$0;

    MMX2NavigationAWDiagServiceReplyProxy$22(MMX2NavigationAWDiagServiceReplyProxy mMX2NavigationAWDiagServiceReplyProxy, long l, int n) {
        this.this$0 = mMX2NavigationAWDiagServiceReplyProxy;
        this.val$msg_id = l;
        this.val$action = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
        iSerializer.putEnum(this.val$action);
    }
}

