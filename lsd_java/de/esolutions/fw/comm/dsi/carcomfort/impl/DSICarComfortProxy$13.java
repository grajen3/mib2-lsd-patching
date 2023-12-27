/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOContentSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOContent;

class DSICarComfortProxy$13
implements ISerializable {
    private final /* synthetic */ UGDOContent val$content;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$13(DSICarComfortProxy dSICarComfortProxy, UGDOContent uGDOContent) {
        this.this$0 = dSICarComfortProxy;
        this.val$content = uGDOContent;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UGDOContentSerializer.putOptionalUGDOContent(iSerializer, this.val$content);
    }
}

