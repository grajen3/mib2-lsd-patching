/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerGoogleCtrlProxy;
import de.esolutions.fw.comm.dsi.map.impl.RectSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Rect;

class DSIMapViewerGoogleCtrlProxy$1
implements ISerializable {
    private final /* synthetic */ Rect val$screenArea;
    private final /* synthetic */ int val$labelPosition;
    private final /* synthetic */ int val$alignment;
    private final /* synthetic */ DSIMapViewerGoogleCtrlProxy this$0;

    DSIMapViewerGoogleCtrlProxy$1(DSIMapViewerGoogleCtrlProxy dSIMapViewerGoogleCtrlProxy, Rect rect, int n, int n2) {
        this.this$0 = dSIMapViewerGoogleCtrlProxy;
        this.val$screenArea = rect;
        this.val$labelPosition = n;
        this.val$alignment = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RectSerializer.putOptionalRect(iSerializer, this.val$screenArea);
        iSerializer.putInt32(this.val$labelPosition);
        iSerializer.putInt32(this.val$alignment);
    }
}

