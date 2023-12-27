/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.comm.dsi.kombisync.impl.DSIKombiSyncProxy;
import de.esolutions.fw.comm.dsi.kombisync.impl.MMIDisplayRequestSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync.MMIDisplayRequest;

class DSIKombiSyncProxy$2
implements ISerializable {
    private final /* synthetic */ MMIDisplayRequest val$mmiDisplayRequest;
    private final /* synthetic */ DSIKombiSyncProxy this$0;

    DSIKombiSyncProxy$2(DSIKombiSyncProxy dSIKombiSyncProxy, MMIDisplayRequest mMIDisplayRequest) {
        this.this$0 = dSIKombiSyncProxy;
        this.val$mmiDisplayRequest = mMIDisplayRequest;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MMIDisplayRequestSerializer.putOptionalMMIDisplayRequest(iSerializer, this.val$mmiDisplayRequest);
    }
}

