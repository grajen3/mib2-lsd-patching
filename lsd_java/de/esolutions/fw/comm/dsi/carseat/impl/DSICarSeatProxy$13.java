/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy;
import de.esolutions.fw.comm.dsi.carseat.impl.MassageDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.MassageData;

class DSICarSeatProxy$13
implements ISerializable {
    private final /* synthetic */ int val$seat;
    private final /* synthetic */ MassageData val$seatMassageData;
    private final /* synthetic */ DSICarSeatProxy this$0;

    DSICarSeatProxy$13(DSICarSeatProxy dSICarSeatProxy, int n, MassageData massageData) {
        this.this$0 = dSICarSeatProxy;
        this.val$seat = n;
        this.val$seatMassageData = massageData;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$seat);
        MassageDataSerializer.putOptionalMassageData(iSerializer, this.val$seatMassageData);
    }
}

