/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy;
import de.esolutions.fw.comm.dsi.kombisync2.impl.MenuStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.MenuState;

class DSIKombiSyncProxy$3
implements ISerializable {
    private final /* synthetic */ MenuState val$state;
    private final /* synthetic */ DSIKombiSyncProxy this$0;

    DSIKombiSyncProxy$3(DSIKombiSyncProxy dSIKombiSyncProxy, MenuState menuState) {
        this.this$0 = dSIKombiSyncProxy;
        this.val$state = menuState;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MenuStateSerializer.putOptionalMenuState(iSerializer, this.val$state);
    }
}

