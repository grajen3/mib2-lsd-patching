/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.comm.dsi.messaging.impl.AttachmentInformationSerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.DSIMessagingProxy;
import de.esolutions.fw.comm.dsi.messaging.impl.RecipientListSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.RecipientList;

class DSIMessagingProxy$2
implements ISerializable {
    private final /* synthetic */ String val$messageID;
    private final /* synthetic */ int val$type;
    private final /* synthetic */ RecipientList val$recipients;
    private final /* synthetic */ String val$subject;
    private final /* synthetic */ String val$body;
    private final /* synthetic */ int val$messagingAccountID;
    private final /* synthetic */ AttachmentInformation[] val$attachments;
    private final /* synthetic */ DSIMessagingProxy this$0;

    DSIMessagingProxy$2(DSIMessagingProxy dSIMessagingProxy, String string, int n, RecipientList recipientList, String string2, String string3, int n2, AttachmentInformation[] attachmentInformationArray) {
        this.this$0 = dSIMessagingProxy;
        this.val$messageID = string;
        this.val$type = n;
        this.val$recipients = recipientList;
        this.val$subject = string2;
        this.val$body = string3;
        this.val$messagingAccountID = n2;
        this.val$attachments = attachmentInformationArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$messageID);
        iSerializer.putInt32(this.val$type);
        RecipientListSerializer.putOptionalRecipientList(iSerializer, this.val$recipients);
        iSerializer.putOptionalString(this.val$subject);
        iSerializer.putOptionalString(this.val$body);
        iSerializer.putInt32(this.val$messagingAccountID);
        AttachmentInformationSerializer.putOptionalAttachmentInformationVarArray(iSerializer, this.val$attachments);
    }
}

