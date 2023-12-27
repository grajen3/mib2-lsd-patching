/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCRefLapDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarSportChronoReplyProxy$6
implements ISerializable {
    private final /* synthetic */ int val$uid;
    private final /* synthetic */ SCRefLapData[] val$data;
    private final /* synthetic */ int val$status;
    private final /* synthetic */ ASIHMISyncCarSportChronoReplyProxy this$0;

    ASIHMISyncCarSportChronoReplyProxy$6(ASIHMISyncCarSportChronoReplyProxy aSIHMISyncCarSportChronoReplyProxy, int n, SCRefLapData[] sCRefLapDataArray, int n2) {
        this.this$0 = aSIHMISyncCarSportChronoReplyProxy;
        this.val$uid = n;
        this.val$data = sCRefLapDataArray;
        this.val$status = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$uid);
        SCRefLapDataSerializer.putOptionalSCRefLapDataVarArray(iSerializer, this.val$data);
        iSerializer.putInt32(this.val$status);
    }
}

