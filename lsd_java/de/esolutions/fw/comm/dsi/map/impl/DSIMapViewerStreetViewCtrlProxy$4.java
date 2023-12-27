/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerStreetViewCtrlProxy;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Point;

class DSIMapViewerStreetViewCtrlProxy$4
implements ISerializable {
    private final /* synthetic */ Point val$screenPosition;
    private final /* synthetic */ DSIMapViewerStreetViewCtrlProxy this$0;

    DSIMapViewerStreetViewCtrlProxy$4(DSIMapViewerStreetViewCtrlProxy dSIMapViewerStreetViewCtrlProxy, Point point) {
        this.this$0 = dSIMapViewerStreetViewCtrlProxy;
        this.val$screenPosition = point;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PointSerializer.putOptionalPoint(iSerializer, this.val$screenPosition);
    }
}

