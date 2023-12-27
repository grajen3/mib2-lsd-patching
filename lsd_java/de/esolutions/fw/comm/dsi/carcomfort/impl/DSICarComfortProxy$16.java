/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOOpenDoorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;

class DSICarComfortProxy$16
implements ISerializable {
    private final /* synthetic */ UGDOOpenDoor val$data;
    private final /* synthetic */ DSICarComfortProxy this$0;

    DSICarComfortProxy$16(DSICarComfortProxy dSICarComfortProxy, UGDOOpenDoor uGDOOpenDoor) {
        this.this$0 = dSICarComfortProxy;
        this.val$data = uGDOOpenDoor;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UGDOOpenDoorSerializer.putOptionalUGDOOpenDoor(iSerializer, this.val$data);
    }
}

