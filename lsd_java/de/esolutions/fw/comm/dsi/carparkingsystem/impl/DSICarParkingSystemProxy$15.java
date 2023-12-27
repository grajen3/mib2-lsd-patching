/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCPiloPaSystemStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;

class DSICarParkingSystemProxy$15
implements ISerializable {
    private final /* synthetic */ PDCPiloPaSystemState val$state;
    private final /* synthetic */ DSICarParkingSystemProxy this$0;

    DSICarParkingSystemProxy$15(DSICarParkingSystemProxy dSICarParkingSystemProxy, PDCPiloPaSystemState pDCPiloPaSystemState) {
        this.this$0 = dSICarParkingSystemProxy;
        this.val$state = pDCPiloPaSystemState;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PDCPiloPaSystemStateSerializer.putOptionalPDCPiloPaSystemState(iSerializer, this.val$state);
    }
}

