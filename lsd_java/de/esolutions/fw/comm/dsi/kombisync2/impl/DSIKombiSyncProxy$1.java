/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DisplayRequestResponseSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;

class DSIKombiSyncProxy$1
implements ISerializable {
    private final /* synthetic */ DisplayRequestResponse val$mmiDisplayRequestResponse;
    private final /* synthetic */ DSIKombiSyncProxy this$0;

    DSIKombiSyncProxy$1(DSIKombiSyncProxy dSIKombiSyncProxy, DisplayRequestResponse displayRequestResponse) {
        this.this$0 = dSIKombiSyncProxy;
        this.val$mmiDisplayRequestResponse = displayRequestResponse;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DisplayRequestResponseSerializer.putOptionalDisplayRequestResponse(iSerializer, this.val$mmiDisplayRequestResponse);
    }
}

