/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy;
import de.esolutions.fw.comm.dsi.carlight.impl.TimeStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.TimeState;

class DSICarLightProxy$1
implements ISerializable {
    private final /* synthetic */ TimeState val$timestate;
    private final /* synthetic */ DSICarLightProxy this$0;

    DSICarLightProxy$1(DSICarLightProxy dSICarLightProxy, TimeState timeState) {
        this.this$0 = dSICarLightProxy;
        this.val$timestate = timeState;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        TimeStateSerializer.putOptionalTimeState(iSerializer, this.val$timestate);
    }
}

