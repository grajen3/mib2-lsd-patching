/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.AWVEmergencyBrakeSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.DSICarDriverAssistanceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;

class DSICarDriverAssistanceProxy$2
implements ISerializable {
    private final /* synthetic */ AWVEmergencyBrake val$aWVEmergencyBrake;
    private final /* synthetic */ DSICarDriverAssistanceProxy this$0;

    DSICarDriverAssistanceProxy$2(DSICarDriverAssistanceProxy dSICarDriverAssistanceProxy, AWVEmergencyBrake aWVEmergencyBrake) {
        this.this$0 = dSICarDriverAssistanceProxy;
        this.val$aWVEmergencyBrake = aWVEmergencyBrake;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AWVEmergencyBrakeSerializer.putOptionalAWVEmergencyBrake(iSerializer, this.val$aWVEmergencyBrake);
    }
}

