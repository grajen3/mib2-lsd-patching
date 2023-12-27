/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DisplayStatusSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.DisplayStatus;

class DSIKombiSyncProxy$2
implements ISerializable {
    private final /* synthetic */ DisplayStatus val$status;
    private final /* synthetic */ DSIKombiSyncProxy this$0;

    DSIKombiSyncProxy$2(DSIKombiSyncProxy dSIKombiSyncProxy, DisplayStatus displayStatus) {
        this.this$0 = dSIKombiSyncProxy;
        this.val$status = displayStatus;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DisplayStatusSerializer.putOptionalDisplayStatus(iSerializer, this.val$status);
    }
}

