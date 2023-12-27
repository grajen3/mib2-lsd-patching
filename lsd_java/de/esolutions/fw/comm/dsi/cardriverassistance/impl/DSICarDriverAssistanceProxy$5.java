/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.DSICarDriverAssistanceProxy;
import de.esolutions.fw.comm.dsi.global.impl.CarBCSpeedSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarBCSpeed;

class DSICarDriverAssistanceProxy$5
implements ISerializable {
    private final /* synthetic */ boolean val$state;
    private final /* synthetic */ CarBCSpeed val$speed;
    private final /* synthetic */ DSICarDriverAssistanceProxy this$0;

    DSICarDriverAssistanceProxy$5(DSICarDriverAssistanceProxy dSICarDriverAssistanceProxy, boolean bl, CarBCSpeed carBCSpeed) {
        this.this$0 = dSICarDriverAssistanceProxy;
        this.val$state = bl;
        this.val$speed = carBCSpeed;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$state);
        CarBCSpeedSerializer.putOptionalCarBCSpeed(iSerializer, this.val$speed);
    }
}

