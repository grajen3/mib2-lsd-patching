/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncNavigationReplyProxy$2
implements ISerializable {
    private final /* synthetic */ String val$ASIVersion;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncNavigationReplyProxy this$0;

    ASIHMISyncNavigationReplyProxy$2(ASIHMISyncNavigationReplyProxy aSIHMISyncNavigationReplyProxy, String string, boolean bl) {
        this.this$0 = aSIHMISyncNavigationReplyProxy;
        this.val$ASIVersion = string;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$ASIVersion);
        iSerializer.putBool(this.val$isValid);
    }
}

