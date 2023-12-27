/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.TryMatchLocationDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.TryMatchLocationData;

class DSINavigationProxy$34
implements ISerializable {
    private final /* synthetic */ TryMatchLocationData val$tmLocation;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$34(DSINavigationProxy dSINavigationProxy, TryMatchLocationData tryMatchLocationData) {
        this.this$0 = dSINavigationProxy;
        this.val$tmLocation = tryMatchLocationData;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        TryMatchLocationDataSerializer.putOptionalTryMatchLocationData(iSerializer, this.val$tmLocation);
    }
}

