/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.comm.dsi.carplay.impl.AppStateSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayProxy;
import de.esolutions.fw.comm.dsi.carplay.impl.ResourceSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.Resource;

class DSICarplayProxy$4
implements ISerializable {
    private final /* synthetic */ Resource[] val$resources;
    private final /* synthetic */ AppState[] val$appStates;
    private final /* synthetic */ DSICarplayProxy this$0;

    DSICarplayProxy$4(DSICarplayProxy dSICarplayProxy, Resource[] resourceArray, AppState[] appStateArray) {
        this.this$0 = dSICarplayProxy;
        this.val$resources = resourceArray;
        this.val$appStates = appStateArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceSerializer.putOptionalResourceVarArray(iSerializer, this.val$resources);
        AppStateSerializer.putOptionalAppStateVarArray(iSerializer, this.val$appStates);
    }
}

