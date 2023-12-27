/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class PictureStoreReplyProxy$4
implements ISerializable {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ ResourceLocator val$volatileRL;
    private final /* synthetic */ ResourceLocator val$persistentRL;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ long val$synchronizationID;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$4(PictureStoreReplyProxy pictureStoreReplyProxy, int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2, long l) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$contextID = n;
        this.val$volatileRL = resourceLocator;
        this.val$persistentRL = resourceLocator2;
        this.val$resultCode = n2;
        this.val$synchronizationID = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$contextID);
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$volatileRL);
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$persistentRL);
        iSerializer.putEnum(this.val$resultCode);
        iSerializer.putInt64(this.val$synchronizationID);
    }
}

