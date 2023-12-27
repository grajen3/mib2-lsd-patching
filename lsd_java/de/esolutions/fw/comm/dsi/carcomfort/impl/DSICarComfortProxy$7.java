/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;

class DSICarComfortProxy$7
implements ISerializable {
    private final /* synthetic */ DoorLockingUserListUpdateInfo val$arrayHeader;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$7(DSICarComfortProxy dSICarComfortProxy, DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) {
        this.this$0 = dSICarComfortProxy;
        this.val$arrayHeader = doorLockingUserListUpdateInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DoorLockingUserListUpdateInfoSerializer.putOptionalDoorLockingUserListUpdateInfo(iSerializer, this.val$arrayHeader);
    }
}

