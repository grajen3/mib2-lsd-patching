/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.predictivenavigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.predictivenavigation.impl.DSIPredictiveNavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSIPredictiveNavigationProxy$1
implements ISerializable {
    private final /* synthetic */ NavLocation val$destination;
    private final /* synthetic */ int val$radius;
    private final /* synthetic */ DSIPredictiveNavigationProxy this$0;

    DSIPredictiveNavigationProxy$1(DSIPredictiveNavigationProxy dSIPredictiveNavigationProxy, NavLocation navLocation, int n) {
        this.this$0 = dSIPredictiveNavigationProxy;
        this.val$destination = navLocation;
        this.val$radius = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$destination);
        iSerializer.putInt32(this.val$radius);
    }
}

