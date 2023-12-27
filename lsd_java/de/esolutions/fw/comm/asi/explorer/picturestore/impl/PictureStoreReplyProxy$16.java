/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class PictureStoreReplyProxy$16
implements ISerializable {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ ResourceLocator[] val$rls;
    private final /* synthetic */ int val$index;
    private final /* synthetic */ float val$targetLatitude;
    private final /* synthetic */ float val$targetLongitude;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$16(PictureStoreReplyProxy pictureStoreReplyProxy, int n, ResourceLocator[] resourceLocatorArray, int n2, float f2, float f3) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$contextID = n;
        this.val$rls = resourceLocatorArray;
        this.val$index = n2;
        this.val$targetLatitude = f2;
        this.val$targetLongitude = f3;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$contextID);
        ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, this.val$rls);
        iSerializer.putInt32(this.val$index);
        iSerializer.putFloat(this.val$targetLatitude);
        iSerializer.putFloat(this.val$targetLongitude);
    }
}

