/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class PictureStoreProxy$4
implements ISerializable {
    private final /* synthetic */ ResourceLocator val$rl;
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ PictureStoreProxy this$0;

    PictureStoreProxy$4(PictureStoreProxy pictureStoreProxy, ResourceLocator resourceLocator, int n) {
        this.this$0 = pictureStoreProxy;
        this.val$rl = resourceLocator;
        this.val$contextID = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$rl);
        iSerializer.putInt32(this.val$contextID);
    }
}

