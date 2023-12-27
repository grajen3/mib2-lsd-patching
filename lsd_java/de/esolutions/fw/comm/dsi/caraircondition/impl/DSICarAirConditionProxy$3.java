/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconSynchronisationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconSynchronisation;

class DSICarAirConditionProxy$3
implements ISerializable {
    private final /* synthetic */ AirconSynchronisation val$synchronisation;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$3(DSICarAirConditionProxy dSICarAirConditionProxy, AirconSynchronisation airconSynchronisation) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$synchronisation = airconSynchronisation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AirconSynchronisationSerializer.putOptionalAirconSynchronisation(iSerializer, this.val$synchronisation);
    }
}

