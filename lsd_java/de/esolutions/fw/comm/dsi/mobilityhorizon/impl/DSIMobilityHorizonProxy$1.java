/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon.impl;

import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.ConsumptionInfoSerializer;
import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.DSIMobilityHorizonProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;

class DSIMobilityHorizonProxy$1
implements ISerializable {
    private final /* synthetic */ ConsumptionInfo[] val$consumptionInfo;
    private final /* synthetic */ DSIMobilityHorizonProxy this$0;

    DSIMobilityHorizonProxy$1(DSIMobilityHorizonProxy dSIMobilityHorizonProxy, ConsumptionInfo[] consumptionInfoArray) {
        this.this$0 = dSIMobilityHorizonProxy;
        this.val$consumptionInfo = consumptionInfoArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ConsumptionInfoSerializer.putOptionalConsumptionInfoVarArray(iSerializer, this.val$consumptionInfo);
    }
}

