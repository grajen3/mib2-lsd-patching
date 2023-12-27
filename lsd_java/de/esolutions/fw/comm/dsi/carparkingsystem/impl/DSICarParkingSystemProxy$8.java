/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSDefaultModeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;

class DSICarParkingSystemProxy$8
implements ISerializable {
    private final /* synthetic */ VPSDefaultMode val$mode;
    private final /* synthetic */ DSICarParkingSystemProxy this$0;

    DSICarParkingSystemProxy$8(DSICarParkingSystemProxy dSICarParkingSystemProxy, VPSDefaultMode vPSDefaultMode) {
        this.this$0 = dSICarParkingSystemProxy;
        this.val$mode = vPSDefaultMode;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        VPSDefaultModeSerializer.putOptionalVPSDefaultMode(iSerializer, this.val$mode);
    }
}

