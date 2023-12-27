/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PictureStoreReplyProxy$5
implements ISerializable {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ long val$synchronizationID;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$5(PictureStoreReplyProxy pictureStoreReplyProxy, int n, long l) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$contextID = n;
        this.val$synchronizationID = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$contextID);
        iSerializer.putInt64(this.val$synchronizationID);
    }
}

