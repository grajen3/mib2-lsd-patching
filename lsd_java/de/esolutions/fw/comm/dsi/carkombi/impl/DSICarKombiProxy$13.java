/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;

class DSICarKombiProxy$13
implements ISerializable {
    private final /* synthetic */ DCElementContentSelectionListUpdateInfo val$arrayHeader;
    private final /* synthetic */ int[] val$data;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$13(DSICarKombiProxy dSICarKombiProxy, DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        this.this$0 = dSICarKombiProxy;
        this.val$arrayHeader = dCElementContentSelectionListUpdateInfo;
        this.val$data = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DCElementContentSelectionListUpdateInfoSerializer.putOptionalDCElementContentSelectionListUpdateInfo(iSerializer, this.val$arrayHeader);
        iSerializer.putOptionalInt32VarArray(this.val$data);
    }
}

