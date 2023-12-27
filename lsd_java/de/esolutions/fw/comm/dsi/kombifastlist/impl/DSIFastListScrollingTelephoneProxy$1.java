/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingTelephoneProxy;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataPhonebookSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataPhonebook;

class DSIFastListScrollingTelephoneProxy$1
implements ISerializable {
    private final /* synthetic */ int val$tag;
    private final /* synthetic */ int val$posY;
    private final /* synthetic */ DataPhonebook[] val$data;
    private final /* synthetic */ DSIFastListScrollingTelephoneProxy this$0;

    DSIFastListScrollingTelephoneProxy$1(DSIFastListScrollingTelephoneProxy dSIFastListScrollingTelephoneProxy, int n, int n2, DataPhonebook[] dataPhonebookArray) {
        this.this$0 = dSIFastListScrollingTelephoneProxy;
        this.val$tag = n;
        this.val$posY = n2;
        this.val$data = dataPhonebookArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$tag);
        iSerializer.putInt32(this.val$posY);
        DataPhonebookSerializer.putOptionalDataPhonebookVarArray(iSerializer, this.val$data);
    }
}

