/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSIMapViewerControlProxy$18
implements ISerializable {
    private final /* synthetic */ NavLocation[] val$locations;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$18(DSIMapViewerControlProxy dSIMapViewerControlProxy, NavLocation[] navLocationArray) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$locations = navLocationArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocationVarArray(iSerializer, this.val$locations);
    }
}

