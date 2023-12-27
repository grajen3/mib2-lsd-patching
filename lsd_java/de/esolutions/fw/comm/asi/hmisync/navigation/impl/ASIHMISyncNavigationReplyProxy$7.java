/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.DestinationInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncNavigationReplyProxy$7
implements ISerializable {
    private final /* synthetic */ DestinationInfo[] val$DestinationInfo;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncNavigationReplyProxy this$0;

    ASIHMISyncNavigationReplyProxy$7(ASIHMISyncNavigationReplyProxy aSIHMISyncNavigationReplyProxy, DestinationInfo[] destinationInfoArray, boolean bl) {
        this.this$0 = aSIHMISyncNavigationReplyProxy;
        this.val$DestinationInfo = destinationInfoArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DestinationInfoSerializer.putOptionalDestinationInfoVarArray(iSerializer, this.val$DestinationInfo);
        iSerializer.putBool(this.val$isValid);
    }
}

