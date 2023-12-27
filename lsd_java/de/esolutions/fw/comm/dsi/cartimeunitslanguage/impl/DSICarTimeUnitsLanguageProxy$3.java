/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockSummerTimeDataSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.DSICarTimeUnitsLanguageProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;

class DSICarTimeUnitsLanguageProxy$3
implements ISerializable {
    private final /* synthetic */ ClockSummerTimeData val$data;
    private final /* synthetic */ DSICarTimeUnitsLanguageProxy this$0;

    DSICarTimeUnitsLanguageProxy$3(DSICarTimeUnitsLanguageProxy dSICarTimeUnitsLanguageProxy, ClockSummerTimeData clockSummerTimeData) {
        this.this$0 = dSICarTimeUnitsLanguageProxy;
        this.val$data = clockSummerTimeData;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ClockSummerTimeDataSerializer.putOptionalClockSummerTimeData(iSerializer, this.val$data);
    }
}

