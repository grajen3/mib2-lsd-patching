/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioProxy;
import de.esolutions.fw.comm.dsi.connectedradio.impl.RadioStationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.connectedradio.RadioStation;

class DSIHybridRadioProxy$1
implements ISerializable {
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ RadioStation[] val$radiostations;
    private final /* synthetic */ DSIHybridRadioProxy this$0;

    DSIHybridRadioProxy$1(DSIHybridRadioProxy dSIHybridRadioProxy, int n, RadioStation[] radioStationArray) {
        this.this$0 = dSIHybridRadioProxy;
        this.val$requestId = n;
        this.val$radiostations = radioStationArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$requestId);
        RadioStationSerializer.putOptionalRadioStationVarArray(iSerializer, this.val$radiostations);
    }
}

