/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.DSICarDriverAssistanceProxy;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.TSDRoadSignFilterSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;

class DSICarDriverAssistanceProxy$4
implements ISerializable {
    private final /* synthetic */ TSDRoadSignFilter val$roadSignFilter;
    private final /* synthetic */ DSICarDriverAssistanceProxy this$0;

    DSICarDriverAssistanceProxy$4(DSICarDriverAssistanceProxy dSICarDriverAssistanceProxy, TSDRoadSignFilter tSDRoadSignFilter) {
        this.this$0 = dSICarDriverAssistanceProxy;
        this.val$roadSignFilter = tSDRoadSignFilter;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        TSDRoadSignFilterSerializer.putOptionalTSDRoadSignFilter(iSerializer, this.val$roadSignFilter);
    }
}

