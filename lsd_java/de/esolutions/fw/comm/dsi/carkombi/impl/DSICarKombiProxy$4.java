/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.BCVehicleStateUpdateInfoAHSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;

class DSICarKombiProxy$4
implements ISerializable {
    private final /* synthetic */ BCVehicleStateUpdateInfoAH val$vehicleStateUpdateInfo;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$4(DSICarKombiProxy dSICarKombiProxy, BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH) {
        this.this$0 = dSICarKombiProxy;
        this.val$vehicleStateUpdateInfo = bCVehicleStateUpdateInfoAH;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BCVehicleStateUpdateInfoAHSerializer.putOptionalBCVehicleStateUpdateInfoAH(iSerializer, this.val$vehicleStateUpdateInfo);
    }
}

