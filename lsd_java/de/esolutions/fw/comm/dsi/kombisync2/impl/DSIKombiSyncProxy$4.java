/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy;
import de.esolutions.fw.comm.dsi.kombisync2.impl.PopupRegisterRequestResponseSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;

class DSIKombiSyncProxy$4
implements ISerializable {
    private final /* synthetic */ PopupRegisterRequestResponse val$mmiPopupRequest;
    private final /* synthetic */ DSIKombiSyncProxy this$0;

    DSIKombiSyncProxy$4(DSIKombiSyncProxy dSIKombiSyncProxy, PopupRegisterRequestResponse popupRegisterRequestResponse) {
        this.this$0 = dSIKombiSyncProxy;
        this.val$mmiPopupRequest = popupRegisterRequestResponse;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PopupRegisterRequestResponseSerializer.putOptionalPopupRegisterRequestResponse(iSerializer, this.val$mmiPopupRequest);
    }
}

