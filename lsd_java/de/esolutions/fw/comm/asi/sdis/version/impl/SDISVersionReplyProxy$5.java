/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version.impl;

import de.esolutions.fw.comm.asi.sdis.version.impl.SDISVersionReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class SDISVersionReplyProxy$5
implements ISerializable {
    private final /* synthetic */ String val$MUDetailedVersion;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ SDISVersionReplyProxy this$0;

    SDISVersionReplyProxy$5(SDISVersionReplyProxy sDISVersionReplyProxy, String string, boolean bl) {
        this.this$0 = sDISVersionReplyProxy;
        this.val$MUDetailedVersion = string;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$MUDetailedVersion);
        iSerializer.putBool(this.val$isValid);
    }
}

