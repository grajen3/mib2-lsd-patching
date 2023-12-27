/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.CarPositionSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncNavigationReplyProxy$6
implements ISerializable {
    private final /* synthetic */ CarPosition val$CarPosition;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncNavigationReplyProxy this$0;

    ASIHMISyncNavigationReplyProxy$6(ASIHMISyncNavigationReplyProxy aSIHMISyncNavigationReplyProxy, CarPosition carPosition, boolean bl) {
        this.this$0 = aSIHMISyncNavigationReplyProxy;
        this.val$CarPosition = carPosition;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CarPositionSerializer.putOptionalCarPosition(iSerializer, this.val$CarPosition);
        iSerializer.putBool(this.val$isValid);
    }
}

