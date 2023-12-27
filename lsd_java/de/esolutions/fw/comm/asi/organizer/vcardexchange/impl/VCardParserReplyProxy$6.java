/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class VCardParserReplyProxy$6
implements ISerializable {
    private final /* synthetic */ int val$dsiInstanceID;
    private final /* synthetic */ int val$targetDriveID;
    private final /* synthetic */ VCardParserReplyProxy this$0;

    VCardParserReplyProxy$6(VCardParserReplyProxy vCardParserReplyProxy, int n, int n2) {
        this.this$0 = vCardParserReplyProxy;
        this.val$dsiInstanceID = n;
        this.val$targetDriveID = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$dsiInstanceID);
        iSerializer.putInt32(this.val$targetDriveID);
    }
}

