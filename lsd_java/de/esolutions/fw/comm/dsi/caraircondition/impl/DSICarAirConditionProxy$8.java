/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconAirVolumeSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconAirVolume;

class DSICarAirConditionProxy$8
implements ISerializable {
    private final /* synthetic */ int val$zone;
    private final /* synthetic */ AirconAirVolume val$airVolume;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$8(DSICarAirConditionProxy dSICarAirConditionProxy, int n, AirconAirVolume airconAirVolume) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$zone = n;
        this.val$airVolume = airconAirVolume;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$zone);
        AirconAirVolumeSerializer.putOptionalAirconAirVolume(iSerializer, this.val$airVolume);
    }
}

