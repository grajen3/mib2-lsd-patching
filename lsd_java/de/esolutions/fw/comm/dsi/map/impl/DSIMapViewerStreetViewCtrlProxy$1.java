/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerStreetViewCtrlProxy;
import de.esolutions.fw.comm.dsi.map.impl.StreetViewThumbnailSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.StreetViewThumbnail;

class DSIMapViewerStreetViewCtrlProxy$1
implements ISerializable {
    private final /* synthetic */ StreetViewThumbnail[] val$thumbnails;
    private final /* synthetic */ DSIMapViewerStreetViewCtrlProxy this$0;

    DSIMapViewerStreetViewCtrlProxy$1(DSIMapViewerStreetViewCtrlProxy dSIMapViewerStreetViewCtrlProxy, StreetViewThumbnail[] streetViewThumbnailArray) {
        this.this$0 = dSIMapViewerStreetViewCtrlProxy;
        this.val$thumbnails = streetViewThumbnailArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        StreetViewThumbnailSerializer.putOptionalStreetViewThumbnailVarArray(iSerializer, this.val$thumbnails);
    }
}

