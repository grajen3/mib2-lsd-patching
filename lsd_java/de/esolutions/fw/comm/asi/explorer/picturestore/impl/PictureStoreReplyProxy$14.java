/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class PictureStoreReplyProxy$14
implements ISerializable {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ ResourceLocator[] val$rls;
    private final /* synthetic */ int val$index;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$14(PictureStoreReplyProxy pictureStoreReplyProxy, int n, ResourceLocator[] resourceLocatorArray, int n2) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$contextID = n;
        this.val$rls = resourceLocatorArray;
        this.val$index = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$contextID);
        ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, this.val$rls);
        iSerializer.putInt32(this.val$index);
    }
}

