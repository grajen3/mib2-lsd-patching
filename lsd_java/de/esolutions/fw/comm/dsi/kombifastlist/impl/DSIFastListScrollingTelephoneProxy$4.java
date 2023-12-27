/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingTelephoneProxy;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataCombinedNumbersSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;

class DSIFastListScrollingTelephoneProxy$4
implements ISerializable {
    private final /* synthetic */ int val$tag;
    private final /* synthetic */ int val$posY;
    private final /* synthetic */ DataCombinedNumbers[] val$data;
    private final /* synthetic */ DSIFastListScrollingTelephoneProxy this$0;

    DSIFastListScrollingTelephoneProxy$4(DSIFastListScrollingTelephoneProxy dSIFastListScrollingTelephoneProxy, int n, int n2, DataCombinedNumbers[] dataCombinedNumbersArray) {
        this.this$0 = dSIFastListScrollingTelephoneProxy;
        this.val$tag = n;
        this.val$posY = n2;
        this.val$data = dataCombinedNumbersArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$tag);
        iSerializer.putInt32(this.val$posY);
        DataCombinedNumbersSerializer.putOptionalDataCombinedNumbersVarArray(iSerializer, this.val$data);
    }
}

