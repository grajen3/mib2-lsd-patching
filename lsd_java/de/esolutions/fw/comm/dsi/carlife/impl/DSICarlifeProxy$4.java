/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife.impl;

import de.esolutions.fw.comm.dsi.carlife.impl.AppStateSerializer;
import de.esolutions.fw.comm.dsi.carlife.impl.DSICarlifeProxy;
import de.esolutions.fw.comm.dsi.carlife.impl.ResourceSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.Resource;

class DSICarlifeProxy$4
implements ISerializable {
    private final /* synthetic */ Resource[] val$resources;
    private final /* synthetic */ AppState[] val$appStates;
    private final /* synthetic */ DSICarlifeProxy this$0;

    DSICarlifeProxy$4(DSICarlifeProxy dSICarlifeProxy, Resource[] resourceArray, AppState[] appStateArray) {
        this.this$0 = dSICarlifeProxy;
        this.val$resources = resourceArray;
        this.val$appStates = appStateArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceSerializer.putOptionalResourceVarArray(iSerializer, this.val$resources);
        AppStateSerializer.putOptionalAppStateVarArray(iSerializer, this.val$appStates);
    }
}

