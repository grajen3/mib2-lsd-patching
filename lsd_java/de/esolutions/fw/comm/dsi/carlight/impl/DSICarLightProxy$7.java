/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy;
import de.esolutions.fw.comm.dsi.carlight.impl.IntLightRGBColorListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;

class DSICarLightProxy$7
implements ISerializable {
    private final /* synthetic */ IntLightRGBColorListUpdateInfo val$info;
    private final /* synthetic */ DSICarLightProxy this$0;

    DSICarLightProxy$7(DSICarLightProxy dSICarLightProxy, IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
        this.this$0 = dSICarLightProxy;
        this.val$info = intLightRGBColorListUpdateInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        IntLightRGBColorListUpdateInfoSerializer.putOptionalIntLightRGBColorListUpdateInfo(iSerializer, this.val$info);
    }
}

