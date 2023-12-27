/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatSpecialPositionSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SeatSpecialPosition;

class DSICarSeatProxy$2
implements ISerializable {
    private final /* synthetic */ SeatSpecialPosition val$position;
    private final /* synthetic */ DSICarSeatProxy this$0;

    DSICarSeatProxy$2(DSICarSeatProxy dSICarSeatProxy, SeatSpecialPosition seatSpecialPosition) {
        this.this$0 = dSICarSeatProxy;
        this.val$position = seatSpecialPosition;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SeatSpecialPositionSerializer.putOptionalSeatSpecialPosition(iSerializer, this.val$position);
    }
}

