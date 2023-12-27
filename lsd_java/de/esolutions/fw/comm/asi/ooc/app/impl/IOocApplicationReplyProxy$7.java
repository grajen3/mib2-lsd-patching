/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app.impl;

import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IOocApplicationReplyProxy$7
implements ISerializable {
    private final /* synthetic */ boolean val$powerOnPinStatus;
    private final /* synthetic */ IOocApplicationReplyProxy this$0;

    IOocApplicationReplyProxy$7(IOocApplicationReplyProxy iOocApplicationReplyProxy, boolean bl) {
        this.this$0 = iOocApplicationReplyProxy;
        this.val$powerOnPinStatus = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$powerOnPinStatus);
    }
}

