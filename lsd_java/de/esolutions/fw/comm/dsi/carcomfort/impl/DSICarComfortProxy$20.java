/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA0Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;

class DSICarComfortProxy$20
implements ISerializable {
    private final /* synthetic */ UGDOButtonListUpdateInfo val$info;
    private final /* synthetic */ UGDOButtonListRA0[] val$data;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$20(DSICarComfortProxy dSICarComfortProxy, UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        this.this$0 = dSICarComfortProxy;
        this.val$info = uGDOButtonListUpdateInfo;
        this.val$data = uGDOButtonListRA0Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, this.val$info);
        UGDOButtonListRA0Serializer.putOptionalUGDOButtonListRA0VarArray(iSerializer, this.val$data);
    }
}

