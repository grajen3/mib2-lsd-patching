/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;

class DSIMapViewerControlProxy$19
implements ISerializable {
    private final /* synthetic */ NavLocationWgs84 val$position;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$19(DSIMapViewerControlProxy dSIMapViewerControlProxy, NavLocationWgs84 navLocationWgs84) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$position = navLocationWgs84;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, this.val$position);
    }
}

