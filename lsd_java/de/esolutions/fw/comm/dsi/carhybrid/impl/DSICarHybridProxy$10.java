/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA6Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfilesAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;

class DSICarHybridProxy$10
implements ISerializable {
    private final /* synthetic */ BatteryControlProfilesAH val$arrayHeader;
    private final /* synthetic */ BatteryControlProfileRA6[] val$data;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$10(DSICarHybridProxy dSICarHybridProxy, BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        this.this$0 = dSICarHybridProxy;
        this.val$arrayHeader = batteryControlProfilesAH;
        this.val$data = batteryControlProfileRA6Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, this.val$arrayHeader);
        BatteryControlProfileRA6Serializer.putOptionalBatteryControlProfileRA6VarArray(iSerializer, this.val$data);
    }
}

