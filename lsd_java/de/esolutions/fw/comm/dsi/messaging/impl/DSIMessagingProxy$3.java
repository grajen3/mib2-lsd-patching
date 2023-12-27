/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.comm.dsi.messaging.impl.AttachmentInformationSerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.DSIMessagingProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.messaging.AttachmentInformation;

class DSIMessagingProxy$3
implements ISerializable {
    private final /* synthetic */ AttachmentInformation val$attachment;
    private final /* synthetic */ DSIMessagingProxy this$0;

    DSIMessagingProxy$3(DSIMessagingProxy dSIMessagingProxy, AttachmentInformation attachmentInformation) {
        this.this$0 = dSIMessagingProxy;
        this.val$attachment = attachmentInformation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AttachmentInformationSerializer.putOptionalAttachmentInformation(iSerializer, this.val$attachment);
    }
}

