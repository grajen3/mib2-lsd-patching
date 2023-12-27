/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.ACCDistanceWarningSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.DSICarDriverAssistanceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;

class DSICarDriverAssistanceProxy$1
implements ISerializable {
    private final /* synthetic */ ACCDistanceWarning val$warning;
    private final /* synthetic */ DSICarDriverAssistanceProxy this$0;

    DSICarDriverAssistanceProxy$1(DSICarDriverAssistanceProxy dSICarDriverAssistanceProxy, ACCDistanceWarning aCCDistanceWarning) {
        this.this$0 = dSICarDriverAssistanceProxy;
        this.val$warning = aCCDistanceWarning;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ACCDistanceWarningSerializer.putOptionalACCDistanceWarning(iSerializer, this.val$warning);
    }
}

