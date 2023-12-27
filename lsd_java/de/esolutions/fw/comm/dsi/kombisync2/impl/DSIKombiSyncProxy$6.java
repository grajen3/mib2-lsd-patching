/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy;
import de.esolutions.fw.comm.dsi.kombisync2.impl.PopupStatusSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.PopupStatus;

class DSIKombiSyncProxy$6
implements ISerializable {
    private final /* synthetic */ PopupStatus val$status;
    private final /* synthetic */ DSIKombiSyncProxy this$0;

    DSIKombiSyncProxy$6(DSIKombiSyncProxy dSIKombiSyncProxy, PopupStatus popupStatus) {
        this.this$0 = dSIKombiSyncProxy;
        this.val$status = popupStatus;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PopupStatusSerializer.putOptionalPopupStatus(iSerializer, this.val$status);
    }
}

