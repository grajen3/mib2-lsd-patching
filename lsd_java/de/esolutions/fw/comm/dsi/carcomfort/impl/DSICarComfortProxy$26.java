/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;

class DSICarComfortProxy$26
implements ISerializable {
    private final /* synthetic */ UGDOButtonListUpdateInfo val$info;
    private final /* synthetic */ int[] val$data;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$26(DSICarComfortProxy dSICarComfortProxy, UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        this.this$0 = dSICarComfortProxy;
        this.val$info = uGDOButtonListUpdateInfo;
        this.val$data = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, this.val$info);
        iSerializer.putOptionalInt32VarArray(this.val$data);
    }
}

