/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.comm.dsi.map.impl.PoiListElementSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.PoiListElement;

class DSIMapViewerControlProxy$14
implements ISerializable {
    private final /* synthetic */ PoiListElement[] val$poiListElements;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$14(DSIMapViewerControlProxy dSIMapViewerControlProxy, PoiListElement[] poiListElementArray) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$poiListElements = poiListElementArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PoiListElementSerializer.putOptionalPoiListElementVarArray(iSerializer, this.val$poiListElements);
    }
}

