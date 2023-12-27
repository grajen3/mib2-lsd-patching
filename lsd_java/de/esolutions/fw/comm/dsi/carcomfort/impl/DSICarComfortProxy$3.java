/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RGSLocalHazardInformationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;

class DSICarComfortProxy$3
implements ISerializable {
    private final /* synthetic */ RGSLocalHazardInformation val$data;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$3(DSICarComfortProxy dSICarComfortProxy, RGSLocalHazardInformation rGSLocalHazardInformation) {
        this.this$0 = dSICarComfortProxy;
        this.val$data = rGSLocalHazardInformation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RGSLocalHazardInformationSerializer.putOptionalRGSLocalHazardInformation(iSerializer, this.val$data);
    }
}

