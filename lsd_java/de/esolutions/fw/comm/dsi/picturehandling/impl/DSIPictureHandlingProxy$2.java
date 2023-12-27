/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturehandling.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturehandling.impl.DSIPictureHandlingProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIPictureHandlingProxy$2
implements ISerializable {
    private final /* synthetic */ ResourceLocator val$rlNew;
    private final /* synthetic */ DSIPictureHandlingProxy this$0;

    DSIPictureHandlingProxy$2(DSIPictureHandlingProxy dSIPictureHandlingProxy, ResourceLocator resourceLocator) {
        this.this$0 = dSIPictureHandlingProxy;
        this.val$rlNew = resourceLocator;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$rlNew);
    }
}

