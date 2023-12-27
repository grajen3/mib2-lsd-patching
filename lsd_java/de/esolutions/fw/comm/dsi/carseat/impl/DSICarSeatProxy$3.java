/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatContentSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SeatContent;

class DSICarSeatProxy$3
implements ISerializable {
    private final /* synthetic */ SeatContent val$content;
    private final /* synthetic */ DSICarSeatProxy this$0;

    DSICarSeatProxy$3(DSICarSeatProxy dSICarSeatProxy, SeatContent seatContent) {
        this.this$0 = dSICarSeatProxy;
        this.val$content = seatContent;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SeatContentSerializer.putOptionalSeatContent(iSerializer, this.val$content);
    }
}

