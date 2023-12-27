/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIOnlineRadioProxy;
import de.esolutions.fw.comm.dsi.connectedradio.impl.RadioStationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.connectedradio.RadioStation;

class DSIOnlineRadioProxy$2
implements ISerializable {
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ RadioStation val$radioStation;
    private final /* synthetic */ DSIOnlineRadioProxy this$0;

    DSIOnlineRadioProxy$2(DSIOnlineRadioProxy dSIOnlineRadioProxy, int n, RadioStation radioStation) {
        this.this$0 = dSIOnlineRadioProxy;
        this.val$requestId = n;
        this.val$radioStation = radioStation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$requestId);
        RadioStationSerializer.putOptionalRadioStation(iSerializer, this.val$radioStation);
    }
}

