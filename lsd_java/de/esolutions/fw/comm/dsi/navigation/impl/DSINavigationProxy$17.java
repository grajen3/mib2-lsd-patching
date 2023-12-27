/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.TryBestMatchDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.TryBestMatchData;

class DSINavigationProxy$17
implements ISerializable {
    private final /* synthetic */ TryBestMatchData val$tbmData;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$17(DSINavigationProxy dSINavigationProxy, TryBestMatchData tryBestMatchData) {
        this.this$0 = dSINavigationProxy;
        this.val$tbmData = tryBestMatchData;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        TryBestMatchDataSerializer.putOptionalTryBestMatchData(iSerializer, this.val$tbmData);
    }
}

