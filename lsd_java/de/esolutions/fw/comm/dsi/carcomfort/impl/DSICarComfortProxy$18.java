/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOSynchronisationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;

class DSICarComfortProxy$18
implements ISerializable {
    private final /* synthetic */ UGDOSynchronisation val$data;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$18(DSICarComfortProxy dSICarComfortProxy, UGDOSynchronisation uGDOSynchronisation) {
        this.this$0 = dSICarComfortProxy;
        this.val$data = uGDOSynchronisation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UGDOSynchronisationSerializer.putOptionalUGDOSynchronisation(iSerializer, this.val$data);
    }
}

