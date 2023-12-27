/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncHeadUnitReplyProxy$16
implements ISerializable {
    private final /* synthetic */ short val$SplashScreenCoding;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncHeadUnitReplyProxy this$0;

    ASIHMISyncHeadUnitReplyProxy$16(ASIHMISyncHeadUnitReplyProxy aSIHMISyncHeadUnitReplyProxy, short s, boolean bl) {
        this.this$0 = aSIHMISyncHeadUnitReplyProxy;
        this.val$SplashScreenCoding = s;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt16(this.val$SplashScreenCoding);
        iSerializer.putBool(this.val$isValid);
    }
}

