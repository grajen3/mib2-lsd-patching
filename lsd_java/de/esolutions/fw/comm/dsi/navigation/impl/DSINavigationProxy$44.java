/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSINavigationProxy$44
implements ISerializable {
    private final /* synthetic */ String val$initialSearchString;
    private final /* synthetic */ int val$poiSearchMode;
    private final /* synthetic */ NavLocation val$poiLocation;
    private final /* synthetic */ int[] val$categoryUIds;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$44(DSINavigationProxy dSINavigationProxy, String string, int n, NavLocation navLocation, int[] nArray) {
        this.this$0 = dSINavigationProxy;
        this.val$initialSearchString = string;
        this.val$poiSearchMode = n;
        this.val$poiLocation = navLocation;
        this.val$categoryUIds = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$initialSearchString);
        iSerializer.putInt32(this.val$poiSearchMode);
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$poiLocation);
        iSerializer.putOptionalInt32VarArray(this.val$categoryUIds);
    }
}

