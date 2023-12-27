/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureViewerProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIPictureViewerProxy$1
implements ISerializable {
    private final /* synthetic */ ResourceLocator val$picture;
    private final /* synthetic */ int val$animationMode;
    private final /* synthetic */ DSIPictureViewerProxy this$0;

    DSIPictureViewerProxy$1(DSIPictureViewerProxy dSIPictureViewerProxy, ResourceLocator resourceLocator, int n) {
        this.this$0 = dSIPictureViewerProxy;
        this.val$picture = resourceLocator;
        this.val$animationMode = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$picture);
        iSerializer.putInt32(this.val$animationMode);
    }
}

