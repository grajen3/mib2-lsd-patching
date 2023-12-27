/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PictureStoreReplyProxy$21
implements ISerializable {
    private final /* synthetic */ int val$sourceFilterSetID;
    private final /* synthetic */ int val$newFilterSetID;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$21(PictureStoreReplyProxy pictureStoreReplyProxy, int n, int n2) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$sourceFilterSetID = n;
        this.val$newFilterSetID = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$sourceFilterSetID);
        iSerializer.putInt32(this.val$newFilterSetID);
    }
}

