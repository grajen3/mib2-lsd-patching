/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy;
import de.esolutions.fw.comm.dsi.carseat.impl.SwitcherDataBackForwardSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SwitcherDataBackForward;

class DSICarSeatProxy$10
implements ISerializable {
    private final /* synthetic */ int val$seat;
    private final /* synthetic */ SwitcherDataBackForward val$seatSwitchData;
    private final /* synthetic */ DSICarSeatProxy this$0;

    DSICarSeatProxy$10(DSICarSeatProxy dSICarSeatProxy, int n, SwitcherDataBackForward switcherDataBackForward) {
        this.this$0 = dSICarSeatProxy;
        this.val$seat = n;
        this.val$seatSwitchData = switcherDataBackForward;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$seat);
        SwitcherDataBackForwardSerializer.putOptionalSwitcherDataBackForward(iSerializer, this.val$seatSwitchData);
    }
}

