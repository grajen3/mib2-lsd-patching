/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PictureStoreReplyProxy$18
implements ISerializable {
    private final /* synthetic */ int[] val$years;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$18(PictureStoreReplyProxy pictureStoreReplyProxy, int[] nArray) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$years = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt32VarArray(this.val$years);
    }
}

