/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class PictureStoreProxy$2
implements ISerializable {
    private final /* synthetic */ int val$contextID;
    private final /* synthetic */ ResourceLocator val$rl;
    private final /* synthetic */ boolean val$withAutoDelete;
    private final /* synthetic */ int val$importSource;
    private final /* synthetic */ String val$folderName;
    private final /* synthetic */ long val$synchronizationID;
    private final /* synthetic */ PictureStoreProxy this$0;

    PictureStoreProxy$2(PictureStoreProxy pictureStoreProxy, int n, ResourceLocator resourceLocator, boolean bl, int n2, String string, long l) {
        this.this$0 = pictureStoreProxy;
        this.val$contextID = n;
        this.val$rl = resourceLocator;
        this.val$withAutoDelete = bl;
        this.val$importSource = n2;
        this.val$folderName = string;
        this.val$synchronizationID = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$contextID);
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$rl);
        iSerializer.putBool(this.val$withAutoDelete);
        iSerializer.putEnum(this.val$importSource);
        iSerializer.putOptionalString(this.val$folderName);
        iSerializer.putInt64(this.val$synchronizationID);
    }
}

