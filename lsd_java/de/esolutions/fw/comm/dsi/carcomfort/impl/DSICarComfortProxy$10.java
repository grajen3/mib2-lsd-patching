/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserProfileOnOffSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;

class DSICarComfortProxy$10
implements ISerializable {
    private final /* synthetic */ DoorLockingUserProfileOnOff val$control;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$10(DSICarComfortProxy dSICarComfortProxy, DoorLockingUserProfileOnOff doorLockingUserProfileOnOff) {
        this.this$0 = dSICarComfortProxy;
        this.val$control = doorLockingUserProfileOnOff;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DoorLockingUserProfileOnOffSerializer.putOptionalDoorLockingUserProfileOnOff(iSerializer, this.val$control);
    }
}

