/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.impl;

import de.esolutions.fw.comm.asi.hmisync.car.impl.ASIHMISyncCarGenericReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarGenericReplyProxy$1
implements ISerializable {
    private final /* synthetic */ String val$ASIVersion;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarGenericReplyProxy this$0;

    ASIHMISyncCarGenericReplyProxy$1(ASIHMISyncCarGenericReplyProxy aSIHMISyncCarGenericReplyProxy, String string, boolean bl) {
        this.this$0 = aSIHMISyncCarGenericReplyProxy;
        this.val$ASIVersion = string;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$ASIVersion);
        iSerializer.putBool(this.val$isValid);
    }
}

