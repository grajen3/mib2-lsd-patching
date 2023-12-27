/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconContentSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconContent;

class DSICarAirConditionProxy$6
implements ISerializable {
    private final /* synthetic */ AirconContent val$content;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$6(DSICarAirConditionProxy dSICarAirConditionProxy, AirconContent airconContent) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$content = airconContent;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AirconContentSerializer.putOptionalAirconContent(iSerializer, this.val$content);
    }
}

