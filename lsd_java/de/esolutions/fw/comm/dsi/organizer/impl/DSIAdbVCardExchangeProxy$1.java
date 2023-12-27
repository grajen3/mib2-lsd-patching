/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbVCardExchangeProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIAdbVCardExchangeProxy$1
implements ISerializable {
    private final /* synthetic */ ResourceLocator[] val$resourceLocators;
    private final /* synthetic */ int val$destinationProfile;
    private final /* synthetic */ DSIAdbVCardExchangeProxy this$0;

    DSIAdbVCardExchangeProxy$1(DSIAdbVCardExchangeProxy dSIAdbVCardExchangeProxy, ResourceLocator[] resourceLocatorArray, int n) {
        this.this$0 = dSIAdbVCardExchangeProxy;
        this.val$resourceLocators = resourceLocatorArray;
        this.val$destinationProfile = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, this.val$resourceLocators);
        iSerializer.putInt32(this.val$destinationProfile);
    }
}

