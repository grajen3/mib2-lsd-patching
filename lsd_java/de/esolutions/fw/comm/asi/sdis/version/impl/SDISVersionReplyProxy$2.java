/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version.impl;

import de.esolutions.fw.comm.asi.sdis.version.impl.SDISVersionReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class SDISVersionReplyProxy$2
implements ISerializable {
    private final /* synthetic */ String val$SDISInterfaceVersion;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ SDISVersionReplyProxy this$0;

    SDISVersionReplyProxy$2(SDISVersionReplyProxy sDISVersionReplyProxy, String string, boolean bl) {
        this.this$0 = sDISVersionReplyProxy;
        this.val$SDISInterfaceVersion = string;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$SDISInterfaceVersion);
        iSerializer.putBool(this.val$isValid);
    }
}

