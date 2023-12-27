/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class PictureStoreReplyProxy$13
implements ISerializable {
    private final /* synthetic */ ResourceLocator[] val$rls;
    private final /* synthetic */ int val$index;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$13(PictureStoreReplyProxy pictureStoreReplyProxy, ResourceLocator[] resourceLocatorArray, int n) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$rls = resourceLocatorArray;
        this.val$index = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, this.val$rls);
        iSerializer.putInt32(this.val$index);
    }
}

