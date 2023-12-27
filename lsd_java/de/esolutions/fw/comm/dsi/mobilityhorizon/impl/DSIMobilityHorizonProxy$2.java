/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon.impl;

import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.DSIMobilityHorizonProxy;
import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.MobilityHorizonLocationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

class DSIMobilityHorizonProxy$2
implements ISerializable {
    private final /* synthetic */ MobilityHorizonLocation[] val$locations;
    private final /* synthetic */ DSIMobilityHorizonProxy this$0;

    DSIMobilityHorizonProxy$2(DSIMobilityHorizonProxy dSIMobilityHorizonProxy, MobilityHorizonLocation[] mobilityHorizonLocationArray) {
        this.this$0 = dSIMobilityHorizonProxy;
        this.val$locations = mobilityHorizonLocationArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MobilityHorizonLocationSerializer.putOptionalMobilityHorizonLocationVarArray(iSerializer, this.val$locations);
    }
}

