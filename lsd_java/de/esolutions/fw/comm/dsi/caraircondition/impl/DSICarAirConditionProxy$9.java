/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconAirDistributionSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconAirDistribution;

class DSICarAirConditionProxy$9
implements ISerializable {
    private final /* synthetic */ int val$zone;
    private final /* synthetic */ AirconAirDistribution val$airDistribution;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$9(DSICarAirConditionProxy dSICarAirConditionProxy, int n, AirconAirDistribution airconAirDistribution) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$zone = n;
        this.val$airDistribution = airconAirDistribution;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$zone);
        AirconAirDistributionSerializer.putOptionalAirconAirDistribution(iSerializer, this.val$airDistribution);
    }
}

