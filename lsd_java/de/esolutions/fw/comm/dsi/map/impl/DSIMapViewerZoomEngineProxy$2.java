/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerZoomEngineProxy;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Point;

class DSIMapViewerZoomEngineProxy$2
implements ISerializable {
    private final /* synthetic */ int val$orientation;
    private final /* synthetic */ Point val$orientationByPoint;
    private final /* synthetic */ DSIMapViewerZoomEngineProxy this$0;

    DSIMapViewerZoomEngineProxy$2(DSIMapViewerZoomEngineProxy dSIMapViewerZoomEngineProxy, int n, Point point) {
        this.this$0 = dSIMapViewerZoomEngineProxy;
        this.val$orientation = n;
        this.val$orientationByPoint = point;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$orientation);
        PointSerializer.putOptionalPoint(iSerializer, this.val$orientationByPoint);
    }
}

