/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy;
import de.esolutions.fw.comm.dsi.carlight.impl.IntLightRGBValuesSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightRGBValues;

class DSICarLightProxy$6
implements ISerializable {
    private final /* synthetic */ IntLightRGBValues val$color;
    private final /* synthetic */ DSICarLightProxy this$0;

    DSICarLightProxy$6(DSICarLightProxy dSICarLightProxy, IntLightRGBValues intLightRGBValues) {
        this.this$0 = dSICarLightProxy;
        this.val$color = intLightRGBValues;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        IntLightRGBValuesSerializer.putOptionalIntLightRGBValues(iSerializer, this.val$color);
    }
}

