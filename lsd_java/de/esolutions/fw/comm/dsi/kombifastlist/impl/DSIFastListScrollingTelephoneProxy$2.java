/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingTelephoneProxy;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataInitialsSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataInitials;

class DSIFastListScrollingTelephoneProxy$2
implements ISerializable {
    private final /* synthetic */ int val$senderHandle;
    private final /* synthetic */ int val$aSGID;
    private final /* synthetic */ int val$tAID;
    private final /* synthetic */ int val$requestedList;
    private final /* synthetic */ DataInitials[] val$data;
    private final /* synthetic */ DSIFastListScrollingTelephoneProxy this$0;

    DSIFastListScrollingTelephoneProxy$2(DSIFastListScrollingTelephoneProxy dSIFastListScrollingTelephoneProxy, int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
        this.this$0 = dSIFastListScrollingTelephoneProxy;
        this.val$senderHandle = n;
        this.val$aSGID = n2;
        this.val$tAID = n3;
        this.val$requestedList = n4;
        this.val$data = dataInitialsArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$senderHandle);
        iSerializer.putInt32(this.val$aSGID);
        iSerializer.putInt32(this.val$tAID);
        iSerializer.putInt32(this.val$requestedList);
        DataInitialsSerializer.putOptionalDataInitialsVarArray(iSerializer, this.val$data);
    }
}

