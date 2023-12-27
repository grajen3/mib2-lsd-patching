/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PictureStoreReplyProxy$22
implements ISerializable {
    private final /* synthetic */ int[] val$contextIDs;
    private final /* synthetic */ int val$reason;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$22(PictureStoreReplyProxy pictureStoreReplyProxy, int[] nArray, int n) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$contextIDs = nArray;
        this.val$reason = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt32VarArray(this.val$contextIDs);
        iSerializer.putEnum(this.val$reason);
    }
}

