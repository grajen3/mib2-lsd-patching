/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class VCardParserReplyProxy$9
implements ISerializable {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ long val$bytes;
    private final /* synthetic */ VCardParserReplyProxy this$0;

    VCardParserReplyProxy$9(VCardParserReplyProxy vCardParserReplyProxy, int n, long l) {
        this.this$0 = vCardParserReplyProxy;
        this.val$success = n;
        this.val$bytes = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$success);
        iSerializer.putInt64(this.val$bytes);
    }
}

