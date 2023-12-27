/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class VCardParserReplyProxy$4
implements ISerializable {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ String val$vcdFile;
    private final /* synthetic */ int val$dsiInstanceID;
    private final /* synthetic */ VCardParserReplyProxy this$0;

    VCardParserReplyProxy$4(VCardParserReplyProxy vCardParserReplyProxy, int n, String string, int n2) {
        this.this$0 = vCardParserReplyProxy;
        this.val$success = n;
        this.val$vcdFile = string;
        this.val$dsiInstanceID = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$success);
        iSerializer.putOptionalString(this.val$vcdFile);
        iSerializer.putInt32(this.val$dsiInstanceID);
    }
}

