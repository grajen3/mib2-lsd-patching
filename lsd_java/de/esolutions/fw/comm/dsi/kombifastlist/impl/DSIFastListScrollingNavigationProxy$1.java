/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingNavigationProxy;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataAddressSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataAddress;

class DSIFastListScrollingNavigationProxy$1
implements ISerializable {
    private final /* synthetic */ int val$tag;
    private final /* synthetic */ int val$posY;
    private final /* synthetic */ DataAddress[] val$data;
    private final /* synthetic */ DSIFastListScrollingNavigationProxy this$0;

    DSIFastListScrollingNavigationProxy$1(DSIFastListScrollingNavigationProxy dSIFastListScrollingNavigationProxy, int n, int n2, DataAddress[] dataAddressArray) {
        this.this$0 = dSIFastListScrollingNavigationProxy;
        this.val$tag = n;
        this.val$posY = n2;
        this.val$data = dataAddressArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$tag);
        iSerializer.putInt32(this.val$posY);
        DataAddressSerializer.putOptionalDataAddressVarArray(iSerializer, this.val$data);
    }
}

