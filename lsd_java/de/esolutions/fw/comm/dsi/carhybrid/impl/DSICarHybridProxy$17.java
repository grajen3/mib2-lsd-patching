/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;

class DSICarHybridProxy$17
implements ISerializable {
    private final /* synthetic */ BatteryControlPowerProviderAH val$arrayHeader;
    private final /* synthetic */ int[] val$data;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$17(DSICarHybridProxy dSICarHybridProxy, BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
        this.this$0 = dSICarHybridProxy;
        this.val$arrayHeader = batteryControlPowerProviderAH;
        this.val$data = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, this.val$arrayHeader);
        iSerializer.putOptionalInt32VarArray(this.val$data);
    }
}

