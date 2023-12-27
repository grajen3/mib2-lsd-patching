/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Point;

class DSIMapViewerControlProxy$16
implements ISerializable {
    private final /* synthetic */ Point val$newNorthEastCornerOfRectangleInMap;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$16(DSIMapViewerControlProxy dSIMapViewerControlProxy, Point point) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$newNorthEastCornerOfRectangleInMap = point;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PointSerializer.putOptionalPoint(iSerializer, this.val$newNorthEastCornerOfRectangleInMap);
    }
}

