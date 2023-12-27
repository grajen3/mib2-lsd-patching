/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSINavigationProxy$30
implements ISerializable {
    private final /* synthetic */ NavLocation[] val$userDefinedPOIs;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$30(DSINavigationProxy dSINavigationProxy, NavLocation[] navLocationArray) {
        this.this$0 = dSINavigationProxy;
        this.val$userDefinedPOIs = navLocationArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocationVarArray(iSerializer, this.val$userDefinedPOIs);
    }
}

