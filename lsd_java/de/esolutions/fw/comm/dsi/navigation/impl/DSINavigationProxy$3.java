/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSINavigationProxy$3
implements ISerializable {
    private final /* synthetic */ long val$destID;
    private final /* synthetic */ NavLocation val$destination;
    private final /* synthetic */ String val$title;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$3(DSINavigationProxy dSINavigationProxy, long l, NavLocation navLocation, String string) {
        this.this$0 = dSINavigationProxy;
        this.val$destID = l;
        this.val$destination = navLocation;
        this.val$title = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt64(this.val$destID);
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$destination);
        iSerializer.putOptionalString(this.val$title);
    }
}

