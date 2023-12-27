/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSDynParkingModeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;

class DSICarParkingSystemProxy$12
implements ISerializable {
    private final /* synthetic */ VPSDynParkingMode val$dynmode;
    private final /* synthetic */ DSICarParkingSystemProxy this$0;

    DSICarParkingSystemProxy$12(DSICarParkingSystemProxy dSICarParkingSystemProxy, VPSDynParkingMode vPSDynParkingMode) {
        this.this$0 = dSICarParkingSystemProxy;
        this.val$dynmode = vPSDynParkingMode;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        VPSDynParkingModeSerializer.putOptionalVPSDynParkingMode(iSerializer, this.val$dynmode);
    }
}

