/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PictureStoreReplyProxy$11
implements ISerializable {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ long val$deletedSynchronizationID;
    private final /* synthetic */ long val$newSynchronizationID;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$11(PictureStoreReplyProxy pictureStoreReplyProxy, int n, long l, long l2, int n2) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$contextID = n;
        this.val$deletedSynchronizationID = l;
        this.val$newSynchronizationID = l2;
        this.val$result = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$contextID);
        iSerializer.putInt64(this.val$deletedSynchronizationID);
        iSerializer.putInt64(this.val$newSynchronizationID);
        iSerializer.putEnum(this.val$result);
    }
}

