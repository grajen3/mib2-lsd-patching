/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.DSICarDriverAssistanceProxy;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.NVObjectDetectionSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;

class DSICarDriverAssistanceProxy$3
implements ISerializable {
    private final /* synthetic */ NVObjectDetection val$detection;
    private final /* synthetic */ DSICarDriverAssistanceProxy this$0;

    DSICarDriverAssistanceProxy$3(DSICarDriverAssistanceProxy dSICarDriverAssistanceProxy, NVObjectDetection nVObjectDetection) {
        this.this$0 = dSICarDriverAssistanceProxy;
        this.val$detection = nVObjectDetection;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NVObjectDetectionSerializer.putOptionalNVObjectDetection(iSerializer, this.val$detection);
    }
}

