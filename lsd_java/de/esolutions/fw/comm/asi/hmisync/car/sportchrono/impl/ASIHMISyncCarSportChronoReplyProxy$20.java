/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCRefLapHeaderSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarSportChronoReplyProxy$20
implements ISerializable {
    private final /* synthetic */ SCRefLapHeader[] val$ReferenceLapList;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarSportChronoReplyProxy this$0;

    ASIHMISyncCarSportChronoReplyProxy$20(ASIHMISyncCarSportChronoReplyProxy aSIHMISyncCarSportChronoReplyProxy, SCRefLapHeader[] sCRefLapHeaderArray, boolean bl) {
        this.this$0 = aSIHMISyncCarSportChronoReplyProxy;
        this.val$ReferenceLapList = sCRefLapHeaderArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SCRefLapHeaderSerializer.putOptionalSCRefLapHeaderVarArray(iSerializer, this.val$ReferenceLapList);
        iSerializer.putBool(this.val$isValid);
    }
}

