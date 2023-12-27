/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.LISpellerDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.LISpellerData;

class DSINavigationProxy$14
implements ISerializable {
    private final /* synthetic */ LISpellerData val$spellerState;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$14(DSINavigationProxy dSINavigationProxy, LISpellerData lISpellerData) {
        this.this$0 = dSINavigationProxy;
        this.val$spellerState = lISpellerData;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        LISpellerDataSerializer.putOptionalLISpellerData(iSerializer, this.val$spellerState);
    }
}

