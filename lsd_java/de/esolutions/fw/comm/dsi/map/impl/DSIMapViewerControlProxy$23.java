/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavSegmentIDSerializer;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavSegmentID;

class DSIMapViewerControlProxy$23
implements ISerializable {
    private final /* synthetic */ NavSegmentID[] val$visibleRoutes;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$23(DSIMapViewerControlProxy dSIMapViewerControlProxy, NavSegmentID[] navSegmentIDArray) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$visibleRoutes = navSegmentIDArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavSegmentIDSerializer.putOptionalNavSegmentIDVarArray(iSerializer, this.val$visibleRoutes);
    }
}

