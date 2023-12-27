/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconPureAirSetupSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;

class DSICarAirConditionProxy$12
implements ISerializable {
    private final /* synthetic */ AirconPureAirSetup val$setup;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$12(DSICarAirConditionProxy dSICarAirConditionProxy, AirconPureAirSetup airconPureAirSetup) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$setup = airconPureAirSetup;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AirconPureAirSetupSerializer.putOptionalAirconPureAirSetup(iSerializer, this.val$setup);
    }
}

