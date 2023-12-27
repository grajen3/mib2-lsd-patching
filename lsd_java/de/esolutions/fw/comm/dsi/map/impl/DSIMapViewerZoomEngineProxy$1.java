/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerZoomEngineProxy;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Point;

class DSIMapViewerZoomEngineProxy$1
implements ISerializable {
    private final /* synthetic */ Point val$screenCarPosition;
    private final /* synthetic */ DSIMapViewerZoomEngineProxy this$0;

    DSIMapViewerZoomEngineProxy$1(DSIMapViewerZoomEngineProxy dSIMapViewerZoomEngineProxy, Point point) {
        this.this$0 = dSIMapViewerZoomEngineProxy;
        this.val$screenCarPosition = point;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PointSerializer.putOptionalPoint(iSerializer, this.val$screenCarPosition);
    }
}

