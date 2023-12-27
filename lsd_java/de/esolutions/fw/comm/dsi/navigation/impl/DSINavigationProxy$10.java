/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSINavigationProxy$10
implements ISerializable {
    private final /* synthetic */ NavLocation val$city;
    private final /* synthetic */ boolean val$hasStreets;
    private final /* synthetic */ String val$nameofEntry;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$10(DSINavigationProxy dSINavigationProxy, NavLocation navLocation, boolean bl, String string) {
        this.this$0 = dSINavigationProxy;
        this.val$city = navLocation;
        this.val$hasStreets = bl;
        this.val$nameofEntry = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$city);
        iSerializer.putBool(this.val$hasStreets);
        iSerializer.putOptionalString(this.val$nameofEntry);
    }
}

