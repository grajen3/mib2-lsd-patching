/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class PictureStoreReplyProxy$9
implements ISerializable {
    private final /* synthetic */ ResourceLocator val$sourceRL;
    private final /* synthetic */ ResourceLocator val$changedRL;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$9(PictureStoreReplyProxy pictureStoreReplyProxy, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$sourceRL = resourceLocator;
        this.val$changedRL = resourceLocator2;
        this.val$resultCode = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$sourceRL);
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$changedRL);
        iSerializer.putEnum(this.val$resultCode);
    }
}

