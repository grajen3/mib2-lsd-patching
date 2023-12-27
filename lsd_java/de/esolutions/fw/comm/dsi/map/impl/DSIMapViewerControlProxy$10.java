/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Point;

class DSIMapViewerControlProxy$10
implements ISerializable {
    private final /* synthetic */ int val$orientation;
    private final /* synthetic */ Point val$orientationByPoint;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$10(DSIMapViewerControlProxy dSIMapViewerControlProxy, int n, Point point) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$orientation = n;
        this.val$orientationByPoint = point;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$orientation);
        PointSerializer.putOptionalPoint(iSerializer, this.val$orientationByPoint);
    }
}

