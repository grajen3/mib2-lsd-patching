/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProgrammedTimerSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;

class DSICarHybridProxy$1
implements ISerializable {
    private final /* synthetic */ BatteryControlProgrammedTimer val$timer;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$1(DSICarHybridProxy dSICarHybridProxy, BatteryControlProgrammedTimer batteryControlProgrammedTimer) {
        this.this$0 = dSICarHybridProxy;
        this.val$timer = batteryControlProgrammedTimer;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BatteryControlProgrammedTimerSerializer.putOptionalBatteryControlProgrammedTimer(iSerializer, this.val$timer);
    }
}

