/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;

class DSICarComfortProxy$9
implements ISerializable {
    private final /* synthetic */ DoorLockingUserListUpdateInfo val$arrayHeader;
    private final /* synthetic */ int[] val$pos;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$9(DSICarComfortProxy dSICarComfortProxy, DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
        this.this$0 = dSICarComfortProxy;
        this.val$arrayHeader = doorLockingUserListUpdateInfo;
        this.val$pos = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DoorLockingUserListUpdateInfoSerializer.putOptionalDoorLockingUserListUpdateInfo(iSerializer, this.val$arrayHeader);
        iSerializer.putOptionalInt32VarArray(this.val$pos);
    }
}

