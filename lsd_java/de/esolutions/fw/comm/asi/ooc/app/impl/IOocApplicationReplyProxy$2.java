/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app.impl;

import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IOocApplicationReplyProxy$2
implements ISerializable {
    private final /* synthetic */ int val$type;
    private final /* synthetic */ IOocApplicationReplyProxy this$0;

    IOocApplicationReplyProxy$2(IOocApplicationReplyProxy iOocApplicationReplyProxy, int n) {
        this.this$0 = iOocApplicationReplyProxy;
        this.val$type = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$type);
    }
}

