/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class PictureStoreProxy$5
implements ISerializable {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ ResourceLocator[] val$rls;
    private final /* synthetic */ boolean val$force;
    private final /* synthetic */ PictureStoreProxy this$0;

    PictureStoreProxy$5(PictureStoreProxy pictureStoreProxy, int n, ResourceLocator[] resourceLocatorArray, boolean bl) {
        this.this$0 = pictureStoreProxy;
        this.val$contextID = n;
        this.val$rls = resourceLocatorArray;
        this.val$force = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$contextID);
        ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, this.val$rls);
        iSerializer.putBool(this.val$force);
    }
}

