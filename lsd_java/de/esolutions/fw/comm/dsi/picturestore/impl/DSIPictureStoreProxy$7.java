/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIPictureStoreProxy$7
implements ISerializable {
    private final /* synthetic */ ResourceLocator[] val$rls;
    private final /* synthetic */ boolean val$force;
    private final /* synthetic */ DSIPictureStoreProxy this$0;

    DSIPictureStoreProxy$7(DSIPictureStoreProxy dSIPictureStoreProxy, ResourceLocator[] resourceLocatorArray, boolean bl) {
        this.this$0 = dSIPictureStoreProxy;
        this.val$rls = resourceLocatorArray;
        this.val$force = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, this.val$rls);
        iSerializer.putBool(this.val$force);
    }
}

