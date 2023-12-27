/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavSegmentIDSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavSegmentID;

class DSINavigationProxy$28
implements ISerializable {
    private final /* synthetic */ NavSegmentID val$traceId;
    private final /* synthetic */ String val$name;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$28(DSINavigationProxy dSINavigationProxy, NavSegmentID navSegmentID, String string) {
        this.this$0 = dSINavigationProxy;
        this.val$traceId = navSegmentID;
        this.val$name = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavSegmentIDSerializer.putOptionalNavSegmentID(iSerializer, this.val$traceId);
        iSerializer.putOptionalString(this.val$name);
    }
}

