/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.comm.dsi.kombisync.impl.DSIKombiSyncProxy;
import de.esolutions.fw.comm.dsi.kombisync.impl.MMIDisplayStatusSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync.MMIDisplayStatus;

class DSIKombiSyncProxy$1
implements ISerializable {
    private final /* synthetic */ MMIDisplayStatus val$status;
    private final /* synthetic */ DSIKombiSyncProxy this$0;

    DSIKombiSyncProxy$1(DSIKombiSyncProxy dSIKombiSyncProxy, MMIDisplayStatus mMIDisplayStatus) {
        this.this$0 = dSIKombiSyncProxy;
        this.val$status = mMIDisplayStatus;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MMIDisplayStatusSerializer.putOptionalMMIDisplayStatus(iSerializer, this.val$status);
    }
}

