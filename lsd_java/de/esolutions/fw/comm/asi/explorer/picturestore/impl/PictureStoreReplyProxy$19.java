/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PictureStoreReplyProxy$19
implements ISerializable {
    private final /* synthetic */ int[] val$months;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$19(PictureStoreReplyProxy pictureStoreReplyProxy, int[] nArray) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$months = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt32VarArray(this.val$months);
    }
}

