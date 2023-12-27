/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingTheftWarningSettingsSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;

class DSICarComfortProxy$5
implements ISerializable {
    private final /* synthetic */ DoorLockingTheftWarningSettings val$settings;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$5(DSICarComfortProxy dSICarComfortProxy, DoorLockingTheftWarningSettings doorLockingTheftWarningSettings) {
        this.this$0 = dSICarComfortProxy;
        this.val$settings = doorLockingTheftWarningSettings;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DoorLockingTheftWarningSettingsSerializer.putOptionalDoorLockingTheftWarningSettings(iSerializer, this.val$settings);
    }
}

