/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.PictureAttributeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.PictureAttribute;

class PictureStoreReplyProxy$12
implements ISerializable {
    private final /* synthetic */ ResourceLocator val$rl;
    private final /* synthetic */ PictureAttribute[] val$attributes;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$12(PictureStoreReplyProxy pictureStoreReplyProxy, ResourceLocator resourceLocator, PictureAttribute[] pictureAttributeArray, int n) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$rl = resourceLocator;
        this.val$attributes = pictureAttributeArray;
        this.val$resultCode = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$rl);
        PictureAttributeSerializer.putOptionalPictureAttributeVarArray(iSerializer, this.val$attributes);
        iSerializer.putInt32(this.val$resultCode);
    }
}

