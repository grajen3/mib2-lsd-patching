/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatPneumaticContentSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SeatPneumaticContent;

class DSICarSeatProxy$5
implements ISerializable {
    private final /* synthetic */ SeatPneumaticContent val$content;
    private final /* synthetic */ DSICarSeatProxy this$0;

    DSICarSeatProxy$5(DSICarSeatProxy dSICarSeatProxy, SeatPneumaticContent seatPneumaticContent) {
        this.this$0 = dSICarSeatProxy;
        this.val$content = seatPneumaticContent;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SeatPneumaticContentSerializer.putOptionalSeatPneumaticContent(iSerializer, this.val$content);
    }
}

