/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockDateSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.DSICarTimeUnitsLanguageProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;

class DSICarTimeUnitsLanguageProxy$1
implements ISerializable {
    private final /* synthetic */ ClockDate val$date;
    private final /* synthetic */ DSICarTimeUnitsLanguageProxy this$0;

    DSICarTimeUnitsLanguageProxy$1(DSICarTimeUnitsLanguageProxy dSICarTimeUnitsLanguageProxy, ClockDate clockDate) {
        this.this$0 = dSICarTimeUnitsLanguageProxy;
        this.val$date = clockDate;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ClockDateSerializer.putOptionalClockDate(iSerializer, this.val$date);
    }
}

