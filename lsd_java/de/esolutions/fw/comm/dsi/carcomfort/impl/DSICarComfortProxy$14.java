/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOSoftkeysSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOSoftkeys;

class DSICarComfortProxy$14
implements ISerializable {
    private final /* synthetic */ UGDOSoftkeys val$button;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$14(DSICarComfortProxy dSICarComfortProxy, UGDOSoftkeys uGDOSoftkeys) {
        this.this$0 = dSICarComfortProxy;
        this.val$button = uGDOSoftkeys;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UGDOSoftkeysSerializer.putOptionalUGDOSoftkeys(iSerializer, this.val$button);
    }
}

