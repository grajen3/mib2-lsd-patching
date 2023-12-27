/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PictureStoreReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$1(PictureStoreReplyProxy pictureStoreReplyProxy, int n) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$resultCode = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$resultCode);
    }
}

