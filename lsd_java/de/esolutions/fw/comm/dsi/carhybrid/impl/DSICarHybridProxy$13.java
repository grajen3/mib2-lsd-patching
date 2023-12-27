/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderRA0Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;

class DSICarHybridProxy$13
implements ISerializable {
    private final /* synthetic */ BatteryControlPowerProviderAH val$arrayHeader;
    private final /* synthetic */ BatteryControlPowerProviderRA0[] val$data;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$13(DSICarHybridProxy dSICarHybridProxy, BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        this.this$0 = dSICarHybridProxy;
        this.val$arrayHeader = batteryControlPowerProviderAH;
        this.val$data = batteryControlPowerProviderRA0Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, this.val$arrayHeader);
        BatteryControlPowerProviderRA0Serializer.putOptionalBatteryControlPowerProviderRA0VarArray(iSerializer, this.val$data);
    }
}

