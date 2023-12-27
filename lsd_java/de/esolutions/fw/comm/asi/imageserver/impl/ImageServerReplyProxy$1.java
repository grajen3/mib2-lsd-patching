/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver.impl;

import de.esolutions.fw.comm.asi.imageserver.Image;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageSerializer;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageServerReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ImageServerReplyProxy$1
implements ISerializable {
    private final /* synthetic */ String val$resourceLocator;
    private final /* synthetic */ Image val$image;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ ImageServerReplyProxy this$0;

    ImageServerReplyProxy$1(ImageServerReplyProxy imageServerReplyProxy, String string, Image image, int n) {
        this.this$0 = imageServerReplyProxy;
        this.val$resourceLocator = string;
        this.val$image = image;
        this.val$result = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$resourceLocator);
        ImageSerializer.putOptionalImage(iSerializer, this.val$image);
        iSerializer.putEnum(this.val$result);
    }
}

