/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy;
import de.esolutions.fw.comm.dsi.search.impl.RadioStationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.RadioStation;

class DSISearchProxy$7
implements ISerializable {
    private final /* synthetic */ int val$source;
    private final /* synthetic */ RadioStation[] val$radioStations;
    private final /* synthetic */ DSISearchProxy this$0;

    DSISearchProxy$7(DSISearchProxy dSISearchProxy, int n, RadioStation[] radioStationArray) {
        this.this$0 = dSISearchProxy;
        this.val$source = n;
        this.val$radioStations = radioStationArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$source);
        RadioStationSerializer.putOptionalRadioStationVarArray(iSerializer, this.val$radioStations);
    }
}

