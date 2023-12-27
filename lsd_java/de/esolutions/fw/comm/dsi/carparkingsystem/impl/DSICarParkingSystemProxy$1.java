/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCSoundReproductionSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;

class DSICarParkingSystemProxy$1
implements ISerializable {
    private final /* synthetic */ PDCSoundReproduction val$state;
    private final /* synthetic */ DSICarParkingSystemProxy this$0;

    DSICarParkingSystemProxy$1(DSICarParkingSystemProxy dSICarParkingSystemProxy, PDCSoundReproduction pDCSoundReproduction) {
        this.this$0 = dSICarParkingSystemProxy;
        this.val$state = pDCSoundReproduction;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PDCSoundReproductionSerializer.putOptionalPDCSoundReproduction(iSerializer, this.val$state);
    }
}

