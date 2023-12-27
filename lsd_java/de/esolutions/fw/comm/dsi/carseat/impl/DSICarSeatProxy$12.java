/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatAdjustmentSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SeatAdjustment;

class DSICarSeatProxy$12
implements ISerializable {
    private final /* synthetic */ int val$seat;
    private final /* synthetic */ SeatAdjustment val$seatAdjustmentData;
    private final /* synthetic */ DSICarSeatProxy this$0;

    DSICarSeatProxy$12(DSICarSeatProxy dSICarSeatProxy, int n, SeatAdjustment seatAdjustment) {
        this.this$0 = dSICarSeatProxy;
        this.val$seat = n;
        this.val$seatAdjustmentData = seatAdjustment;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$seat);
        SeatAdjustmentSerializer.putOptionalSeatAdjustment(iSerializer, this.val$seatAdjustmentData);
    }
}

