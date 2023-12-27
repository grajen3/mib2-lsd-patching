/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlWeekdaysSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

class DSICarHybridProxy$2
implements ISerializable {
    private final /* synthetic */ int val$timer;
    private final /* synthetic */ int val$year;
    private final /* synthetic */ int val$month;
    private final /* synthetic */ int val$day;
    private final /* synthetic */ int val$hour;
    private final /* synthetic */ int val$minute;
    private final /* synthetic */ BatteryControlWeekdays val$cyclic;
    private final /* synthetic */ int val$refProfileID;
    private final /* synthetic */ DSICarHybridProxy this$0;

    DSICarHybridProxy$2(DSICarHybridProxy dSICarHybridProxy, int n, int n2, int n3, int n4, int n5, int n6, BatteryControlWeekdays batteryControlWeekdays, int n7) {
        this.this$0 = dSICarHybridProxy;
        this.val$timer = n;
        this.val$year = n2;
        this.val$month = n3;
        this.val$day = n4;
        this.val$hour = n5;
        this.val$minute = n6;
        this.val$cyclic = batteryControlWeekdays;
        this.val$refProfileID = n7;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$timer);
        iSerializer.putInt32(this.val$year);
        iSerializer.putInt32(this.val$month);
        iSerializer.putInt32(this.val$day);
        iSerializer.putInt32(this.val$hour);
        iSerializer.putInt32(this.val$minute);
        BatteryControlWeekdaysSerializer.putOptionalBatteryControlWeekdays(iSerializer, this.val$cyclic);
        iSerializer.putInt32(this.val$refProfileID);
    }
}

