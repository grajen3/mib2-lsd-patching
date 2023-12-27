/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class PictureStoreReplyProxy$7
implements ISerializable {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ String val$oldFolderName;
    private final /* synthetic */ String val$newFolderName;
    private final /* synthetic */ long val$synchronizationID;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$7(PictureStoreReplyProxy pictureStoreReplyProxy, int n, String string, String string2, long l, int n2) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$contextID = n;
        this.val$oldFolderName = string;
        this.val$newFolderName = string2;
        this.val$synchronizationID = l;
        this.val$resultCode = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$contextID);
        iSerializer.putOptionalString(this.val$oldFolderName);
        iSerializer.putOptionalString(this.val$newFolderName);
        iSerializer.putInt64(this.val$synchronizationID);
        iSerializer.putEnum(this.val$resultCode);
    }
}

