/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioProxy;
import de.esolutions.fw.comm.dsi.connectedradio.impl.RadioStationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.connectedradio.RadioStation;

class DSIHybridRadioProxy$2
implements ISerializable {
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ RadioStation[] val$radiostations;
    private final /* synthetic */ int val$typeOfLogo;
    private final /* synthetic */ DSIHybridRadioProxy this$0;

    DSIHybridRadioProxy$2(DSIHybridRadioProxy dSIHybridRadioProxy, int n, RadioStation[] radioStationArray, int n2) {
        this.this$0 = dSIHybridRadioProxy;
        this.val$requestId = n;
        this.val$radiostations = radioStationArray;
        this.val$typeOfLogo = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$requestId);
        RadioStationSerializer.putOptionalRadioStationVarArray(iSerializer, this.val$radiostations);
        iSerializer.putInt32(this.val$typeOfLogo);
    }
}

