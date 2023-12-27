/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.comm.dsi.radiodata.impl.DSIRadioDataProxy;
import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationLogoRequestSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

class DSIRadioDataProxy$2
implements ISerializable {
    private final /* synthetic */ RadioStationLogoRequest[] val$stationLogosRequest;
    private final /* synthetic */ int val$sessionId;
    private final /* synthetic */ DSIRadioDataProxy this$0;

    DSIRadioDataProxy$2(DSIRadioDataProxy dSIRadioDataProxy, RadioStationLogoRequest[] radioStationLogoRequestArray, int n) {
        this.this$0 = dSIRadioDataProxy;
        this.val$stationLogosRequest = radioStationLogoRequestArray;
        this.val$sessionId = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RadioStationLogoRequestSerializer.putOptionalRadioStationLogoRequestVarArray(iSerializer, this.val$stationLogosRequest);
        iSerializer.putInt32(this.val$sessionId);
    }
}

