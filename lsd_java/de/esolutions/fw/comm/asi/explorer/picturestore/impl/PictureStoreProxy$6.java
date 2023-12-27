/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class PictureStoreProxy$6
implements ISerializable {
    private final /* synthetic */ ResourceLocator val$rl;
    private final /* synthetic */ PictureStoreProxy this$0;

    PictureStoreProxy$6(PictureStoreProxy pictureStoreProxy, ResourceLocator resourceLocator) {
        this.this$0 = pictureStoreProxy;
        this.val$rl = resourceLocator;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$rl);
    }
}

