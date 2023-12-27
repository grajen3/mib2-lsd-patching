/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.comm.dsi.map.impl.RectSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Rect;

class DSIMapViewerControlProxy$13
implements ISerializable {
    private final /* synthetic */ Rect val$screenViewPortMaximum;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$13(DSIMapViewerControlProxy dSIMapViewerControlProxy, Rect rect) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$screenViewPortMaximum = rect;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RectSerializer.putOptionalRect(iSerializer, this.val$screenViewPortMaximum);
    }
}

