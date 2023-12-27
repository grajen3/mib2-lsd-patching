/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconTempSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconTemp;

class DSICarAirConditionProxy$7
implements ISerializable {
    private final /* synthetic */ int val$zone;
    private final /* synthetic */ AirconTemp val$temp;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$7(DSICarAirConditionProxy dSICarAirConditionProxy, int n, AirconTemp airconTemp) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$zone = n;
        this.val$temp = airconTemp;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$zone);
        AirconTempSerializer.putOptionalAirconTemp(iSerializer, this.val$temp);
    }
}

