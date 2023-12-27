/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class VCardParserReplyProxy$5
implements ISerializable {
    private final /* synthetic */ int val$dsiInstanceID;
    private final /* synthetic */ VCardParserReplyProxy this$0;

    VCardParserReplyProxy$5(VCardParserReplyProxy vCardParserReplyProxy, int n) {
        this.this$0 = vCardParserReplyProxy;
        this.val$dsiInstanceID = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$dsiInstanceID);
    }
}

