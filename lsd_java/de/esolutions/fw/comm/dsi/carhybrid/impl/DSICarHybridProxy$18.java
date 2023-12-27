/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;

class DSICarHybridProxy$18
implements ISerializable {
    private final /* synthetic */ BatteryControlPowerProviderAH val$arrayHeader;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$18(DSICarHybridProxy dSICarHybridProxy, BatteryControlPowerProviderAH batteryControlPowerProviderAH) {
        this.this$0 = dSICarHybridProxy;
        this.val$arrayHeader = batteryControlPowerProviderAH;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, this.val$arrayHeader);
    }
}

