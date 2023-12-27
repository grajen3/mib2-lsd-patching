/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RGSBeltPretensionDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;

class DSICarComfortProxy$1
implements ISerializable {
    private final /* synthetic */ RGSBeltPretensionData val$beltPretensionData;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$1(DSICarComfortProxy dSICarComfortProxy, RGSBeltPretensionData rGSBeltPretensionData) {
        this.this$0 = dSICarComfortProxy;
        this.val$beltPretensionData = rGSBeltPretensionData;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RGSBeltPretensionDataSerializer.putOptionalRGSBeltPretensionData(iSerializer, this.val$beltPretensionData);
    }
}

