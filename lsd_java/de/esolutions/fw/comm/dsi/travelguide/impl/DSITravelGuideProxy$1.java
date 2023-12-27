/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.travelguide.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.travelguide.impl.DSITravelGuideProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSITravelGuideProxy$1
implements ISerializable {
    private final /* synthetic */ ResourceLocator val$resourceLocator;
    private final /* synthetic */ DSITravelGuideProxy this$0;

    DSITravelGuideProxy$1(DSITravelGuideProxy dSITravelGuideProxy, ResourceLocator resourceLocator) {
        this.this$0 = dSITravelGuideProxy;
        this.val$resourceLocator = resourceLocator;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$resourceLocator);
    }
}

