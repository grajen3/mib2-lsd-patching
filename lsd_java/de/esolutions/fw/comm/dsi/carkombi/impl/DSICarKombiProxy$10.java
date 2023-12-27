/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;

class DSICarKombiProxy$10
implements ISerializable {
    private final /* synthetic */ DCElementContentSelectionListUpdateInfo val$arrayHeader;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$10(DSICarKombiProxy dSICarKombiProxy, DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
        this.this$0 = dSICarKombiProxy;
        this.val$arrayHeader = dCElementContentSelectionListUpdateInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DCElementContentSelectionListUpdateInfoSerializer.putOptionalDCElementContentSelectionListUpdateInfo(iSerializer, this.val$arrayHeader);
    }
}

