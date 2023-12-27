/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSINavigationProxy$40
implements ISerializable {
    private final /* synthetic */ NavLocation val$position;
    private final /* synthetic */ int val$mode;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$40(DSINavigationProxy dSINavigationProxy, NavLocation navLocation, int n) {
        this.this$0 = dSINavigationProxy;
        this.val$position = navLocation;
        this.val$mode = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$position);
        iSerializer.putInt32(this.val$mode);
    }
}

