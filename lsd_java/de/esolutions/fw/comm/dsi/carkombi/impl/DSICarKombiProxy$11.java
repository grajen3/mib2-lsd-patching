/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListRA1Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;

class DSICarKombiProxy$11
implements ISerializable {
    private final /* synthetic */ DCElementContentSelectionListUpdateInfo val$arrayHeader;
    private final /* synthetic */ DCElementContentSelectionListRA1[] val$data;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$11(DSICarKombiProxy dSICarKombiProxy, DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        this.this$0 = dSICarKombiProxy;
        this.val$arrayHeader = dCElementContentSelectionListUpdateInfo;
        this.val$data = dCElementContentSelectionListRA1Array;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DCElementContentSelectionListUpdateInfoSerializer.putOptionalDCElementContentSelectionListUpdateInfo(iSerializer, this.val$arrayHeader);
        DCElementContentSelectionListRA1Serializer.putOptionalDCElementContentSelectionListRA1VarArray(iSerializer, this.val$data);
    }
}

