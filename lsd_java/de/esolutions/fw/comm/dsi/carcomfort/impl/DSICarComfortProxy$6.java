/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingRearBlindSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;

class DSICarComfortProxy$6
implements ISerializable {
    private final /* synthetic */ DoorLockingRearBlind val$rearBlind;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$6(DSICarComfortProxy dSICarComfortProxy, DoorLockingRearBlind doorLockingRearBlind) {
        this.this$0 = dSICarComfortProxy;
        this.val$rearBlind = doorLockingRearBlind;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DoorLockingRearBlindSerializer.putOptionalDoorLockingRearBlind(iSerializer, this.val$rearBlind);
    }
}

