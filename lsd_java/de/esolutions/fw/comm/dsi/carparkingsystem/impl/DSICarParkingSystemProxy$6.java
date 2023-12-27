/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCPLASystemStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;

class DSICarParkingSystemProxy$6
implements ISerializable {
    private final /* synthetic */ PDCPLASystemState val$state;
    private final /* synthetic */ DSICarParkingSystemProxy this$0;

    DSICarParkingSystemProxy$6(DSICarParkingSystemProxy dSICarParkingSystemProxy, PDCPLASystemState pDCPLASystemState) {
        this.this$0 = dSICarParkingSystemProxy;
        this.val$state = pDCPLASystemState;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PDCPLASystemStateSerializer.putOptionalPDCPLASystemState(iSerializer, this.val$state);
    }
}

