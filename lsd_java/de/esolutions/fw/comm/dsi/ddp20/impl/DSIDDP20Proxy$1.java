/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20.impl;

import de.esolutions.fw.comm.dsi.ddp20.impl.DSIDDP20Proxy;
import de.esolutions.fw.comm.dsi.ddp20.impl.DisplayRequestSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.ddp20.DisplayRequest;

class DSIDDP20Proxy$1
implements ISerializable {
    private final /* synthetic */ DisplayRequest val$displayData;
    private final /* synthetic */ DSIDDP20Proxy this$0;

    DSIDDP20Proxy$1(DSIDDP20Proxy dSIDDP20Proxy, DisplayRequest displayRequest) {
        this.this$0 = dSIDDP20Proxy;
        this.val$displayData = displayRequest;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DisplayRequestSerializer.putOptionalDisplayRequest(iSerializer, this.val$displayData);
    }
}

