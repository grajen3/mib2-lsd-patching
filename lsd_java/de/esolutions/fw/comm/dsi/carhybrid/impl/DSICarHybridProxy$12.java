/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfilesAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;

class DSICarHybridProxy$12
implements ISerializable {
    private final /* synthetic */ BatteryControlProfilesAH val$arrayHeader;
    private final /* synthetic */ int[] val$pos;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$12(DSICarHybridProxy dSICarHybridProxy, BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
        this.this$0 = dSICarHybridProxy;
        this.val$arrayHeader = batteryControlProfilesAH;
        this.val$pos = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, this.val$arrayHeader);
        iSerializer.putOptionalInt32VarArray(this.val$pos);
    }
}

