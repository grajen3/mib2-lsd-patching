/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.LIExtDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIExtData;

class DSINavigationProxy$13
implements ISerializable {
    private final /* synthetic */ NavLocation val$street;
    private final /* synthetic */ String val$nameofEntry;
    private final /* synthetic */ LIExtData[] val$extendedData;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$13(DSINavigationProxy dSINavigationProxy, NavLocation navLocation, String string, LIExtData[] lIExtDataArray) {
        this.this$0 = dSINavigationProxy;
        this.val$street = navLocation;
        this.val$nameofEntry = string;
        this.val$extendedData = lIExtDataArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$street);
        iSerializer.putOptionalString(this.val$nameofEntry);
        LIExtDataSerializer.putOptionalLIExtDataVarArray(iSerializer, this.val$extendedData);
    }
}

