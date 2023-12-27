/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListRA2Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;

class DSICarKombiProxy$12
implements ISerializable {
    private final /* synthetic */ DCElementContentSelectionListUpdateInfo val$arrayHeader;
    private final /* synthetic */ DCElementContentSelectionListRA2[] val$data;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$12(DSICarKombiProxy dSICarKombiProxy, DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
        this.this$0 = dSICarKombiProxy;
        this.val$arrayHeader = dCElementContentSelectionListUpdateInfo;
        this.val$data = dCElementContentSelectionListRA2Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DCElementContentSelectionListUpdateInfoSerializer.putOptionalDCElementContentSelectionListUpdateInfo(iSerializer, this.val$arrayHeader);
        DCElementContentSelectionListRA2Serializer.putOptionalDCElementContentSelectionListRA2VarArray(iSerializer, this.val$data);
    }
}

