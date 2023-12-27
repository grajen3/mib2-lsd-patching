/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerLandmarkPlayerProxy;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Point;

class DSIMapViewerLandmarkPlayerProxy$1
implements ISerializable {
    private final /* synthetic */ Point val$wgs84position;
    private final /* synthetic */ long val$landmarkID;
    private final /* synthetic */ DSIMapViewerLandmarkPlayerProxy this$0;

    DSIMapViewerLandmarkPlayerProxy$1(DSIMapViewerLandmarkPlayerProxy dSIMapViewerLandmarkPlayerProxy, Point point, long l) {
        this.this$0 = dSIMapViewerLandmarkPlayerProxy;
        this.val$wgs84position = point;
        this.val$landmarkID = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PointSerializer.putOptionalPoint(iSerializer, this.val$wgs84position);
        iSerializer.putInt64(this.val$landmarkID);
    }
}

