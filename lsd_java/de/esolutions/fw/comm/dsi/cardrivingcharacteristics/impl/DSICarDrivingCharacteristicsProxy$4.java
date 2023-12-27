/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.DSICarDrivingCharacteristicsProxy;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.TADMaxMinAngleResetSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset;

class DSICarDrivingCharacteristicsProxy$4
implements ISerializable {
    private final /* synthetic */ TADMaxMinAngleReset val$reset;
    private final /* synthetic */ DSICarDrivingCharacteristicsProxy this$0;

    DSICarDrivingCharacteristicsProxy$4(DSICarDrivingCharacteristicsProxy dSICarDrivingCharacteristicsProxy, TADMaxMinAngleReset tADMaxMinAngleReset) {
        this.this$0 = dSICarDrivingCharacteristicsProxy;
        this.val$reset = tADMaxMinAngleReset;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        TADMaxMinAngleResetSerializer.putOptionalTADMaxMinAngleReset(iSerializer, this.val$reset);
    }
}

