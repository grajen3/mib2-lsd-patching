/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.comm.dsi.telephoneng.impl.DSIMobileEquipmentProxy;
import de.esolutions.fw.comm.dsi.telephoneng.impl.MailboxDialingNumberSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;

class DSIMobileEquipmentProxy$3
implements ISerializable {
    private final /* synthetic */ MailboxDialingNumber[] val$telMailboxDialingNumbersArray;
    private final /* synthetic */ DSIMobileEquipmentProxy this$0;

    DSIMobileEquipmentProxy$3(DSIMobileEquipmentProxy dSIMobileEquipmentProxy, MailboxDialingNumber[] mailboxDialingNumberArray) {
        this.this$0 = dSIMobileEquipmentProxy;
        this.val$telMailboxDialingNumbersArray = mailboxDialingNumberArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MailboxDialingNumberSerializer.putOptionalMailboxDialingNumberVarArray(iSerializer, this.val$telMailboxDialingNumbersArray);
    }
}

