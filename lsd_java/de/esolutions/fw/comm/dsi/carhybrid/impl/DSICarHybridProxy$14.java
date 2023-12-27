/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderRA1Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;

class DSICarHybridProxy$14
implements ISerializable {
    private final /* synthetic */ BatteryControlPowerProviderAH val$arrayHeader;
    private final /* synthetic */ BatteryControlPowerProviderRA1[] val$data;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$14(DSICarHybridProxy dSICarHybridProxy, BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        this.this$0 = dSICarHybridProxy;
        this.val$arrayHeader = batteryControlPowerProviderAH;
        this.val$data = batteryControlPowerProviderRA1Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, this.val$arrayHeader);
        BatteryControlPowerProviderRA1Serializer.putOptionalBatteryControlPowerProviderRA1VarArray(iSerializer, this.val$data);
    }
}

