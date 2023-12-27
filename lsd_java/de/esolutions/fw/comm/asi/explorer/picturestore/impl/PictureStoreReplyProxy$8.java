/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PictureStoreReplyProxy$8
implements ISerializable {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ int val$filterSetID;
    private final /* synthetic */ int val$count;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$8(PictureStoreReplyProxy pictureStoreReplyProxy, int n, int n2, int n3) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$contextID = n;
        this.val$filterSetID = n2;
        this.val$count = n3;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$contextID);
        iSerializer.putInt32(this.val$filterSetID);
        iSerializer.putInt32(this.val$count);
    }
}

