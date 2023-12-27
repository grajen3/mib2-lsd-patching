/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy;
import de.esolutions.fw.comm.dsi.carlight.impl.IntLightBrightnessSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightBrightness;

class DSICarLightProxy$4
implements ISerializable {
    private final /* synthetic */ IntLightBrightness val$data;
    private final /* synthetic */ DSICarLightProxy this$0;

    DSICarLightProxy$4(DSICarLightProxy dSICarLightProxy, IntLightBrightness intLightBrightness) {
        this.this$0 = dSICarLightProxy;
        this.val$data = intLightBrightness;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        IntLightBrightnessSerializer.putOptionalIntLightBrightness(iSerializer, this.val$data);
    }
}

