/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.NextDestinationInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncNavigationReplyProxy$9
implements ISerializable {
    private final /* synthetic */ NextDestinationInfo val$NextDestinationInfo;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncNavigationReplyProxy this$0;

    ASIHMISyncNavigationReplyProxy$9(ASIHMISyncNavigationReplyProxy aSIHMISyncNavigationReplyProxy, NextDestinationInfo nextDestinationInfo, boolean bl) {
        this.this$0 = aSIHMISyncNavigationReplyProxy;
        this.val$NextDestinationInfo = nextDestinationInfo;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NextDestinationInfoSerializer.putOptionalNextDestinationInfo(iSerializer, this.val$NextDestinationInfo);
        iSerializer.putBool(this.val$isValid);
    }
}

