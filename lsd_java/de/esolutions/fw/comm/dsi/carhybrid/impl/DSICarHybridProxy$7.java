/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA3Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfilesAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;

class DSICarHybridProxy$7
implements ISerializable {
    private final /* synthetic */ BatteryControlProfilesAH val$arrayHeader;
    private final /* synthetic */ BatteryControlProfileRA3[] val$data;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$7(DSICarHybridProxy dSICarHybridProxy, BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        this.this$0 = dSICarHybridProxy;
        this.val$arrayHeader = batteryControlProfilesAH;
        this.val$data = batteryControlProfileRA3Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, this.val$arrayHeader);
        BatteryControlProfileRA3Serializer.putOptionalBatteryControlProfileRA3VarArray(iSerializer, this.val$data);
    }
}

