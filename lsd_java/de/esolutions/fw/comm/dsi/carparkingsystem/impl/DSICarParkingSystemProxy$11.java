/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSOPSOverlaySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;

class DSICarParkingSystemProxy$11
implements ISerializable {
    private final /* synthetic */ VPSOPSOverlay val$overlay;
    private final /* synthetic */ DSICarParkingSystemProxy this$0;

    DSICarParkingSystemProxy$11(DSICarParkingSystemProxy dSICarParkingSystemProxy, VPSOPSOverlay vPSOPSOverlay) {
        this.this$0 = dSICarParkingSystemProxy;
        this.val$overlay = vPSOPSOverlay;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        VPSOPSOverlaySerializer.putOptionalVPSOPSOverlay(iSerializer, this.val$overlay);
    }
}

