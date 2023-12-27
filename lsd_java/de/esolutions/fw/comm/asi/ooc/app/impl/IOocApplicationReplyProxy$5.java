/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app.impl;

import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IOocApplicationReplyProxy$5
implements ISerializable {
    private final /* synthetic */ int val$mode;
    private final /* synthetic */ IOocApplicationReplyProxy this$0;

    IOocApplicationReplyProxy$5(IOocApplicationReplyProxy iOocApplicationReplyProxy, int n) {
        this.this$0 = iOocApplicationReplyProxy;
        this.val$mode = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$mode);
    }
}

