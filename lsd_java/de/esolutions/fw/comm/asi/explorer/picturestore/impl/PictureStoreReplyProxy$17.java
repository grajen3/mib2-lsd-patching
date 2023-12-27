/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.comm.dsi.picturestore.impl.GeoPictureSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.picturestore.GeoPicture;

class PictureStoreReplyProxy$17
implements ISerializable {
    private final /* synthetic */ GeoPicture[] val$geoPictures;
    private final /* synthetic */ PictureStoreReplyProxy this$0;

    PictureStoreReplyProxy$17(PictureStoreReplyProxy pictureStoreReplyProxy, GeoPicture[] geoPictureArray) {
        this.this$0 = pictureStoreReplyProxy;
        this.val$geoPictures = geoPictureArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        GeoPictureSerializer.putOptionalGeoPictureVarArray(iSerializer, this.val$geoPictures);
    }
}

