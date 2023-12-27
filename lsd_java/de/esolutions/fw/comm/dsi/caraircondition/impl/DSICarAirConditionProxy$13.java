/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconFreshAirConfigurationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;

class DSICarAirConditionProxy$13
implements ISerializable {
    private final /* synthetic */ AirconFreshAirConfiguration val$config;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$13(DSICarAirConditionProxy dSICarAirConditionProxy, AirconFreshAirConfiguration airconFreshAirConfiguration) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$config = airconFreshAirConfiguration;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AirconFreshAirConfigurationSerializer.putOptionalAirconFreshAirConfiguration(iSerializer, this.val$config);
    }
}

