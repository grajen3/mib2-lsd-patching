/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavSegmentIDSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavSegmentID;

class DSINavigationProxy$31
implements ISerializable {
    private final /* synthetic */ NavSegmentID val$uidOfCalculatedRoute;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$31(DSINavigationProxy dSINavigationProxy, NavSegmentID navSegmentID) {
        this.this$0 = dSINavigationProxy;
        this.val$uidOfCalculatedRoute = navSegmentID;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavSegmentIDSerializer.putOptionalNavSegmentID(iSerializer, this.val$uidOfCalculatedRoute);
    }
}

