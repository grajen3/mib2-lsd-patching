/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderRAESerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;

class DSICarHybridProxy$16
implements ISerializable {
    private final /* synthetic */ BatteryControlPowerProviderAH val$arrayHeader;
    private final /* synthetic */ BatteryControlPowerProviderRAE[] val$data;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$16(DSICarHybridProxy dSICarHybridProxy, BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        this.this$0 = dSICarHybridProxy;
        this.val$arrayHeader = batteryControlPowerProviderAH;
        this.val$data = batteryControlPowerProviderRAEArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, this.val$arrayHeader);
        BatteryControlPowerProviderRAESerializer.putOptionalBatteryControlPowerProviderRAEVarArray(iSerializer, this.val$data);
    }
}

