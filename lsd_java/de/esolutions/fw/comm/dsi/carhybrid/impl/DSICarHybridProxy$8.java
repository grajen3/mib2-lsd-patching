/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA4Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfilesAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;

class DSICarHybridProxy$8
implements ISerializable {
    private final /* synthetic */ BatteryControlProfilesAH val$arrayHeader;
    private final /* synthetic */ BatteryControlProfileRA4[] val$data;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$8(DSICarHybridProxy dSICarHybridProxy, BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        this.this$0 = dSICarHybridProxy;
        this.val$arrayHeader = batteryControlProfilesAH;
        this.val$data = batteryControlProfileRA4Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, this.val$arrayHeader);
        BatteryControlProfileRA4Serializer.putOptionalBatteryControlProfileRA4VarArray(iSerializer, this.val$data);
    }
}

