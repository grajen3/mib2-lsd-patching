/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA1Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;

class DSICarComfortProxy$21
implements ISerializable {
    private final /* synthetic */ UGDOButtonListUpdateInfo val$info;
    private final /* synthetic */ UGDOButtonListRA1[] val$data;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$21(DSICarComfortProxy dSICarComfortProxy, UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        this.this$0 = dSICarComfortProxy;
        this.val$info = uGDOButtonListUpdateInfo;
        this.val$data = uGDOButtonListRA1Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, this.val$info);
        UGDOButtonListRA1Serializer.putOptionalUGDOButtonListRA1VarArray(iSerializer, this.val$data);
    }
}

