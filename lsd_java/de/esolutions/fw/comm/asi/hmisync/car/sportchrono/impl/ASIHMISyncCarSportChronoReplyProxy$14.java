/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarSportChronoReplyProxy$14
implements ISerializable {
    private final /* synthetic */ int val$RecordMode;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarSportChronoReplyProxy this$0;

    ASIHMISyncCarSportChronoReplyProxy$14(ASIHMISyncCarSportChronoReplyProxy aSIHMISyncCarSportChronoReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncCarSportChronoReplyProxy;
        this.val$RecordMode = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$RecordMode);
        iSerializer.putBool(this.val$isValid);
    }
}

