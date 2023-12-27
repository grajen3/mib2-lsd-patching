/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSCameraCleaningSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;

class DSICarParkingSystemProxy$16
implements ISerializable {
    private final /* synthetic */ VPSCameraCleaning val$state;
    private final /* synthetic */ DSICarParkingSystemProxy this$0;

    DSICarParkingSystemProxy$16(DSICarParkingSystemProxy dSICarParkingSystemProxy, VPSCameraCleaning vPSCameraCleaning) {
        this.this$0 = dSICarParkingSystemProxy;
        this.val$state = vPSCameraCleaning;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        VPSCameraCleaningSerializer.putOptionalVPSCameraCleaning(iSerializer, this.val$state);
    }
}

