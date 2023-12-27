/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;

class DSIMapViewerControlProxy$21
implements ISerializable {
    private final /* synthetic */ NavLocationWgs84 val$initialPosition;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$21(DSIMapViewerControlProxy dSIMapViewerControlProxy, NavLocationWgs84 navLocationWgs84) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$initialPosition = navLocationWgs84;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, this.val$initialPosition);
    }
}

