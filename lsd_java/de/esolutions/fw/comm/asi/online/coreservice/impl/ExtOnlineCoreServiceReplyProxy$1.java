/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ExtOnlineCoreServiceReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$1(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, int n) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$result = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$result);
    }
}

