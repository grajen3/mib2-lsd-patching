/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.tpegservices.impl.DSITPEGServicesProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSITPEGServicesProxy$1
implements ISerializable {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ int val$requestMode;
    private final /* synthetic */ int val$weatherInfoInterval;
    private final /* synthetic */ DSITPEGServicesProxy this$0;

    DSITPEGServicesProxy$1(DSITPEGServicesProxy dSITPEGServicesProxy, NavLocation navLocation, int n, int n2) {
        this.this$0 = dSITPEGServicesProxy;
        this.val$location = navLocation;
        this.val$requestMode = n;
        this.val$weatherInfoInterval = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$location);
        iSerializer.putInt32(this.val$requestMode);
        iSerializer.putInt32(this.val$weatherInfoInterval);
    }
}

