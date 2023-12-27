/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCSoundSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCSound;

class DSICarParkingSystemProxy$3
implements ISerializable {
    private final /* synthetic */ PDCSound val$sound;
    private final /* synthetic */ DSICarParkingSystemProxy this$0;

    DSICarParkingSystemProxy$3(DSICarParkingSystemProxy dSICarParkingSystemProxy, PDCSound pDCSound) {
        this.this$0 = dSICarParkingSystemProxy;
        this.val$sound = pDCSound;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PDCSoundSerializer.putOptionalPDCSound(iSerializer, this.val$sound);
    }
}

