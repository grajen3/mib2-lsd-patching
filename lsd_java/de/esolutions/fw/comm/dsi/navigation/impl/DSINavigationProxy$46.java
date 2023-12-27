/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.NavPoiInfoConfigurationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;

class DSINavigationProxy$46
implements ISerializable {
    private final /* synthetic */ NavPoiInfoConfiguration val$config;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$46(DSINavigationProxy dSINavigationProxy, NavPoiInfoConfiguration navPoiInfoConfiguration) {
        this.this$0 = dSINavigationProxy;
        this.val$config = navPoiInfoConfiguration;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavPoiInfoConfigurationSerializer.putOptionalNavPoiInfoConfiguration(iSerializer, this.val$config);
    }
}

