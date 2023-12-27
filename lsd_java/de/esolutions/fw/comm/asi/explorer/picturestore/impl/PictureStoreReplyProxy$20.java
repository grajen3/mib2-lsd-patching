/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PictureStoreReplyProxy$20
implements ISerializable {
    private final /* synthetic */ int val$filterSetID;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$20(PictureStoreReplyProxy pictureStoreReplyProxy, int n) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$filterSetID = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$filterSetID);
    }
}

