/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;

class DSIMapViewerControlProxy$8
implements ISerializable {
    private final /* synthetic */ NavLocationWgs84 val$position;
    private final /* synthetic */ short val$rotation;
    private final /* synthetic */ int val$zoomIdx;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$8(DSIMapViewerControlProxy dSIMapViewerControlProxy, NavLocationWgs84 navLocationWgs84, short s, int n) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$position = navLocationWgs84;
        this.val$rotation = s;
        this.val$zoomIdx = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, this.val$position);
        iSerializer.putInt16(this.val$rotation);
        iSerializer.putInt32(this.val$zoomIdx);
    }
}

