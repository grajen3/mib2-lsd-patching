/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconBCMeasuresConfigurationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;

class DSICarAirConditionProxy$14
implements ISerializable {
    private final /* synthetic */ int val$zone;
    private final /* synthetic */ boolean val$state;
    private final /* synthetic */ AirconBCMeasuresConfiguration val$measures;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$14(DSICarAirConditionProxy dSICarAirConditionProxy, int n, boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$zone = n;
        this.val$state = bl;
        this.val$measures = airconBCMeasuresConfiguration;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$zone);
        iSerializer.putBool(this.val$state);
        AirconBCMeasuresConfigurationSerializer.putOptionalAirconBCMeasuresConfiguration(iSerializer, this.val$measures);
    }
}

