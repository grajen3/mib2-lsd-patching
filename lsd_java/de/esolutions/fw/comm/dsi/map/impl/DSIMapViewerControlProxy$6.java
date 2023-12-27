/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSIMapViewerControlProxy$6
implements ISerializable {
    private final /* synthetic */ NavLocation val$locationDescr;
    private final /* synthetic */ short val$rotation;
    private final /* synthetic */ int val$zoomIdx;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$6(DSIMapViewerControlProxy dSIMapViewerControlProxy, NavLocation navLocation, short s, int n) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$locationDescr = navLocation;
        this.val$rotation = s;
        this.val$zoomIdx = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$locationDescr);
        iSerializer.putInt16(this.val$rotation);
        iSerializer.putInt32(this.val$zoomIdx);
    }
}

