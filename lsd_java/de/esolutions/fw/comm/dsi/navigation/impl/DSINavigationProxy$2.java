/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.NavLastDestSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavLastDest;

class DSINavigationProxy$2
implements ISerializable {
    private final /* synthetic */ NavLastDest[] val$lastDestList;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$2(DSINavigationProxy dSINavigationProxy, NavLastDest[] navLastDestArray) {
        this.this$0 = dSINavigationProxy;
        this.val$lastDestList = navLastDestArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLastDestSerializer.putOptionalNavLastDestVarArray(iSerializer, this.val$lastDestList);
    }
}

