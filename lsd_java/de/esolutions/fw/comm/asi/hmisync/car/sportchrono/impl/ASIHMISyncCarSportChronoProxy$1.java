/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoProxy;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCHeaderSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarSportChronoProxy$1
implements ISerializable {
    private final /* synthetic */ SCHeader val$track;
    private final /* synthetic */ String val$deviceId;
    private final /* synthetic */ ASIHMISyncCarSportChronoProxy this$0;

    ASIHMISyncCarSportChronoProxy$1(ASIHMISyncCarSportChronoProxy aSIHMISyncCarSportChronoProxy, SCHeader sCHeader, String string) {
        this.this$0 = aSIHMISyncCarSportChronoProxy;
        this.val$track = sCHeader;
        this.val$deviceId = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SCHeaderSerializer.putOptionalSCHeader(iSerializer, this.val$track);
        iSerializer.putOptionalString(this.val$deviceId);
    }
}

