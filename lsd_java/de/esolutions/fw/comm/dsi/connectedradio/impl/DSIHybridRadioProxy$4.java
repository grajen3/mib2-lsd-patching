/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioProxy;
import de.esolutions.fw.comm.dsi.connectedradio.impl.RadioStationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.connectedradio.RadioStation;

class DSIHybridRadioProxy$4
implements ISerializable {
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ RadioStation val$radiostation;
    private final /* synthetic */ int val$width;
    private final /* synthetic */ int val$height;
    private final /* synthetic */ DSIHybridRadioProxy this$0;

    DSIHybridRadioProxy$4(DSIHybridRadioProxy dSIHybridRadioProxy, int n, RadioStation radioStation, int n2, int n3) {
        this.this$0 = dSIHybridRadioProxy;
        this.val$requestId = n;
        this.val$radiostation = radioStation;
        this.val$width = n2;
        this.val$height = n3;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$requestId);
        RadioStationSerializer.putOptionalRadioStation(iSerializer, this.val$radiostation);
        iSerializer.putInt32(this.val$width);
        iSerializer.putInt32(this.val$height);
    }
}

