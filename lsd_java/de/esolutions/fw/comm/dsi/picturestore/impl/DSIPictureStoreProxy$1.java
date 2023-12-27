/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIPictureStoreProxy$1
implements ISerializable {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ ResourceLocator val$rl;
    private final /* synthetic */ boolean val$withAutoDelete;
    private final /* synthetic */ DSIPictureStoreProxy this$0;

    DSIPictureStoreProxy$1(DSIPictureStoreProxy dSIPictureStoreProxy, int n, ResourceLocator resourceLocator, boolean bl) {
        this.this$0 = dSIPictureStoreProxy;
        this.val$contextID = n;
        this.val$rl = resourceLocator;
        this.val$withAutoDelete = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$contextID);
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$rl);
        iSerializer.putBool(this.val$withAutoDelete);
    }
}

