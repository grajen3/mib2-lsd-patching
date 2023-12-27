/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSINavigationProxy$12
implements ISerializable {
    private final /* synthetic */ NavLocation val$street;
    private final /* synthetic */ String val$nameOfEntry;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$12(DSINavigationProxy dSINavigationProxy, NavLocation navLocation, String string) {
        this.this$0 = dSINavigationProxy;
        this.val$street = navLocation;
        this.val$nameOfEntry = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$street);
        iSerializer.putOptionalString(this.val$nameOfEntry);
    }
}

