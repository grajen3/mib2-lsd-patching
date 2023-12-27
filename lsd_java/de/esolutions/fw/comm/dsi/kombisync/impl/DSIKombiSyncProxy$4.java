/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.comm.dsi.kombisync.impl.DSIKombiSyncProxy;
import de.esolutions.fw.comm.dsi.kombisync.impl.MMIPopupRequestSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync.MMIPopupRequest;

class DSIKombiSyncProxy$4
implements ISerializable {
    private final /* synthetic */ MMIPopupRequest val$mmiPopupRequest;
    private final /* synthetic */ DSIKombiSyncProxy this$0;

    DSIKombiSyncProxy$4(DSIKombiSyncProxy dSIKombiSyncProxy, MMIPopupRequest mMIPopupRequest) {
        this.this$0 = dSIKombiSyncProxy;
        this.val$mmiPopupRequest = mMIPopupRequest;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MMIPopupRequestSerializer.putOptionalMMIPopupRequest(iSerializer, this.val$mmiPopupRequest);
    }
}

