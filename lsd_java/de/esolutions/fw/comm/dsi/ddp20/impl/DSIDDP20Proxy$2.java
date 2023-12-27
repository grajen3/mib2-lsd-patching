/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20.impl;

import de.esolutions.fw.comm.dsi.ddp20.impl.DSIDDP20Proxy;
import de.esolutions.fw.comm.dsi.ddp20.impl.UpdateRequestSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.ddp20.UpdateRequest;

class DSIDDP20Proxy$2
implements ISerializable {
    private final /* synthetic */ UpdateRequest val$updateData;
    private final /* synthetic */ DSIDDP20Proxy this$0;

    DSIDDP20Proxy$2(DSIDDP20Proxy dSIDDP20Proxy, UpdateRequest updateRequest) {
        this.this$0 = dSIDDP20Proxy;
        this.val$updateData = updateRequest;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UpdateRequestSerializer.putOptionalUpdateRequest(iSerializer, this.val$updateData);
    }
}

