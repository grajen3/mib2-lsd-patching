/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app.impl;

import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IOocApplicationReplyProxy$6
implements ISerializable {
    private final /* synthetic */ boolean val$carLockSignal;
    private final /* synthetic */ IOocApplicationReplyProxy this$0;

    IOocApplicationReplyProxy$6(IOocApplicationReplyProxy iOocApplicationReplyProxy, boolean bl) {
        this.this$0 = iOocApplicationReplyProxy;
        this.val$carLockSignal = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$carLockSignal);
    }
}

