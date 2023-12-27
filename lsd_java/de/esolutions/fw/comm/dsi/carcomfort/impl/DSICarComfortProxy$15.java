/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDODestinationReachedSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDODestinationReached;

class DSICarComfortProxy$15
implements ISerializable {
    private final /* synthetic */ UGDODestinationReached val$data;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$15(DSICarComfortProxy dSICarComfortProxy, UGDODestinationReached uGDODestinationReached) {
        this.this$0 = dSICarComfortProxy;
        this.val$data = uGDODestinationReached;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UGDODestinationReachedSerializer.putOptionalUGDODestinationReached(iSerializer, this.val$data);
    }
}

