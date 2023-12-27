/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PictureStoreReplyProxy$23
implements ISerializable {
    private final /* synthetic */ int val$contextId;
    private final /* synthetic */ String[] val$folderNames;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$23(PictureStoreReplyProxy pictureStoreReplyProxy, int n, String[] stringArray) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$contextId = n;
        this.val$folderNames = stringArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$contextId);
        iSerializer.putOptionalStringVarArray(this.val$folderNames);
    }
}

