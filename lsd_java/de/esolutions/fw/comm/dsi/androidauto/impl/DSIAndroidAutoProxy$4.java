/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto.impl;

import de.esolutions.fw.comm.dsi.androidauto.impl.AppStateSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.DSIAndroidAutoProxy;
import de.esolutions.fw.comm.dsi.androidauto.impl.ResourceSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.Resource;

class DSIAndroidAutoProxy$4
implements ISerializable {
    private final /* synthetic */ Resource[] val$resources;
    private final /* synthetic */ AppState[] val$appStates;
    private final /* synthetic */ DSIAndroidAutoProxy this$0;

    DSIAndroidAutoProxy$4(DSIAndroidAutoProxy dSIAndroidAutoProxy, Resource[] resourceArray, AppState[] appStateArray) {
        this.this$0 = dSIAndroidAutoProxy;
        this.val$resources = resourceArray;
        this.val$appStates = appStateArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceSerializer.putOptionalResourceVarArray(iSerializer, this.val$resources);
        AppStateSerializer.putOptionalAppStateVarArray(iSerializer, this.val$appStates);
    }
}

