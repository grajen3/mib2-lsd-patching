/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationProxy;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.DestinationInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncNavigationProxy$1
implements ISerializable {
    private final /* synthetic */ DestinationInfo[] val$DestinationInfo;
    private final /* synthetic */ ASIHMISyncNavigationProxy this$0;

    ASIHMISyncNavigationProxy$1(ASIHMISyncNavigationProxy aSIHMISyncNavigationProxy, DestinationInfo[] destinationInfoArray) {
        this.this$0 = aSIHMISyncNavigationProxy;
        this.val$DestinationInfo = destinationInfoArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DestinationInfoSerializer.putOptionalDestinationInfoVarArray(iSerializer, this.val$DestinationInfo);
    }
}

