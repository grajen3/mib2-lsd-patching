/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconSteeringWheelHeaterSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;

class DSICarAirConditionProxy$1
implements ISerializable {
    private final /* synthetic */ AirconSteeringWheelHeater val$settings;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$1(DSICarAirConditionProxy dSICarAirConditionProxy, AirconSteeringWheelHeater airconSteeringWheelHeater) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$settings = airconSteeringWheelHeater;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AirconSteeringWheelHeaterSerializer.putOptionalAirconSteeringWheelHeater(iSerializer, this.val$settings);
    }
}

