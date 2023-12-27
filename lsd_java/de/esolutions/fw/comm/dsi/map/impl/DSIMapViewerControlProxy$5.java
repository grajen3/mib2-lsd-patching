/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSIMapViewerControlProxy$5
implements ISerializable {
    private final /* synthetic */ NavLocation val$locationDescr;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$5(DSIMapViewerControlProxy dSIMapViewerControlProxy, NavLocation navLocation) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$locationDescr = navLocation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$locationDescr);
    }
}

