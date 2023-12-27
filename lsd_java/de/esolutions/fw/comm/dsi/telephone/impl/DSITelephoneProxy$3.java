/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.comm.dsi.telephone.impl.DSITelephoneProxy;
import de.esolutions.fw.comm.dsi.telephone.impl.MailboxDialingNumberSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.MailboxDialingNumber;

class DSITelephoneProxy$3
implements ISerializable {
    private final /* synthetic */ MailboxDialingNumber[] val$telMailboxDialingNumbersArray;
    private final /* synthetic */ DSITelephoneProxy this$0;

    DSITelephoneProxy$3(DSITelephoneProxy dSITelephoneProxy, MailboxDialingNumber[] mailboxDialingNumberArray) {
        this.this$0 = dSITelephoneProxy;
        this.val$telMailboxDialingNumbersArray = mailboxDialingNumberArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MailboxDialingNumberSerializer.putOptionalMailboxDialingNumberVarArray(iSerializer, this.val$telMailboxDialingNumbersArray);
    }
}

