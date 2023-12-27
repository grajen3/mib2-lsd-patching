/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OocDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.ooc.impl.sTemperatureMMXSerializer;
import de.esolutions.fw.comm.asi.diagnosis.ooc.sTemperatureMMX;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2OocDiagServiceProxy$2
implements ISerializable {
    private final /* synthetic */ sTemperatureMMX val$temperature;
    private final /* synthetic */ MMX2OocDiagServiceProxy this$0;

    MMX2OocDiagServiceProxy$2(MMX2OocDiagServiceProxy mMX2OocDiagServiceProxy, sTemperatureMMX sTemperatureMMX2) {
        this.this$0 = mMX2OocDiagServiceProxy;
        this.val$temperature = sTemperatureMMX2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sTemperatureMMXSerializer.putOptionalsTemperatureMMX(iSerializer, this.val$temperature);
    }
}

