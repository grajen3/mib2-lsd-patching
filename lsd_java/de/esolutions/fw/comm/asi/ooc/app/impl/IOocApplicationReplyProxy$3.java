/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app.impl;

import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class IOocApplicationReplyProxy$3
implements ISerializable {
    private final /* synthetic */ boolean val$clamp_S;
    private final /* synthetic */ boolean val$clamp_15;
    private final /* synthetic */ boolean val$clamp_X;
    private final /* synthetic */ boolean val$clamp_50;
    private final /* synthetic */ IOocApplicationReplyProxy this$0;

    IOocApplicationReplyProxy$3(IOocApplicationReplyProxy iOocApplicationReplyProxy, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.this$0 = iOocApplicationReplyProxy;
        this.val$clamp_S = bl;
        this.val$clamp_15 = bl2;
        this.val$clamp_X = bl3;
        this.val$clamp_50 = bl4;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$clamp_S);
        iSerializer.putBool(this.val$clamp_15);
        iSerializer.putBool(this.val$clamp_X);
        iSerializer.putBool(this.val$clamp_50);
    }
}

