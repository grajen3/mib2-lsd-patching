/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.comm.dsi.map.impl.MapFlagSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.MapFlag;

class DSIMapViewerControlProxy$1
implements ISerializable {
    private final /* synthetic */ int val$command;
    private final /* synthetic */ MapFlag[] val$flagList;
    private final /* synthetic */ DSIMapViewerControlProxy this$0;

    DSIMapViewerControlProxy$1(DSIMapViewerControlProxy dSIMapViewerControlProxy, int n, MapFlag[] mapFlagArray) {
        this.this$0 = dSIMapViewerControlProxy;
        this.val$command = n;
        this.val$flagList = mapFlagArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$command);
        MapFlagSerializer.putOptionalMapFlagVarArray(iSerializer, this.val$flagList);
    }
}

