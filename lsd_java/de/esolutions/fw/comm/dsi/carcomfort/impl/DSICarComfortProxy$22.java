/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA2Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;

class DSICarComfortProxy$22
implements ISerializable {
    private final /* synthetic */ UGDOButtonListUpdateInfo val$info;
    private final /* synthetic */ UGDOButtonListRA2[] val$data;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$22(DSICarComfortProxy dSICarComfortProxy, UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        this.this$0 = dSICarComfortProxy;
        this.val$info = uGDOButtonListUpdateInfo;
        this.val$data = uGDOButtonListRA2Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, this.val$info);
        UGDOButtonListRA2Serializer.putOptionalUGDOButtonListRA2VarArray(iSerializer, this.val$data);
    }
}

