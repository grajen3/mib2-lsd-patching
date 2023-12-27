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

class DSIMessagingProxy$1
implements ISerializable {
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ int val$type;
    private final /* synthetic */ RecipientList val$recipients;
    private final /* synthetic */ String val$subject;
    private final /* synthetic */ String val$message;
    private final /* synthetic */ AttachmentInformation[] val$attachments;
    private final /* synthetic */ int val$messagingAccountID;
    private final /* synthetic */ DSIMessagingProxy this$0;

    DSIMessagingProxy$1(DSIMessagingProxy dSIMessagingProxy, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        this.this$0 = dSIMessagingProxy;
        this.val$requestId = n;
        this.val$type = n2;
        this.val$recipients = recipientList;
        this.val$subject = string;
        this.val$message = string2;
        this.val$attachments = attachmentInformationArray;
        this.val$messagingAccountID = n3;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$requestId);
        iSerializer.putInt32(this.val$type);
        RecipientListSerializer.putOptionalRecipientList(iSerializer, this.val$recipients);
        iSerializer.putOptionalString(this.val$subject);
        iSerializer.putOptionalString(this.val$message);
        AttachmentInformationSerializer.putOptionalAttachmentInformationVarArray(iSerializer, this.val$attachments);
        iSerializer.putInt32(this.val$messagingAccountID);
    }
}

