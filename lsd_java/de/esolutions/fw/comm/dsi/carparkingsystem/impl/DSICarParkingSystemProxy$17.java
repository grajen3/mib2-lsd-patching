/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

class DSICarParkingSystemProxy$17
implements ISerializable {
    private final /* synthetic */ CarArrayListUpdateInfo val$info;
    private final /* synthetic */ DSICarParkingSystemProxy this$0;

    DSICarParkingSystemProxy$17(DSICarParkingSystemProxy dSICarParkingSystemProxy, CarArrayListUpdateInfo carArrayListUpdateInfo) {
        this.this$0 = dSICarParkingSystemProxy;
        this.val$info = carArrayListUpdateInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, this.val$info);
    }
}

