/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavRectangle;

class DSIMapViewerControlProxy$20
implements ISerializable {
    private final /* synthetic */ NavRectangle val$rectangle;
    private final /* synthetic */ int val$minimalZoomScale;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$20(DSIMapViewerControlProxy dSIMapViewerControlProxy, NavRectangle navRectangle, int n) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$rectangle = navRectangle;
        this.val$minimalZoomScale = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavRectangleSerializer.putOptionalNavRectangle(iSerializer, this.val$rectangle);
        iSerializer.putInt32(this.val$minimalZoomScale);
    }
}

