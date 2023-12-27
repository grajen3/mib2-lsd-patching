/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturehandling.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturehandling.impl.DSIPictureHandlingProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIPictureHandlingProxy$1
implements ISerializable {
    private final /* synthetic */ int val$requestHandle;
    private final /* synthetic */ ResourceLocator[] val$resourceLocators;
    private final /* synthetic */ int val$pictureConfigUseCase;
    private final /* synthetic */ DSIPictureHandlingProxy this$0;

    DSIPictureHandlingProxy$1(DSIPictureHandlingProxy dSIPictureHandlingProxy, int n, ResourceLocator[] resourceLocatorArray, int n2) {
        this.this$0 = dSIPictureHandlingProxy;
        this.val$requestHandle = n;
        this.val$resourceLocators = resourceLocatorArray;
        this.val$pictureConfigUseCase = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$requestHandle);
        ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, this.val$resourceLocators);
        iSerializer.putInt32(this.val$pictureConfigUseCase);
    }
}

