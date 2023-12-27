/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingComfortOpenSettingsSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;

class DSICarComfortProxy$4
implements ISerializable {
    private final /* synthetic */ DoorLockingComfortOpenSettings val$settings;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$4(DSICarComfortProxy dSICarComfortProxy, DoorLockingComfortOpenSettings doorLockingComfortOpenSettings) {
        this.this$0 = dSICarComfortProxy;
        this.val$settings = doorLockingComfortOpenSettings;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DoorLockingComfortOpenSettingsSerializer.putOptionalDoorLockingComfortOpenSettings(iSerializer, this.val$settings);
    }
}

