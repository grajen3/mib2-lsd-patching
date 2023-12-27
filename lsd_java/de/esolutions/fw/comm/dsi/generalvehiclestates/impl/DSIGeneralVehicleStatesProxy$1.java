/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates.impl;

import de.esolutions.fw.comm.dsi.generalvehiclestates.impl.DSIGeneralVehicleStatesProxy;
import de.esolutions.fw.comm.dsi.generalvehiclestates.impl.TLOInfoElementSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.generalvehiclestates.TLOInfoElement;

class DSIGeneralVehicleStatesProxy$1
implements ISerializable {
    private final /* synthetic */ int val$hmiState;
    private final /* synthetic */ int val$startStopInfo;
    private final /* synthetic */ TLOInfoElement[] val$infoList;
    private final /* synthetic */ DSIGeneralVehicleStatesProxy this$0;

    DSIGeneralVehicleStatesProxy$1(DSIGeneralVehicleStatesProxy dSIGeneralVehicleStatesProxy, int n, int n2, TLOInfoElement[] tLOInfoElementArray) {
        this.this$0 = dSIGeneralVehicleStatesProxy;
        this.val$hmiState = n;
        this.val$startStopInfo = n2;
        this.val$infoList = tLOInfoElementArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$hmiState);
        iSerializer.putInt32(this.val$startStopInfo);
        TLOInfoElementSerializer.putOptionalTLOInfoElementVarArray(iSerializer, this.val$infoList);
    }
}

