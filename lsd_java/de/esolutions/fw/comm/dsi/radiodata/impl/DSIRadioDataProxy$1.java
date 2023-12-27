/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.comm.dsi.radiodata.impl.DSIRadioDataProxy;
import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationDataRequestSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radiodata.RadioStationDataRequest;

class DSIRadioDataProxy$1
implements ISerializable {
    private final /* synthetic */ RadioStationDataRequest[] val$stationDataRequest;
    private final /* synthetic */ int val$sessionId;
    private final /* synthetic */ DSIRadioDataProxy this$0;

    DSIRadioDataProxy$1(DSIRadioDataProxy dSIRadioDataProxy, RadioStationDataRequest[] radioStationDataRequestArray, int n) {
        this.this$0 = dSIRadioDataProxy;
        this.val$stationDataRequest = radioStationDataRequestArray;
        this.val$sessionId = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RadioStationDataRequestSerializer.putOptionalRadioStationDataRequestVarArray(iSerializer, this.val$stationDataRequest);
        iSerializer.putInt32(this.val$sessionId);
    }
}

