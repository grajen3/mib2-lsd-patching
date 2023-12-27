/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.comm.dsi.telephoneng.impl.CFRequestDataSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.DSIMobileEquipmentProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.CFRequestData;

class DSIMobileEquipmentProxy$2
implements ISerializable {
    private final /* synthetic */ CFRequestData[] val$telCFRequestData;
    private final /* synthetic */ DSIMobileEquipmentProxy this$0;

    DSIMobileEquipmentProxy$2(DSIMobileEquipmentProxy dSIMobileEquipmentProxy, CFRequestData[] cFRequestDataArray) {
        this.this$0 = dSIMobileEquipmentProxy;
        this.val$telCFRequestData = cFRequestDataArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CFRequestDataSerializer.putOptionalCFRequestDataVarArray(iSerializer, this.val$telCFRequestData);
    }
}

