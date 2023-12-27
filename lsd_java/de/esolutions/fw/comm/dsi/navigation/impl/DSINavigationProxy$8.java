/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSINavigationProxy$8
implements ISerializable {
    private final /* synthetic */ NavLocation val$state;
    private final /* synthetic */ boolean val$hasCities;
    private final /* synthetic */ String val$nameofEntry;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$8(DSINavigationProxy dSINavigationProxy, NavLocation navLocation, boolean bl, String string) {
        this.this$0 = dSINavigationProxy;
        this.val$state = navLocation;
        this.val$hasCities = bl;
        this.val$nameofEntry = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$state);
        iSerializer.putBool(this.val$hasCities);
        iSerializer.putOptionalString(this.val$nameofEntry);
    }
}

