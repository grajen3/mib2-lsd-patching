/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Point;

class DSIMapViewerControlProxy$15
implements ISerializable {
    private final /* synthetic */ Point val$newSouthWestCornerOfRectangleInMap;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$15(DSIMapViewerControlProxy dSIMapViewerControlProxy, Point point) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$newSouthWestCornerOfRectangleInMap = point;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PointSerializer.putOptionalPoint(iSerializer, this.val$newSouthWestCornerOfRectangleInMap);
    }
}

