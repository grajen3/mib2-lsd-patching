/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOLearningDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOLearningData;

class DSICarComfortProxy$11
implements ISerializable {
    private final /* synthetic */ UGDOLearningData val$data;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$11(DSICarComfortProxy dSICarComfortProxy, UGDOLearningData uGDOLearningData) {
        this.this$0 = dSICarComfortProxy;
        this.val$data = uGDOLearningData;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UGDOLearningDataSerializer.putOptionalUGDOLearningData(iSerializer, this.val$data);
    }
}

