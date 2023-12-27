/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerRouteBlockProxy;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Point;

class DSIMapViewerRouteBlockProxy$1
implements ISerializable {
    private final /* synthetic */ Point val$pickCenter;
    private final /* synthetic */ int val$pickRadius;
    private final /* synthetic */ DSIMapViewerRouteBlockProxy this$0;

    DSIMapViewerRouteBlockProxy$1(DSIMapViewerRouteBlockProxy dSIMapViewerRouteBlockProxy, Point point, int n) {
        this.this$0 = dSIMapViewerRouteBlockProxy;
        this.val$pickCenter = point;
        this.val$pickRadius = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PointSerializer.putOptionalPoint(iSerializer, this.val$pickCenter);
        iSerializer.putInt32(this.val$pickRadius);
    }
}

