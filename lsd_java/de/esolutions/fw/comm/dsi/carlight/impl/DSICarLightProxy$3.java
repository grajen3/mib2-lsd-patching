/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy;
import de.esolutions.fw.comm.dsi.carlight.impl.MotorwayBlinkingSettingsSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;

class DSICarLightProxy$3
implements ISerializable {
    private final /* synthetic */ MotorwayBlinkingSettings val$setting;
    private final /* synthetic */ DSICarLightProxy this$0;

    DSICarLightProxy$3(DSICarLightProxy dSICarLightProxy, MotorwayBlinkingSettings motorwayBlinkingSettings) {
        this.this$0 = dSICarLightProxy;
        this.val$setting = motorwayBlinkingSettings;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MotorwayBlinkingSettingsSerializer.putOptionalMotorwayBlinkingSettings(iSerializer, this.val$setting);
    }
}

