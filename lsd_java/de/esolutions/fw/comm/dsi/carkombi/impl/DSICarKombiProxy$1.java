/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

class DSICarKombiProxy$1
implements ISerializable {
    private final /* synthetic */ CarArrayListUpdateInfo val$arrayHeader;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$1(DSICarKombiProxy dSICarKombiProxy, CarArrayListUpdateInfo carArrayListUpdateInfo) {
        this.this$0 = dSICarKombiProxy;
        this.val$arrayHeader = carArrayListUpdateInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, this.val$arrayHeader);
    }
}

