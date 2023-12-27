/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconBlowerCompensationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;

class DSICarAirConditionProxy$2
implements ISerializable {
    private final /* synthetic */ AirconBlowerCompensation val$blowerCompensation;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$2(DSICarAirConditionProxy dSICarAirConditionProxy, AirconBlowerCompensation airconBlowerCompensation) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$blowerCompensation = airconBlowerCompensation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AirconBlowerCompensationSerializer.putOptionalAirconBlowerCompensation(iSerializer, this.val$blowerCompensation);
    }
}

