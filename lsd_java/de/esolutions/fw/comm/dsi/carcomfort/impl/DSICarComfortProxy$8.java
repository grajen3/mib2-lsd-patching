/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserListRA1Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;

class DSICarComfortProxy$8
implements ISerializable {
    private final /* synthetic */ DoorLockingUserListUpdateInfo val$arrayHeader;
    private final /* synthetic */ DoorLockingUserListRA1[] val$data;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$8(DSICarComfortProxy dSICarComfortProxy, DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        this.this$0 = dSICarComfortProxy;
        this.val$arrayHeader = doorLockingUserListUpdateInfo;
        this.val$data = doorLockingUserListRA1Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DoorLockingUserListUpdateInfoSerializer.putOptionalDoorLockingUserListUpdateInfo(iSerializer, this.val$arrayHeader);
        DoorLockingUserListRA1Serializer.putOptionalDoorLockingUserListRA1VarArray(iSerializer, this.val$data);
    }
}

