/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA2Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfilesAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;

class DSICarHybridProxy$6
implements ISerializable {
    private final /* synthetic */ BatteryControlProfilesAH val$arrayHeader;
    private final /* synthetic */ BatteryControlProfileRA2[] val$data;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$6(DSICarHybridProxy dSICarHybridProxy, BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        this.this$0 = dSICarHybridProxy;
        this.val$arrayHeader = batteryControlProfilesAH;
        this.val$data = batteryControlProfileRA2Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, this.val$arrayHeader);
        BatteryControlProfileRA2Serializer.putOptionalBatteryControlProfileRA2VarArray(iSerializer, this.val$data);
    }
}

