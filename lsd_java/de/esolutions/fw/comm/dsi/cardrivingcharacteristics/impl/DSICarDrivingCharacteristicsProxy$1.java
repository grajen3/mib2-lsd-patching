/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaProgButtonSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.DSICarDrivingCharacteristicsProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;

class DSICarDrivingCharacteristicsProxy$1
implements ISerializable {
    private final /* synthetic */ CharismaProgButton val$progButton;
    private final /* synthetic */ DSICarDrivingCharacteristicsProxy this$0;

    DSICarDrivingCharacteristicsProxy$1(DSICarDrivingCharacteristicsProxy dSICarDrivingCharacteristicsProxy, CharismaProgButton charismaProgButton) {
        this.this$0 = dSICarDrivingCharacteristicsProxy;
        this.val$progButton = charismaProgButton;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CharismaProgButtonSerializer.putOptionalCharismaProgButton(iSerializer, this.val$progButton);
    }
}

