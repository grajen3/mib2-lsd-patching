/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.DSICarDriverAssistanceProxy;
import de.esolutions.fw.comm.dsi.global.impl.CarBCSpeedSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarBCSpeed;

class DSICarDriverAssistanceProxy$6
implements ISerializable {
    private final /* synthetic */ CarBCSpeed val$limit;
    private final /* synthetic */ DSICarDriverAssistanceProxy this$0;

    DSICarDriverAssistanceProxy$6(DSICarDriverAssistanceProxy dSICarDriverAssistanceProxy, CarBCSpeed carBCSpeed) {
        this.this$0 = dSICarDriverAssistanceProxy;
        this.val$limit = carBCSpeed;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CarBCSpeedSerializer.putOptionalCarBCSpeed(iSerializer, this.val$limit);
    }
}

