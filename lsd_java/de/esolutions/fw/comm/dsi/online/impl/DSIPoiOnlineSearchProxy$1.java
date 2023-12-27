/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.DSIPoiOnlineSearchProxy;
import de.esolutions.fw.comm.dsi.online.impl.PoiOnlineSearchValuelistElementSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

class DSIPoiOnlineSearchProxy$1
implements ISerializable {
    private final /* synthetic */ PoiOnlineSearchValuelistElement val$anElement;
    private final /* synthetic */ int val$usedFor;
    private final /* synthetic */ DSIPoiOnlineSearchProxy this$0;

    DSIPoiOnlineSearchProxy$1(DSIPoiOnlineSearchProxy dSIPoiOnlineSearchProxy, PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, int n) {
        this.this$0 = dSIPoiOnlineSearchProxy;
        this.val$anElement = poiOnlineSearchValuelistElement;
        this.val$usedFor = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PoiOnlineSearchValuelistElementSerializer.putOptionalPoiOnlineSearchValuelistElement(iSerializer, this.val$anElement);
        iSerializer.putInt32(this.val$usedFor);
    }
}

