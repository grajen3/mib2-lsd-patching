/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;

class DSINavigationProxy$25
implements ISerializable {
    private final /* synthetic */ NavLocationWgs84[] val$navLocations;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$25(DSINavigationProxy dSINavigationProxy, NavLocationWgs84[] navLocationWgs84Array) {
        this.this$0 = dSINavigationProxy;
        this.val$navLocations = navLocationWgs84Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationWgs84Serializer.putOptionalNavLocationWgs84VarArray(iSerializer, this.val$navLocations);
    }
}

