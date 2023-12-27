/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.comm.dsi.careco.impl.BCmEListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmEListUpdateInfo;

class DSICarEcoProxy$5
implements ISerializable {
    private final /* synthetic */ BCmEListUpdateInfo val$listUpdateInfo;
    private final /* synthetic */ DSICarEcoProxy this$0;

    DSICarEcoProxy$5(DSICarEcoProxy dSICarEcoProxy, BCmEListUpdateInfo bCmEListUpdateInfo) {
        this.this$0 = dSICarEcoProxy;
        this.val$listUpdateInfo = bCmEListUpdateInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BCmEListUpdateInfoSerializer.putOptionalBCmEListUpdateInfo(iSerializer, this.val$listUpdateInfo);
    }
}

