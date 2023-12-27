/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerStreetViewCtrlProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;

class DSIMapViewerStreetViewCtrlProxy$2
implements ISerializable {
    private final /* synthetic */ NavLocationWgs84 val$position;
    private final /* synthetic */ DSIMapViewerStreetViewCtrlProxy this$0;

    DSIMapViewerStreetViewCtrlProxy$2(DSIMapViewerStreetViewCtrlProxy dSIMapViewerStreetViewCtrlProxy, NavLocationWgs84 navLocationWgs84) {
        this.this$0 = dSIMapViewerStreetViewCtrlProxy;
        this.val$position = navLocationWgs84;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, this.val$position);
    }
}

