/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.comm.dsi.map.impl.MapOverlaySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.MapOverlay;

class DSIMapViewerControlProxy$22
implements ISerializable {
    private final /* synthetic */ int val$setId;
    private final /* synthetic */ MapOverlay[] val$data;
    private final /* synthetic */ int val$delayInMillisBetweenImages;
    private final /* synthetic */ int val$overlayType;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$22(DSIMapViewerControlProxy dSIMapViewerControlProxy, int n, MapOverlay[] mapOverlayArray, int n2, int n3) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$setId = n;
        this.val$data = mapOverlayArray;
        this.val$delayInMillisBetweenImages = n2;
        this.val$overlayType = n3;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$setId);
        MapOverlaySerializer.putOptionalMapOverlayVarArray(iSerializer, this.val$data);
        iSerializer.putInt32(this.val$delayInMillisBetweenImages);
        iSerializer.putInt32(this.val$overlayType);
    }
}

