/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.DestinationInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncNavigationReplyProxy$8
implements ISerializable {
    private final /* synthetic */ DestinationInfo[] val$DestinationsForGuidance;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncNavigationReplyProxy this$0;

    ASIHMISyncNavigationReplyProxy$8(ASIHMISyncNavigationReplyProxy aSIHMISyncNavigationReplyProxy, DestinationInfo[] destinationInfoArray, boolean bl) {
        this.this$0 = aSIHMISyncNavigationReplyProxy;
        this.val$DestinationsForGuidance = destinationInfoArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DestinationInfoSerializer.putOptionalDestinationInfoVarArray(iSerializer, this.val$DestinationsForGuidance);
        iSerializer.putBool(this.val$isValid);
    }
}

