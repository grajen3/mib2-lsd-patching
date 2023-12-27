/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerZoomEngineProxy;
import de.esolutions.fw.comm.dsi.map.impl.RectSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Rect;

class DSIMapViewerZoomEngineProxy$3
implements ISerializable {
    private final /* synthetic */ Rect val$zoomArea;
    private final /* synthetic */ DSIMapViewerZoomEngineProxy this$0;

    DSIMapViewerZoomEngineProxy$3(DSIMapViewerZoomEngineProxy dSIMapViewerZoomEngineProxy, Rect rect) {
        this.this$0 = dSIMapViewerZoomEngineProxy;
        this.val$zoomArea = rect;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RectSerializer.putOptionalRect(iSerializer, this.val$zoomArea);
    }
}

