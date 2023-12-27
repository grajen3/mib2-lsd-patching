/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy;
import de.esolutions.fw.comm.dsi.kombisync2.impl.PopupActionRequestResponseSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;

class DSIKombiSyncProxy$5
implements ISerializable {
    private final /* synthetic */ PopupActionRequestResponse val$mmiPopupResponse;
    private final /* synthetic */ DSIKombiSyncProxy this$0;

    DSIKombiSyncProxy$5(DSIKombiSyncProxy dSIKombiSyncProxy, PopupActionRequestResponse popupActionRequestResponse) {
        this.this$0 = dSIKombiSyncProxy;
        this.val$mmiPopupResponse = popupActionRequestResponse;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PopupActionRequestResponseSerializer.putOptionalPopupActionRequestResponse(iSerializer, this.val$mmiPopupResponse);
    }
}

