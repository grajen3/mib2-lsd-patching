/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class VCardParserReplyProxy$8
implements ISerializable {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ String val$fullPath;
    private final /* synthetic */ VCardParserReplyProxy this$0;

    VCardParserReplyProxy$8(VCardParserReplyProxy vCardParserReplyProxy, int n, String string) {
        this.this$0 = vCardParserReplyProxy;
        this.val$success = n;
        this.val$fullPath = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$success);
        iSerializer.putOptionalString(this.val$fullPath);
    }
}

