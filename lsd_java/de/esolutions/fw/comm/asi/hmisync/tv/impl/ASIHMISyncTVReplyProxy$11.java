/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ParentalSettingsSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncTVReplyProxy$11
implements ISerializable {
    private final /* synthetic */ ParentalSettings val$ParentalSettings;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncTVReplyProxy this$0;

    ASIHMISyncTVReplyProxy$11(ASIHMISyncTVReplyProxy aSIHMISyncTVReplyProxy, ParentalSettings parentalSettings, boolean bl) {
        this.this$0 = aSIHMISyncTVReplyProxy;
        this.val$ParentalSettings = parentalSettings;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ParentalSettingsSerializer.putOptionalParentalSettings(iSerializer, this.val$ParentalSettings);
        iSerializer.putBool(this.val$isValid);
    }
}

