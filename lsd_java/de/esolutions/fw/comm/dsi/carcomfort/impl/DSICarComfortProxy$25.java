/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA5Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;

class DSICarComfortProxy$25
implements ISerializable {
    private final /* synthetic */ UGDOButtonListUpdateInfo val$info;
    private final /* synthetic */ UGDOButtonListRA5[] val$data;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$25(DSICarComfortProxy dSICarComfortProxy, UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        this.this$0 = dSICarComfortProxy;
        this.val$info = uGDOButtonListUpdateInfo;
        this.val$data = uGDOButtonListRA5Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, this.val$info);
        UGDOButtonListRA5Serializer.putOptionalUGDOButtonListRA5VarArray(iSerializer, this.val$data);
    }
}

