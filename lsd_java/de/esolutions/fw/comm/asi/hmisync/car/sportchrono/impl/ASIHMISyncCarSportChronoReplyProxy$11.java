/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarSportChronoReplyProxy$11
implements ISerializable {
    private final /* synthetic */ int val$SCVisibilityState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarSportChronoReplyProxy this$0;

    ASIHMISyncCarSportChronoReplyProxy$11(ASIHMISyncCarSportChronoReplyProxy aSIHMISyncCarSportChronoReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncCarSportChronoReplyProxy;
        this.val$SCVisibilityState = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$SCVisibilityState);
        iSerializer.putBool(this.val$isValid);
    }
}

