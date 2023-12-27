/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoProxy;
import de.esolutions.fw.comm.dsi.careco.impl.StartStopListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.StartStopListUpdateInfo;

class DSICarEcoProxy$2
implements ISerializable {
    private final /* synthetic */ StartStopListUpdateInfo val$listUpdateInfo;
    private final /* synthetic */ DSICarEcoProxy this$0;

    DSICarEcoProxy$2(DSICarEcoProxy dSICarEcoProxy, StartStopListUpdateInfo startStopListUpdateInfo) {
        this.this$0 = dSICarEcoProxy;
        this.val$listUpdateInfo = startStopListUpdateInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        StartStopListUpdateInfoSerializer.putOptionalStartStopListUpdateInfo(iSerializer, this.val$listUpdateInfo);
    }
}

