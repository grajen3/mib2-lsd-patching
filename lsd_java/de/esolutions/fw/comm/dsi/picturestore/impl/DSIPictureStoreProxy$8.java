/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIPictureStoreProxy$8
implements ISerializable {
    private final /* synthetic */ ResourceLocator val$rl;
    private final /* synthetic */ DSIPictureStoreProxy this$0;

    DSIPictureStoreProxy$8(DSIPictureStoreProxy dSIPictureStoreProxy, ResourceLocator resourceLocator) {
        this.this$0 = dSIPictureStoreProxy;
        this.val$rl = resourceLocator;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$rl);
    }
}

