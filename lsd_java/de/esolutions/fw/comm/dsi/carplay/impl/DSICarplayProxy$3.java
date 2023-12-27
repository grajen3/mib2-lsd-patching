/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.comm.dsi.carplay.impl.AppStateRequestSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayProxy;
import de.esolutions.fw.comm.dsi.carplay.impl.ResourceRequestSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.ResourceRequest;

class DSICarplayProxy$3
implements ISerializable {
    private final /* synthetic */ ResourceRequest[] val$resources;
    private final /* synthetic */ AppStateRequest[] val$appStates;
    private final /* synthetic */ String val$reason;
    private final /* synthetic */ DSICarplayProxy this$0;

    DSICarplayProxy$3(DSICarplayProxy dSICarplayProxy, ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, String string) {
        this.this$0 = dSICarplayProxy;
        this.val$resources = resourceRequestArray;
        this.val$appStates = appStateRequestArray;
        this.val$reason = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceRequestSerializer.putOptionalResourceRequestVarArray(iSerializer, this.val$resources);
        AppStateRequestSerializer.putOptionalAppStateRequestVarArray(iSerializer, this.val$appStates);
        iSerializer.putOptionalString(this.val$reason);
    }
}

