/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app.impl;

import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IOocApplicationReplyProxy$1
implements ISerializable {
    private final /* synthetic */ long val$power_state;
    private final /* synthetic */ IOocApplicationReplyProxy this$0;

    IOocApplicationReplyProxy$1(IOocApplicationReplyProxy iOocApplicationReplyProxy, long l) {
        this.this$0 = iOocApplicationReplyProxy;
        this.val$power_state = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$power_state);
    }
}

