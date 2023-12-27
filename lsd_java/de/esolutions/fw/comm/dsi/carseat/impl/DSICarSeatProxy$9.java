/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy;
import de.esolutions.fw.comm.dsi.carseat.impl.SwitcherDataUpDownSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

class DSICarSeatProxy$9
implements ISerializable {
    private final /* synthetic */ int val$seat;
    private final /* synthetic */ SwitcherDataUpDown val$seatSwitchData;
    private final /* synthetic */ DSICarSeatProxy this$0;

    DSICarSeatProxy$9(DSICarSeatProxy dSICarSeatProxy, int n, SwitcherDataUpDown switcherDataUpDown) {
        this.this$0 = dSICarSeatProxy;
        this.val$seat = n;
        this.val$seatSwitchData = switcherDataUpDown;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$seat);
        SwitcherDataUpDownSerializer.putOptionalSwitcherDataUpDown(iSerializer, this.val$seatSwitchData);
    }
}

