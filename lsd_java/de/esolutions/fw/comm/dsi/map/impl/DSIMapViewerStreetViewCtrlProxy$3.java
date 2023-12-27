/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerStreetViewCtrlProxy;
import de.esolutions.fw.comm.dsi.map.impl.RectSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Rect;

class DSIMapViewerStreetViewCtrlProxy$3
implements ISerializable {
    private final /* synthetic */ Rect val$screenViewPort;
    private final /* synthetic */ DSIMapViewerStreetViewCtrlProxy this$0;

    DSIMapViewerStreetViewCtrlProxy$3(DSIMapViewerStreetViewCtrlProxy dSIMapViewerStreetViewCtrlProxy, Rect rect) {
        this.this$0 = dSIMapViewerStreetViewCtrlProxy;
        this.val$screenViewPort = rect;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RectSerializer.putOptionalRect(iSerializer, this.val$screenViewPort);
    }
}

