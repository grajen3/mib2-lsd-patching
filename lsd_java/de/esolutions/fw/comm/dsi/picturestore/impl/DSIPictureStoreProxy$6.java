/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIPictureStoreProxy$6
implements ISerializable {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ ResourceLocator[] val$rls;
    private final /* synthetic */ boolean val$force;
    private final /* synthetic */ DSIPictureStoreProxy this$0;

    DSIPictureStoreProxy$6(DSIPictureStoreProxy dSIPictureStoreProxy, int n, ResourceLocator[] resourceLocatorArray, boolean bl) {
        this.this$0 = dSIPictureStoreProxy;
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

