/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingAudioProxy;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataReceptionListSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataReceptionList;

class DSIFastListScrollingAudioProxy$3
implements ISerializable {
    private final /* synthetic */ long val$tag;
    private final /* synthetic */ int val$posY;
    private final /* synthetic */ DataReceptionList[] val$data;
    private final /* synthetic */ DSIFastListScrollingAudioProxy this$0;

    DSIFastListScrollingAudioProxy$3(DSIFastListScrollingAudioProxy dSIFastListScrollingAudioProxy, long l, int n, DataReceptionList[] dataReceptionListArray) {
        this.this$0 = dSIFastListScrollingAudioProxy;
        this.val$tag = l;
        this.val$posY = n;
        this.val$data = dataReceptionListArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt64(this.val$tag);
        iSerializer.putInt32(this.val$posY);
        DataReceptionListSerializer.putOptionalDataReceptionListVarArray(iSerializer, this.val$data);
    }
}

