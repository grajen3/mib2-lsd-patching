/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.bc.BCTermGeneralData;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.BCTermGeneralDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarBordComputerReplyProxy$17
implements ISerializable {
    private final /* synthetic */ BCTermGeneralData val$BCShortTermGeneral;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarBordComputerReplyProxy this$0;

    ASIHMISyncCarBordComputerReplyProxy$17(ASIHMISyncCarBordComputerReplyProxy aSIHMISyncCarBordComputerReplyProxy, BCTermGeneralData bCTermGeneralData, boolean bl) {
        this.this$0 = aSIHMISyncCarBordComputerReplyProxy;
        this.val$BCShortTermGeneral = bCTermGeneralData;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BCTermGeneralDataSerializer.putOptionalBCTermGeneralData(iSerializer, this.val$BCShortTermGeneral);
        iSerializer.putBool(this.val$isValid);
    }
}

