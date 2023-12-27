/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSIMapViewerControlProxy$9
implements ISerializable {
    private final /* synthetic */ NavLocation val$firstLocation;
    private final /* synthetic */ NavLocation val$secondLocation;
    private final /* synthetic */ int val$minimalZoomScale;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$9(DSIMapViewerControlProxy dSIMapViewerControlProxy, NavLocation navLocation, NavLocation navLocation2, int n) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$firstLocation = navLocation;
        this.val$secondLocation = navLocation2;
        this.val$minimalZoomScale = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$firstLocation);
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$secondLocation);
        iSerializer.putInt32(this.val$minimalZoomScale);
    }
}

