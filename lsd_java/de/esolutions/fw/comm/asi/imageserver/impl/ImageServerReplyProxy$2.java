/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver.impl;

import de.esolutions.fw.comm.asi.imageserver.ImageInfo;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageInfoSerializer;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageServerReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ImageServerReplyProxy$2
implements ISerializable {
    private final /* synthetic */ String val$resourceLocator;
    private final /* synthetic */ ImageInfo val$info;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ ImageServerReplyProxy this$0;

    ImageServerReplyProxy$2(ImageServerReplyProxy imageServerReplyProxy, String string, ImageInfo imageInfo, int n) {
        this.this$0 = imageServerReplyProxy;
        this.val$resourceLocator = string;
        this.val$info = imageInfo;
        this.val$result = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$resourceLocator);
        ImageInfoSerializer.putOptionalImageInfo(iSerializer, this.val$info);
        iSerializer.putEnum(this.val$result);
    }
}

