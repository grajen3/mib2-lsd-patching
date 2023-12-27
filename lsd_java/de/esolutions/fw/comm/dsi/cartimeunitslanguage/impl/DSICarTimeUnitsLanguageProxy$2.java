/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.ClockGPSSyncDataSerializer;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.DSICarTimeUnitsLanguageProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;

class DSICarTimeUnitsLanguageProxy$2
implements ISerializable {
    private final /* synthetic */ ClockGPSSyncData val$gpsSyncData;
    private final /* synthetic */ DSICarTimeUnitsLanguageProxy this$0;

    DSICarTimeUnitsLanguageProxy$2(DSICarTimeUnitsLanguageProxy dSICarTimeUnitsLanguageProxy, ClockGPSSyncData clockGPSSyncData) {
        this.this$0 = dSICarTimeUnitsLanguageProxy;
        this.val$gpsSyncData = clockGPSSyncData;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ClockGPSSyncDataSerializer.putOptionalClockGPSSyncData(iSerializer, this.val$gpsSyncData);
    }
}

